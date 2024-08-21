package com.qk.controller

import com.qk.helpers.getRes
import com.qk.helpers.size
import javafx.fxml.FXML
import javafx.geometry.Insets
import javafx.scene.Cursor
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.scene.shape.Circle

class Aside {
    @FXML
    private lateinit var homeButton: Button

    @FXML
    private lateinit var settingsButton: Button

    @FXML
    private lateinit var aside: VBox

    @FXML
    private lateinit var innerAside: VBox

    @FXML
    private lateinit var dragHandle: Pane

    @FXML
    private lateinit var marginLogo: BorderPane

    @FXML
    private lateinit var quarkImage: ImageView

    private var initialX: Double = 0.0
    private var initialWidth: Double = 250.0

    @FXML
    fun initialize() {
        setupImageView()
        setupMargins()
        setupInitialSizes()
        setupDragHandle()
        setupButtons()
    }

    private fun setupImageView() {
        quarkImage.image = Image(getRes("quark.jpeg")?.toExternalForm())
        quarkImage.fitWidth = 75.0
        quarkImage.fitHeight = 90.0

        val clip = Circle(37.5, 37.5, 37.5)
        quarkImage.clip = clip
    }

    private fun setupMargins() {
        marginLogo.padding = Insets(25.0)
    }

    private fun setupInitialSizes() {
        aside.prefHeight = size().height
        aside.prefWidth = initialWidth
        innerAside.prefWidth = initialWidth - 10
        dragHandle.prefWidth = 5.0
        dragHandle.prefHeight = size().height
    }

    private fun setupDragHandle() {
        dragHandle.setOnMouseEntered { event: MouseEvent ->
            dragHandle.scene.cursor = Cursor.E_RESIZE
        }

        dragHandle.setOnMouseExited { event: MouseEvent ->
            dragHandle.scene.cursor = Cursor.DEFAULT
        }

        dragHandle.setOnMousePressed { event: MouseEvent ->
            initialX = event.sceneX
            initialWidth = aside.prefWidth
        }

        dragHandle.setOnMouseDragged { event: MouseEvent ->
            val offsetX = event.sceneX - initialX
            val newWidth = initialWidth + offsetX

            if (newWidth in 150.0..(size().width / 2)) {
                aside.prefWidth = newWidth
                innerAside.prefWidth = newWidth - 10.0
            }
        }

        dragHandle.setOnMouseClicked { event: MouseEvent ->
            if (event.clickCount == 2 && !event.isConsumed) {
                event.consume() // Consumir o evento para evitar que outros handlers sejam acionados
                resetAsideWidth()
            }
        }
    }

    private fun setupButtons() {
        homeButton.setOnAction {
            println("Home button clicked")
            // Trocar conteúdo principal aqui
        }

        settingsButton.setOnAction {
            println("Settings button clicked")
            // Trocar conteúdo principal aqui
        }
    }

    private fun resetAsideWidth() {
        innerAside.prefWidth = 250.0 - 10
        aside.prefWidth = 250.0
    }
}
