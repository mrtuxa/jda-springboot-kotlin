package space.mrtuxa.discord_bot.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ChristmasController {
    @RequestMapping("/daysuntilchristmas")
    fun christmas(): String {
        return "<html>\n" +
                "    <head>\n" +
                "        <title>Christmas Countdown</title>\n" +
                "        <script type=\"text/javascript\" src=\"scripts/main.js\" async></script>\n" +
                "        <!--<script type=\"text/javascript\" src=\"scripts/musicControl.js\" async></script>!-->\n" +
                "        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                "        <link href=\"https://fonts.googleapis.com/css?family=Cinzel+Decorative|Mountains+of+Christmas\" rel=\"stylesheet\">\n" +
                "    </head>\n" +
                "<script>\n" +
                " //Gets the HTML Elements\n" +
                "var head = document.getElementById('head');\n" +
                "var subhead = document.getElementById('subhead');\n" +
                "var counterDays = document.getElementById('days');\n" +
                "var counterHours = document.getElementById('hours');\n" +
                "var counterMinutes = document.getElementById('minutes');\n" +
                "var counterSeconds = document.getElementById('seconds');\n" +
                "//finds Christmas\n" +
                "var christmas = new Date('December 24, 2022 00:00:00');\n" +
                "\n" +
                "//Updates Timer\n" +
                "function updateTimer(christmas) {\n" +
                "    \n" +
                "    var time = christmas - new Date();\n" +
                "    //Gives what to find on update\n" +
                "    return {\n" +
                "        'days': Math.floor(time / (1000 * 60 * 60 * 24)),\n" +
                "        'hours': Math.floor((time/(1000 * 60 * 60)) % 24),\n" +
                "        'minutes': Math.floor((time / 1000 / 60) % 60),\n" +
                "        'seconds': Math.floor((time / 1000) % 60),\n" +
                "        'total': time\n" +
                "    };\n" +
                "};\n" +
                "\n" +
                "//Starts the timer\n" +
                "function startTimer(counterDays, counterHours, counterMinutes, counterSeconds, christmas) {\n" +
                "    \n" +
                "    var timerInterval = setInterval(function() {\n" +
                "        var timer = updateTimer(christmas);\n" +
                "        \n" +
                "        //Changes the text of the 'counter'\n" +
                "        counterDays.innerHTML = timer.days;\n" +
                "        counterHours.innerHTML = timer.hours;\n" +
                "        counterMinutes.innerHTML = timer.minutes;\n" +
                "        counterSeconds.innerHTML = timer.seconds;\n" +
                "        \n" +
                "        //if christmas\n" +
                "        if(timer.total < 1) {\n" +
                "            clearInterval(timerInterval);\n" +
                "            counterDays.innerHTML = 0;\n" +
                "            counterHours.innerHTML = 0;\n" +
                "            counterMinutes.innerHTML = 0;\n" +
                "            counterSeconds.innerHTML = 0;\n" +
                "            \n" +
                "            head.innerHTML = \"It's Christmas!!!\";\n" +
                "            subhead.innerHTML = \"Merry Christmas to all!!!\";\n" +
                "        }\n" +
                "        \n" +
                "        //if christmas eve\n" +
                "        else if (timer.days < 1){\n" +
                "            subhead.innerHTML = \"It is currently Christmas Eve! How much longer until Christmas Day???\";\n" +
                "        }\n" +
                "   \n" +
                "    }, 1000); //timer updates every second\n" +
                "};\n" +
                "\n" +
                "window.onload = function() {\n" +
                "    \n" +
                "    startTimer(counterDays, counterHours, counterMinutes, counterSeconds, christmas);\n" +
                "    \n" +
                "    //Below is the code for the audio control; may move to own script.\n" +
                "    var button = document.getElementById('mute');\n" +
                "    var music = document.getElementById('music');\n" +
                "    \n" +
                "    button.onclick = function() {\n" +
                "        if(music.paused) {\n" +
                "        music.play();\n" +
                "        button.innerHTML = \"Mute\";\n" +
                "        }\n" +
                "        \n" +
                "        else {\n" +
                "        music.pause();\n" +
                "        button.innerHTML = \"Unmute\";\n" +
                "        }\n" +
                "\n" +
                "    };\n" +
                "  \n" +
                "};\n" +
                "</script>\n" +
                "<style>\n" +
                " *:focus {\n" +
                "    outline: none;\n" +
                "}\n" +
                "\n" +
                "body {\n" +
                "    background-color: #000000;\n" +
                "    border-radius: 100%;\n" +
                "    animation-name: bodyChange;\n" +
                "    animation-duration: 6s;\n" +
                "    animation-fill-mode: both;\n" +
                "    animation-iteration-count: infinite;\n" +
                "}\n" +
                "\n" +
                "body, button {\n" +
                "    text-shadow: 2px 2px 8px #000000;\n" +
                "}\n" +
                "\n" +
                "header {\n" +
                "    color: white;\n" +
                "    text-align: center;\n" +
                "    font-family: 'Cinzel Decorative', sans-serif;\n" +
                "    margin-bottom: 8%;\n" +
                "    font-size: 2em;\n" +
                "}\n" +
                "\n" +
                "img {\n" +
                "    display: none;\n" +
                "    z-index: -999;\n" +
                "}\n" +
                "\n" +
                "button {\n" +
                "    border: 3px solid #ea524f;\n" +
                "    font-family: 'Mountains of Christmas', sans-serif;\n" +
                "    font-size: 3em;\n" +
                "    display: block;\n" +
                "    margin-left: auto;\n" +
                "    margin-right: auto;\n" +
                "    border-radius: 8px;\n" +
                "    margin-top: auto;\n" +
                "    background-color: #42f471;\n" +
                "    color: #ffffff;\n" +
                "    transition: background-color 0.5s ease,\n" +
                "                border-color 0.5s ease;\n" +
                "   \n" +
                "}\n" +
                "\n" +
                "button:hover {\n" +
                "    cursor: pointer;\n" +
                "    background-color: #ea524f;\n" +
                "    border: 3px solid #42f471; \n" +
                "}\n" +
                "\n" +
                "#clock span {\n" +
                "    float: left;\n" +
                "    text-align: center;\n" +
                "    margin: 0 2.5%;\n" +
                "    padding: 20px;\n" +
                "    width: 20%;\n" +
                "    box-sizing: border-box;\n" +
                "    color: white;\n" +
                "    font-family: 'Mountains of Christmas', sans-serif;\n" +
                "    font-size: 50px;\n" +
                "}\n" +
                "\n" +
                "#counter span {\n" +
                "    background-color: #000000;\n" +
                "    border-radius: 100%;\n" +
                "    animation-name: colorChange;\n" +
                "    animation-duration: 1s;\n" +
                "    animation-fill-mode: both;\n" +
                "    animation-iteration-count: infinite;\n" +
                "    border: 3px solid white;\n" +
                "    \n" +
                "}\n" +
                "\n" +
                "#counter span, button {\n" +
                "    box-shadow: 4px 4px 15px #000000;\n" +
                "}\n" +
                "\n" +
                "#counter span:nth-child(odd) {\n" +
                "    animation-name: bwColorChange;\n" +
                "    animation-duration: 1s;\n" +
                "    animation-fill-mode: both;\n" +
                "    animation-iteration-count: infinite;\n" +
                "} \n" +
                "\n" +
                "@keyframes bodyChange {\n" +
                "  0%, 100% {\n" +
                "    background-color: #ea524f;\n" +
                "   \n" +
                "  }\n" +
                "  50% {\n" +
                "  background-color: #42f471;  \n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "@keyframes colorChange {\n" +
                "    0%, 100% {\n" +
                "        background-color: #42f471;\n" +
                "        border-color: #ea524f;\n" +
                "    }\n" +
                "    50% {\n" +
                "        background-color: #ea524f;\n" +
                "        border-color: #42f471;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "@keyframes bwColorChange {\n" +
                "  0%, 100% {\n" +
                "        background-color: #ea524f;\n" +
                "        border-color: #42f471;\n" +
                "  }\n" +
                "  50% {\n" +
                "    background-color: #42f471;\n" +
                "    border-color: #ea524f;\n" +
                "  }\n" +
                "}\n" +
                "</style>\n" +
                "    <body>\n" +
                "        <div id=\"wrapper\">\n" +
                "            <div id=\"clock\">\n" +
                "                <header>\n" +
                "                    <h1 id=\"head\">Christmas Countdown!</h1>\n" +
                "                    <h4 id=\"subhead\">How much longer until Christmas? Check the clock to find out!</h4>\n" +
                "                </header>\n" +
                "                <div id=\"count-container\">\n" +
                "                    <div id=\"counter\">\n" +
                "                        <span id=\"days\">&nbsp;</span>\n" +
                "                        <span id=\"hours\">&nbsp;</span>\n" +
                "                        <span id=\"minutes\">&nbsp;</span>\n" +
                "                        <span id=\"seconds\">&nbsp;</span>\n" +
                "                    </div>\n" +
                "                    <div id=\"labels\">\n" +
                "                        <span>Days</span>\n" +
                "                        <span>Hours</span>\n" +
                "                        <span>Minutes</span>\n" +
                "                        <span>Seconds</span>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <audio src=\"http://feelslikechristmas.com/mps/PaukenBrumfiel_AngelsOnHigh.mp3\" loop autoplay id=\"music\"></audio>\n" +
                "            <button type=\"button\" id=\"mute\">Mute</button>\n" +
                "        </div>\n" +
                "    </body>\n" +
                "</html>"
    }
}