package space.mrtuxa.discord_bot

import io.github.cdimascio.dotenv.dotenv
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import space.mrtuxa.discord_bot.Main.jda
import space.mrtuxa.discord_bot.events.GuildUserJoin
import space.mrtuxa.discord_bot.events.OnReady
import space.mrtuxa.discord_bot.util.Helper
import space.mrtuxa.discord_bot.verify.AddRole
import verify.VerifyMessage

@SpringBootApplication
class DiscordBotApplication

object Main {
    var dotenv = dotenv()
    var jda : JDA? = null
}

fun main(args: Array<String>) {

    jda = JDABuilder.createDefault(Helper.getEnv("TOKEN"))
        .addEventListeners(GuildUserJoin())
        .addEventListeners(OnReady())
        .addEventListeners(AddRole())
        .addEventListeners(VerifyMessage())
        .enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
        .build()

    jda!!.presence.setPresence(OnlineStatus.ONLINE, Activity.playing("${jda!!.guilds.size} guilds"))

    runApplication<DiscordBotApplication>(*args)
}
