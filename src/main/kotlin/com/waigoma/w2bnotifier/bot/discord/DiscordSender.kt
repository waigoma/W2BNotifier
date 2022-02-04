package com.waigoma.w2bnotifier.bot.discord

class DiscordSender {
    private val jda = DiscordMain.jda

    fun sendText(text: String, roomId: Long) {
        jda.getTextChannelById(roomId)?.sendMessage(text)!!.queue()
    }

}