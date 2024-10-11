package com.worldline.vaadinkotlindsldemo

import com.github.mvysny.karibudsl.v10.button
import com.github.mvysny.karibudsl.v10.h1
import com.github.mvysny.karibudsl.v10.onClick
import com.github.mvysny.karibudsl.v10.p
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.router.Route

@Route("karibu-dsl")
internal class KotlinDslWindow : VerticalLayout() {
    init {
        h1 { text = "Hello, Vaadin Kotlin (DSL)" }
        button {
            text = "Click me"
            onClick {
                p { text = "Button clicked!" }
            }
        }
    }
}