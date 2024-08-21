package com.qk.quark

import com.qk.controller.Home
import javafx.application.Application
import javafx.stage.Stage

class Quark : Application() {
    override fun start(stage: Stage) {
        val home = Home(stage)
        home.indexHome()
    }
}

fun main() {
    Application.launch(Quark::class.java)
}
