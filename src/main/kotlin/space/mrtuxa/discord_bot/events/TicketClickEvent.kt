package space.mrtuxa.discord_bot.events

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.components.buttons.Button
import space.mrtuxa.discord_bot.util.Helper
import java.util.EnumSet


/**
 * @see space.mrtuxa.discord_bot.events.TicketCommand
 */
class TicketClickEvent : ListenerAdapter() {
    override fun onButtonInteraction(event: ButtonInteractionEvent) {
        event.deferEdit().queue()
        if (event.componentId == "openTicket") {
            val min = 1000
            val max = 99999
            val randomInt = (Math.random() * (max - min + 1) + min).toInt()
            val guild = event.guild
            val embed : EmbedBuilder = EmbedBuilder()
            embed.setTitle("Ticket Support")
            embed.setDescription("Please wait for a staff member to help you!")
            embed.setColor(0x00FF00)
            embed.setFooter("Ticket Support", event.user.avatarUrl)
            embed.setTimestamp(event.timeCreated)
            val channel = guild?.createTextChannel("ticket-$randomInt")?.setTopic("Ticket Support")?.queue()
            event.member?.let {
                guild?.createTextChannel("ticket-${event.user.name}-$randomInt",
                    Helper.getEnv("TICKET_CATEGORY")?.let { guild.getCategoryById(it) })
                    ?.addPermissionOverride(it, EnumSet.of(Permission.VIEW_CHANNEL), null)
                    ?.addPermissionOverride(guild.publicRole, null, EnumSet.of(Permission.VIEW_CHANNEL))
                    ?.addPermissionOverride(guild.getRoleById(Helper.getEnv("TICKET_ACCESS")!!)!!, EnumSet.of(Permission.VIEW_CHANNEL), null)
                    ?.complete()?.sendMessageEmbeds(embed.build())?.setActionRow(closeButton())?.queue()

                val team : EmbedBuilder = EmbedBuilder()
                team.setTitle("Ticket Support")
                team.setDescription("A new ticket has been created by ${event.user.name}!")
                team.setColor(0x00FF00)
                team.setFooter("Ticket Support", event.user.avatarUrl)
                team.setTimestamp(event.timeCreated)
                guild?.getTextChannelById(Helper.getEnv("LOG_CHANNEL")!!)?.sendMessageEmbeds(team.build())?.queue()
            }
        } else if (event.componentId == "closeTicket") {
            if (event.member?.roles?.contains(event.guild?.getRoleById(Helper.getEnv("TICKET_ACCESS")!!))!!) {
                event.channel.delete().queue()
            } else {
                event.reply("You don't have permission to close this ticket!").setEphemeral(true).queue()
            }
        }
    }

    private fun closeButton() : Button {
        return Button.danger("closeTicket", "Close Ticket")
    }

}