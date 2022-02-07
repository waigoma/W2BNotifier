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
        val slackChannel = data["slack-channel"]!!.toString()

        val lineToken = data["line-token"]!!.toString()
        val lineChannel = data["line-channel"]!!.toString()

        botYamlMap["discord"] = BotYamlTemplate(discordToken, discordChannel)
        botYamlMap["slack"] = BotYamlTemplate(slackToken, slackChannel)
        botYamlMap["line"] = BotYamlTemplate(lineToken, lineChannel)

        return botYamlMap
    }
}