package com.qk.quark

import javafx.fxml.FXML
import javafx.scene.control.Label

class HomePage {
    @FXML
    private lateinit var welcomeText: Label

    @FXML
    private fun onHelloButtonClick() {
        welcomeText.text = "Welcome to JavaFX Application!"
    }
}
