package space.mrtuxa.discord_bot.events

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.io.BufferedReader
import java.io.InputStreamReader

class Weather : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name == "weather") {
            event.deferReply().queue()
            val city = event.getOption("city")!!.asString
            val url = "https://wttr.in/$city"

            val process = ProcessBuilder()
                .command("curl", url)
                .start()

            val reader = BufferedReader(InputStreamReader(process.inputStream))
            var line: String? = reader.readLine()

            while (line != null) {
                event.reply(line).queue()
                line = reader.readLine()
            }
        }

    }
}