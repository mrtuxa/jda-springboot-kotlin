package space.mrtuxa.discord_bot.util

import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
import space.mrtuxa.discord_bot.Main

class Helper {
    companion object {
        fun getEnv(variable: String): String? {
            return Main.dotenv[variable]
        }
    }
}