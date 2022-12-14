package space.mrtuxa.discord_bot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/")
class Index {
    @GetMapping
    fun index(): String {
        return "<h1> Welcome to the API of the Discord Bot </h1><br>" +
                "<h2> Endpoints: </h2><br>" +
                "<h3> /status </h3><br>" +
                "<h3> /verify </h3><br>" +
                "<h3> /aboutme </h3><br>" +
                "<h3> /neofetch </h3><br>"
    }
}