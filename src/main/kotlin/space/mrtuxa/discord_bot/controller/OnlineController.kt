package space.mrtuxa.discord_bot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import space.mrtuxa.discord_bot.Main

@RestController
@RequestMapping("/status")
class OnlineController {
    @GetMapping
    fun status(): String {
        return "Online as ${Main.jda!!.selfUser.name}#${Main.jda!!.selfUser.discriminator} with ${Main.jda!!.guilds.size} guilds"
    }
}