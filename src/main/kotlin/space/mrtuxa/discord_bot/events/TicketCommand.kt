package space.mrtuxa.discord_bot.events

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class TicketCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name == "setticket") {
            if(event.user.jda.roles.contains(event.guild?.getRoleById()))
        }
    }
}