package com.waigoma.w2bnotifier.web.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LPController {
    @GetMapping("/")
    fun index(): String {
        return "index"
    }
}