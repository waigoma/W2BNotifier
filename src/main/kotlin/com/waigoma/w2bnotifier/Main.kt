package com.waigoma.w2bnotifier

import com.waigoma.w2bnotifier.bot.discord.DiscordMain
import com.waigoma.w2bnotifier.bot.slack.SlackMain
import com.waigoma.w2bnotifier.file.ResourceExporter
import com.waigoma.w2bnotifier.file.YamlManager

class Main {
    companion object {
        private lateinit var yamlManager: YamlManager
        private lateinit var discordMain: DiscordMain
        private lateinit var slackMain: SlackMain

        fun getYamlManager(): YamlManager {
            return yamlManager
        }

        fun getDiscordMain(): DiscordMain {
            return discordMain
        }

        fun getSlackMain(): SlackMain {
            return slackMain
        }
    }

    init {
        ResourceExporter().export()
        yamlManager = YamlManager()
        discordMain = DiscordMain()
        slackMain = SlackMain()
    }
}