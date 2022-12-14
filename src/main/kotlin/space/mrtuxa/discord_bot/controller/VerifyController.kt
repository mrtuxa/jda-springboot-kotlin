package space.mrtuxa.discord_bot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/verify")
class VerifyController {
    @GetMapping
    fun verify(): String {

        return "<script src=\"https://cdn.tailwindcss.com\"></script>\n"

    }
}