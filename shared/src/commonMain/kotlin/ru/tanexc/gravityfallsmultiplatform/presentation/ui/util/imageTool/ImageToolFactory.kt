package ru.tanexc.gravityfallsmultiplatform.presentation.ui.util.imageTool

object ImageToolFactory {
    private lateinit var imageTool: ImageTool

    fun get(): ImageTool {
        if (!::imageTool.isInitialized) {
            imageTool = ImageTool()
        }
        return imageTool
    }
}