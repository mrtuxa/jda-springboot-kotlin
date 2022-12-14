package space.mrtuxa.discord_bot.events

import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.Command
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction

class OnReady : ListenerAdapter() {
    override fun onReady(event: ReadyEvent) {
        val guild: Guild = event.jda.getGuildById("995457939064225832")!!
        val commands: CommandListUpdateAction = guild.updateCommands()

        commands.addCommands(
           Commands.slash("sendverify", "Send a verification message"),
           Commands.slash("weather", "Get the weather of a city")
               .addOptions(
                   OptionData(
                       OptionType.STRING, "city", "The city to get the weather of"
                   ).setRequired(true)),
            Commands.slash("randomcat", "Get a random cat picture"),
            Commands.slash("set-ticket", "Set a ticket support")
        ).queue()
    }
}