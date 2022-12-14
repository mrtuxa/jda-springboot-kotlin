package space.mrtuxa.discord_bot.events

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.components.buttons.Button
import space.mrtuxa.discord_bot.util.Helper
import java.io.BufferedReader
import java.io.InputStreamReader

class Weather : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name == "weather") {
            val city = event.getOption("city")?.asString
            val embed: EmbedBuilder = EmbedBuilder()
            embed.setTitle("Weather")
            embed.setDescription("Weather in $city")
            embed.setColor(0x00FF00)
            embed.setFooter(
                "We currently cant provide a weather statistic via Discord, please visit click the button to get more Information",
                event.user.avatarUrl
            )
            embed.setTimestamp(event.timeCreated)
            event.replyEmbeds(embed.build()).setActionRow(Button.link("https://wttr.in/$city", "Click here")).queue()
        }
    }
}