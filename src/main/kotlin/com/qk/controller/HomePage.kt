package com.qk.controller

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.ListView
import javafx.stage.DirectoryChooser
import javafx.stage.FileChooser
import java.io.File

class HomePage {

    @FXML
    private lateinit var findFolder: Button

    @FXML
    private lateinit var findFile: Button

    @FXML
    private lateinit var fileListView: ListView<String>

    @FXML
    fun initialize() {

        findFolder.setOnAction {
            val selectedDirectory = showDirectoryChooser()
            if (selectedDirectory != null) {
                val files = listFiles(selectedDirectory)
                fileListView.items.setAll(files)
            }
        }

        findFile.setOnAction {
            val selectedfile = showFileChooser()
            if (selectedfile != null) {
                print(selectedfile)
                val files = listFiles(selectedfile)
                fileListView.items.setAll(files)
            }
        }

        fileListView.selectionModel.selectedItemProperty().addListener { _, _, newValue ->
            if (newValue != null) {
                handleItemSelected(newValue)
            }
        }
    }

    private fun handleItemSelected(item: String) {
        println("Selected item: $item")
        // Add logic here to handle the selected item
        // For example, you could open the file or show details
    }

    private fun showDirectoryChooser(): File? {
        val directoryChooser = DirectoryChooser()
        directoryChooser.title = "Selecione uma pasta"
        return directoryChooser.showDialog(null)
    }

    private fun showFileChooser(): File? {
        val file = FileChooser()
        file.title = "Selecione um arquivo"
        return file.showOpenDialog(null)
    }

    private fun listFiles(directory: File): List<String> {
        return directory.listFiles()?.map { it.name } ?: listOf("No files found")
    }
}
