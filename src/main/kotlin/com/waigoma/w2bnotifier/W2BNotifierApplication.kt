package com.waigoma.w2bnotifier

import com.waigoma.w2bnotifier.file.ResourceExporter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class W2BNotifierApplication

fun main(args: Array<String>) {
    runApplication<W2BNotifierApplication>(*args)
    startup()
}

private fun startup() {
    ResourceExporter().export()
}