package verify

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.components.buttons.Button

class VerifyMessage : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name == "sendverify") {
            // verify embed
            val embed : EmbedBuilder = EmbedBuilder()
            embed.setTitle("Verification")
            embed.setDescription("Please react to this message to verify yourself!")
            embed.setColor(0x00FF00)
            embed.setFooter("Verification", event.user.avatarUrl)
            embed.setTimestamp(event.timeCreated)

            event.replyEmbeds(embed.build()).setActionRow(Button.success("verifyMessage", "Verify")).queue()
        }
    }
}