package space.mrtuxa.discord_bot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/neofetch")
class SystemInformation {
    @GetMapping
    fun getSystemInformation(): String {
        val information = "<h1>System information</h1><p>${Runtime.getRuntime().availableProcessors().toString()} cores</p><br>" +
                "available Memory: ${Runtime.getRuntime().totalMemory() / 1024 / 1024}MB/${Runtime.getRuntime().maxMemory() / 1024 / 1024}MB<br>" +
                "OS: ${System.getProperty("os.name")} ${System.getProperty("os.version")} ${System.getProperty("os.arch")}<br>" +
                "Java: ${System.getProperty("java.version")} ${System.getProperty("java.vendor")}<br>" +
                "Java VM: ${System.getProperty("java.vm.name")} ${System.getProperty("java.vm.version")} ${System.getProperty("java.vm.vendor")}<br>" +
                "Java Home: ${System.getProperty("java.home")}<br>" +
                "User: ${System.getProperty("user.name")}<br>" +
                "User Home: ${System.getProperty("user.home")}<br>" +
                "User Dir: ${System.getProperty("user.dir")}<br>"
        return information.toString()
    }
}