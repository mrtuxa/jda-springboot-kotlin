package funny

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.utils.FileUpload
import java.io.File
import java.io.FileOutputStream
import java.net.URL

class Cat : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name == "randomcat") {

            val url = URL("https://cataas.com/cat")
            val inputStream = url.openStream()

            // send embed with image
            val catEmbed : EmbedBuilder = EmbedBuilder()
            catEmbed.setDescription("Result")

            val channel = event.channel
            val file = File("cat.png")
            channel.sendMessageEmbeds(catEmbed.build()).addFiles(FileUpload.fromData(file)).queue()
        }
    }
}