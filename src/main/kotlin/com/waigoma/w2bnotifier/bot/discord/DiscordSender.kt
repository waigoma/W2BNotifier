package com.waigoma.w2bnotifier.bot.discord

import net.dv8tion.jda.api.JDA

class DiscordSender(private val jda: JDA) {
    fun sendText(text: String, channelId: Long) {
        jda.getTextChannelById(channelId)?.sendMessage(text)!!.queue()
    }
}