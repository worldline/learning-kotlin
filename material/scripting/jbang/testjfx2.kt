///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS org.openjfx:javafx-controls:23
//DEPS org.openjfx:javafx-graphics:23:$NOT_FOUND
//DEPS org.openjfx:javafx-fxml:23

import javafx.application.Application
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import javafx.stage.Stage

class testjfx2 : Application() {
    private var scene: Scene? = null

    override fun start(stage: Stage) {
        val javaInfoString = String.format(
            "Java: %s, %s , %s",
            System.getProperty("java.version"),
            System.getProperty("java.vendor"),
            System.getProperty("java.vm.version")
        )
        val jfxInfoString = String.format("JavaFX: %s", System.getProperty("javafx.version"))

        val holder = VBox()
        holder.isFillWidth = true
        holder.alignment = Pos.TOP_CENTER
        holder.spacing = 5.0
        holder.children.addAll(
            Label(javaInfoString),
            Label(jfxInfoString),
        )

        scene = Scene(holder, 400.0, 300.0)
        stage.title = "JavaFX Demo"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(HelloJFXApp::class.java)
}