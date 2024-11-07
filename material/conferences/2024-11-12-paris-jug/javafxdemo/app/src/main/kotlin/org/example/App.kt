package org.example

import javafx.application.Application
import javafx.geometry.HPos
import javafx.stage.Stage
import ktfx.coroutines.onAction
import ktfx.dialogs.infoAlert
import ktfx.launchApplication
import ktfx.layouts.*

class App : Application() {
    override fun start(stage: Stage) {
        stage.scene {
            gridPane {
                hgap = 10.0
                vgap = 10.0
                label("First name").grid(0, 0)
                textField().grid(0, 1)
                label("Last name").grid(1, 0)
                textField().grid(1, 1)
                button("Say hello") {
                    onAction { print("Clicked") }
                }.grid(2, 1)
            }
            stage.show()
        }
    }
    companion object {
        @JvmStatic
        fun main(vararg args: String) = launchApplication<App>(*args)
    }
}
