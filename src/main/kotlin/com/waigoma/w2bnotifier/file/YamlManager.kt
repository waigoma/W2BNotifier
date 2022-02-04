package com.waigoma.w2bnotifier.file

class YamlManager {
    companion object {
        lateinit var DISCORD_DATA: BotYamlTemplate
    }

    init {
        val dataMap = YamlLoader().load(ResourceExporter.dirPath)
        DISCORD_DATA = dataMap["discord"]!!
    }
}