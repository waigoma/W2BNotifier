package com.waigoma.w2bnotifier.web.controller

import com.waigoma.w2bnotifier.Main
import com.waigoma.w2bnotifier.bot.discord.DiscordSender
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
    fun post(@RequestParam("discord_msg") discordMsg: String): String {
        if (discordMsg.isNotEmpty()) {
            DiscordSender(Main.getDiscordMain().getJDA()).sendText(discordMsg, Main.getYamlManager().getDiscordData().CHANNEL.toLong())
        }
        return "index"
    }
}