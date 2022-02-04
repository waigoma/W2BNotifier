package com.waigoma.w2bnotifier.file

import java.io.File

class YamlManager {
    private val discordData: BotYamlTemplate

    init {
        val dataMap = YamlLoader().load(ResourceExporter.DIR_PATH + File.separator + "bot.yml")
        discordData = dataMap["discord"]!!
    }

    fun getDiscordData(): BotYamlTemplate {
        return discordData
    }
}