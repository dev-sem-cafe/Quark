package com.qk.controller

import com.qk.helpers.Routes
import com.qk.helpers.Style
import com.qk.helpers.getRes
import com.qk.helpers.size
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class Home(private val stage: Stage) {

    fun indexHome() {

        val fxmlLoader = FXMLLoader(getRes(Routes.home))

        val scene = Scene(fxmlLoader.load(), size().width - 5, size().height - 35)
        val css = getRes(Style.mainStyle)?.toExternalForm()

        scene.stylesheets.add(css)

        stage.title = "Quark"
        stage.scene = scene
        stage.show()
    }
}
