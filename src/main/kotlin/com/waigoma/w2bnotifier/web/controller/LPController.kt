package com.waigoma.w2bnotifier.web.controller

import com.waigoma.w2bnotifier.Main
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class LPController {
    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @PostMapping("/")
    fun post(@RequestParam("discord_msg") discordMsg: String,
             @RequestParam("slack_msg") slackMsg: String): String {
        if (discordMsg.isNotEmpty()) {
            Main.getDiscordMain().sendMessage(discordMsg)
        }
        if (slackMsg.isNotEmpty()) {
            Main.getSlackMain().sendMessage(slackMsg)
        }
        return "index"
    }
}