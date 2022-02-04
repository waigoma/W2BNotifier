package com.waigoma.w2bnotifier.file

import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.InputStreamReader

class YamlLoader {
    fun load(file: String): Map<String, BotYamlTemplate> {
        val reader = InputStreamReader(File(file).inputStream())

        val yaml = Yaml()
        val valueMap = yaml.load<HashMap<String, String>>(reader)

        val botYamlMap = HashMap<String, BotYamlTemplate>()
        botYamlMap["discord"] = BotYamlTemplate(valueMap["discord-token"]!!, valueMap["discord-room"]!!)

        return botYamlMap
    }
}