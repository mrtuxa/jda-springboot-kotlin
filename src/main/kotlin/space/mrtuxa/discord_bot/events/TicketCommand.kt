package space.mrtuxa.discord_bot.events

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.emoji.Emoji
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.components.buttons.Button
import space.mrtuxa.discord_bot.util.Helper

/**
 * Fuck this piece of shit it sends the messages 2 times

class TicketCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name == "set-ticket") {
            val embed : EmbedBuilder = EmbedBuilder()
            embed.setTitle("Ticket Support")
            embed.setDescription("Please react to this message to create a ticket!")
            embed.setColor(0x00FF00)
            embed.setFooter("Ticket Support", event.user.avatarUrl)
            embed.setTimestamp(event.timeCreated)
            event.channel.sendMessageEmbeds(embed.build()).setActionRow(Button.success("openTicket", "Open Ticket")).queue()
        }
    }
}
*/