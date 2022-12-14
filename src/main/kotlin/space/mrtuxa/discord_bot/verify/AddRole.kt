package space.mrtuxa.discord_bot.verify

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class AddRole : ListenerAdapter() {
    override fun onButtonInteraction(event: ButtonInteractionEvent) {
        if (event.componentId == "verifyMessage") {
            val guild = event.guild
            val role = guild?.getRoleById("995458000000000000")!!
            val member = event.member
            val channel = guild.getTextChannelById("995457939064225834")!!

            member!!.roles.add(role)

            val verifiedChannel = guild.getTextChannelById("999000326709461113")!!
            verifiedChannel.sendMessage("User ${member.asMention} has been arrived!").queue()
        }
    }
}