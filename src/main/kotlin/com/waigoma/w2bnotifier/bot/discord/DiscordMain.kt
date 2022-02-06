package com.waigoma.w2bnotifier.bot.discord

import com.waigoma.w2bnotifier.Main
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class DiscordMain : ListenerAdapter() {
    private val logger = org.slf4j.LoggerFactory.getLogger(DiscordMain::class.java)

    private val jda: JDA
    private val yml = Main.getYamlManager()

    init {
        jda = JDABuilder
            .createDefault(yml.getDiscordData().TOKEN)
            .addEventListeners(this)
            .build()
    }

    override fun onReady(event: ReadyEvent) {
        logger.info("Discord bot is ready!")
    }

    fun sendMessage(text: String) {
        jda.getTextChannelById(yml.getDiscordData().CHANNEL.toLong())?.sendMessage(text)!!.queue()
        logger.info("Message sent to Discord")
    }
}