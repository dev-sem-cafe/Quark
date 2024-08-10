package com.qk.views

import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Screen
import javafx.stage.Stage

class Home(private val stage: Stage) {

    fun indexHome() {
        val res = Home::class.java

        val fxmlLoader = FXMLLoader(res.getResource("home.fxml"))

        val screenBounds = Screen.getPrimary().visualBounds

        val scene = Scene(fxmlLoader.load(), screenBounds.width - 5, screenBounds.height - 35)
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
