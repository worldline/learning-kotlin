package com.worldline.vaadinkotlindsldemo

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.html.Paragraph
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

@Route("")
internal class MainView : VerticalLayout() {
    init {
        val h1 = H1("Hello, Vaadin Kotlin")
        val button = Button("Click me") {
            add(Paragraph("Button clicked!"))
        }
        add(h1, button)
    }
}