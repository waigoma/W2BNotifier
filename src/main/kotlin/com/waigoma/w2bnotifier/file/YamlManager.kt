package com.waigoma.w2bnotifier.file

import java.io.File

class YamlManager {
    private val discordData: BotYamlTemplate
    private val slackData: BotYamlTemplate

    init {
        val dataMap = YamlLoader().load(ResourceExporter.DIR_PATH + File.separator + "bot.yml")
        discordData = dataMap["discord"]!!
        slackData = dataMap["slack"]!!
    }

    fun getDiscordData(): BotYamlTemplate {
        return discordData
    }

    fun getSlackData(): BotYamlTemplate {
        return slackData
    }
}