package com.waigoma.w2bnotifier.bot.slack

import com.slack.api.Slack
import com.waigoma.w2bnotifier.Main

class SlackMain {
    private val logger = org.slf4j.LoggerFactory.getLogger(this::class.java)

    private val yml = Main.getYamlManager()
    private val slack = Slack.getInstance()

    fun sendMessage(message: String) {
        val response = slack.methods(yml.getSlackData().TOKEN)
            .chatPostMessage {
                it.channel(yml.getSlackData().CHANNEL)
                  .text(message)
        }

        if (response.isOk) {
            logger.info("Message sent to Slack")
        } else {
            logger.error("Failed to send message to Slack")
        }
    }
}