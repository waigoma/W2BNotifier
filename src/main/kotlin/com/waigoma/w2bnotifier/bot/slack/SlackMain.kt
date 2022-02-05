package com.waigoma.w2bnotifier.bot.slack

import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory
import com.waigoma.w2bnotifier.Main

class SlackMain {
    private val logger = org.slf4j.LoggerFactory.getLogger(this::class.java)

    private val yml = Main.getYamlManager()
    private val slackSession = SlackSessionFactory.createWebSocketSlackSession(yml.getSlackData().TOKEN)

    fun sendMessage(message: String) {
        slackSession.connect()
        logger.info("Slack session connected")
        slackSession.sendMessage(yml.getSlackData().CHANNEL, message)
        slackSession.disconnect()
    }
}