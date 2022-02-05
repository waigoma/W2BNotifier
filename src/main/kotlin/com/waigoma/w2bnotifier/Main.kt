package com.waigoma.w2bnotifier

import com.waigoma.w2bnotifier.bot.discord.DiscordMain
import com.waigoma.w2bnotifier.file.ResourceExporter
import com.waigoma.w2bnotifier.file.YamlManager

class Main {
    companion object {
        private lateinit var yamlManager: YamlManager
        private lateinit var discordMain: DiscordMain

        fun getYamlManager(): YamlManager {
            return yamlManager
        }

        fun getDiscordMain(): DiscordMain {
            return discordMain
        }
    }

    init {
        ResourceExporter().export()
        yamlManager = YamlManager()
        discordMain = DiscordMain()
    }
}