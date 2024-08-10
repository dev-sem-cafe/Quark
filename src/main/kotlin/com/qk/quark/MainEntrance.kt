package com.qk.quark

import com.qk.views.Home
import javafx.application.Application
import javafx.stage.Stage

class MainEntrance : Application() {
    override fun start(stage: Stage) {
        val home = Home(stage)
        home.indexHome()
    }
}

fun main() {
    Application.launch(MainEntrance::class.java)
}
