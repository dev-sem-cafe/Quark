package com.qk.helpers

import com.qk.quark.Quark
import javafx.geometry.Rectangle2D
import javafx.stage.Screen
import java.net.URL

fun getRes(res: String): URL? {
    return Quark::class.java.getResource(res)
}
fun size(): Rectangle2D {
    return Screen.getPrimary().visualBounds
}

class Routes {
    companion object {
        const val home = "home.fxml"
    }
}

class Style {
    companion object {
        const val mainStyle = "styles.css"
    }
}
