package com.qk.quark

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Screen
import javafx.stage.Stage

class MainEntrance : Application() {
    override fun start(stage: Stage) {
        val res = MainEntrance::class.java

        val fxmlLoader = FXMLLoader(res.getResource("home.fxml"))

        val screenBounds = Screen.getPrimary().visualBounds

        val scene = Scene(fxmlLoader.load(), screenBounds.width, screenBounds.height - 35)
        val css = res.getResource("/styles.css")?.toExternalForm()

        if (css != null) {
            scene.stylesheets.add(css)
        } else {
            println("Arquivo CSS não encontrado")
        }
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(MainEntrance::class.java)
}
