package com.waigoma.w2bnotifier

import com.waigoma.w2bnotifier.file.ResourceExporter
import com.waigoma.w2bnotifier.file.YamlManager

class Main {
    companion object {
        lateinit var yamlManager: YamlManager
    }

    init {
        ResourceExporter().export()
        yamlManager = YamlManager()
    }
}