package space.mrtuxa.discord_bot.events

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import space.mrtuxa.discord_bot.util.Helper
import java.awt.Color
import java.time.Instant

class GuildUserJoin : ListenerAdapter() {
    override fun onGuildMemberJoin(event: GuildMemberJoinEvent) {
        val guild = event.guild
        val channel = guild.getTextChannelById(Helper.getEnv("CHANNEL_ID")!!.toLong())
        val user = event.user
        val member = event.member
        val role = guild.getRoleById(Helper.getEnv("ROLE_ID")!!.toLong())
        val embed = EmbedBuilder()
        embed.setTitle("Welcome to the server!")
        embed.setDescription("Welcome to the server, ${user.asMention}! Please read the rules and enjoy your stay!")
        embed.setColor(Color(0x00FF00))
        embed.setThumbnail(user.avatarUrl)
        embed.setFooter("User joined", user.avatarUrl)
        embed.setTimestamp(Instant.now())
        channel!!.sendMessageEmbeds(embed.build()).queue()
    }
}
