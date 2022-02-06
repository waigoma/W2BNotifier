package com.waigoma.w2bnotifier.file

import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.InputStream

class YamlLoader {
    fun load(path: String): Map<String, BotYamlTemplate> {
        val inputStream: InputStream = File(path).inputStream()

        val yaml = Yaml()
        val data = yaml.load<Map<String, Any>>(inputStream)

        val botYamlMap = HashMap<String, BotYamlTemplate>()

        val discordToken = data["discord-token"]!!.toString()
        val discordChannel = data["discord-channel"]!!.toString()

        val slackToken = data["slack-token"]!!.toString()
        val slackChannelStr = data["slack-channel"]!!.toString()

        val lineToken = data["line-token"]!!.toString()

        botYamlMap["discord"] = BotYamlTemplate(discordToken, discordChannel)
        botYamlMap["slack"] = BotYamlTemplate(slackToken, slackChannelStr)
        botYamlMap["line"] = BotYamlTemplate(lineToken, "none")

        return botYamlMap
    }
}