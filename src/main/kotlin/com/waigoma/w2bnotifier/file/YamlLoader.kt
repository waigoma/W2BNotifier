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
        val discordChannelStr = data["discord-channel"]!!.toString()
        val discordChannel = discordChannelStr.toLong()

        botYamlMap["discord"] = BotYamlTemplate(discordToken, discordChannel)

        return botYamlMap
    }
}