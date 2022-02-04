package com.waigoma.w2bnotifier

import com.waigoma.w2bnotifier.file.ResourceExporter
import com.waigoma.w2bnotifier.file.YamlManager

class Main {
    companion object {
        private lateinit var yamlManager: YamlManager

        fun getYamlManager(): YamlManager {
            return yamlManager
        }
    }

    init {
        ResourceExporter().export()
        yamlManager = YamlManager()
    }
}