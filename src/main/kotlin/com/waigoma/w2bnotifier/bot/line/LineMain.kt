package com.waigoma.w2bnotifier.bot.line

import com.waigoma.w2bnotifier.Main
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.stream.Collectors


class LineMain {
    private val yml = Main.getYamlManager()
    private val token = yml.getLineData().TOKEN

    fun sendMessage(message: String) {
        var connection: HttpURLConnection? = null
        try {
            val url = URL("https://notify-api.line.me/api/notify")
            connection = url.openConnection() as HttpURLConnection
            connection.doOutput = true
            connection.requestMethod = "POST"
            connection.addRequestProperty("Authorization", "Bearer $token")
            connection.outputStream.use { os ->
                PrintWriter(os).use { writer ->
                    writer.append("message=").append(URLEncoder.encode(message, "UTF-8")).flush()
                    connection.inputStream.use { `is` ->
                        BufferedReader(InputStreamReader(`is`)).use { r ->
                            val res = r.lines().collect(Collectors.joining())
                            if (!res.contains("\"message\":\"ok\"")) {
                                println(res)
                            }
                        }
                    }
                }
            }
        } catch (ignore: Exception) {
        } finally {
            connection?.disconnect()
        }
    }
}