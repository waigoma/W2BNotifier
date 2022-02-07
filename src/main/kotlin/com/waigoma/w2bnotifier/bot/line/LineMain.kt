package com.waigoma.w2bnotifier.bot.line

import com.linecorp.bot.client.LineMessagingClient
import com.linecorp.bot.model.PushMessage
import com.linecorp.bot.model.message.TextMessage
import com.waigoma.w2bnotifier.Main

class LineMain {
    private val logger = org.slf4j.LoggerFactory.getLogger(this::class.java)
    private val yml = Main.getYamlManager()

    private val client = LineMessagingClient.builder(yml.getLineData().TOKEN).build()

    fun sendMessage(message: String) {
        val textMessage = TextMessage(message)
        val pushMessage = PushMessage(yml.getLineData().CHANNEL, textMessage)

        val botApiResponse = client.pushMessage(pushMessage).get()

        logger.info("botApiResponse: $botApiResponse")
    }
}