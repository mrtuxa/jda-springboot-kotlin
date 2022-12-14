package space.mrtuxa.discord_bot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/aboutme")
class AboutMe {
    @GetMapping
    fun aboutMe() {
        
    }
}