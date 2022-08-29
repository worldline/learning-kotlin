# Front development

Kotlin has a wide selection of front frameworks.
It supports JVM, Java and JS frameworks and it has its own unique ones.

- We can create Console apps with Kotlin.
- Thanks to JVM support, Kotlin supports JavaFX.
  - It even has a Kotlin counterpart called [tornadofx](https://tornadofx.io/)
- With JS support, developers can create can create React, nodsjs, or vanilla JS Apps with IntelliJ IDEA.
- [Ktor](https://ktor.io/docs/creating-interactive-website.html) can use templates engines [such as FreeMarker](https://freemarker.apache.org/) to create server pages.
- Android developers use the [Jetpack Compose](https://developer.android.com/jetpack/compose) UI Framework.
- [Compose Multiplatform](https://www.jetbrains.com/lp/compose-mpp/) brings Jetpack Compose to the desktop and the web.

## Compose multiplatform

[Compose multiplatform](https://blog.jetbrains.com/kotlin/2021/08/compose-multiplatform-goes-alpha/) is a family of declarative UI frameworks for Android (Jetpack Compose), the desktop (Compose Desktop), and the web (Compose Web).

::: warning state of compose multiplatform as of August 2022

Currently, IntelliJ can create compose projects that include both Android and Desktops.
The web platform is not yet included, but it is still possible to create Compose projects only for web or only for desktop.

For Android only compose apps (Jetpack Compose), please use **Android Studio**.

:::

Google provides a [JetPack compose tutorial](https://developer.android.com/jetpack/compose/tutorial) focused on Android development.

## PW create a Compose desktop + Android app

- Create a new project IntelliJ project -> Compose Multiplaform.
- Choose "multiple platforms" and fill the fields. Then choose **Finish**
- Wait a while for IntelliJ prepare the project which may request you to install plugins.
- Run the android app using the green run ▶️ button.
- Run the Desktop app by running the main function on the desktop project (should be in `Main.kt`).
- Modify `App.kt` in the main project as follows and run the app.

```kotlin
@Composable
fun App() {
    val platformName = getPlatformName()
    Card {
        var expanded by remember { mutableStateOf(false) }
        Column(Modifier.clickable { expanded = !expanded }) {
            Text(
                text="Click me !",
                style = MaterialTheme.typography.h2
            )
            AnimatedVisibility(expanded){
                Text(
                    text = "Hello, ${platformName} 🎊",
                    style = MaterialTheme.typography.h1
                )
            }
        }
    }
}
```

![compose multiplatform demo](../../assets/compose-multiplaform.gif)

## PW create a Compose web app

- Create a new project IntelliJ project -> Compose Multiplaform.
- Choose "Single platforms", then "Web" and fill the fields. 
- Choose **Finish**
- Wait a while for IntelliJ prepare the project which may request you to install plugins.
- Run the web app running ` ./gradlew jsBrowserRun --continuous`.
- Modify `Main.kt` as follows and run the app.

```kotlin
fun main() {
    renderComposable(rootElementId = "root") {
        Div({ style { padding(25.px) } }) {
            var expanded by remember { mutableStateOf(false) }
            Button(
                attrs = {
                    onClick { expanded = !expanded }
                }
            ) { Text("Click me") }
            Div({ style { display(if (expanded) DisplayStyle.Block else DisplayStyle.None) } }) {
                Text("Click me !")
            }
        }
    }
}
```

![compose multiplatform demo](../../assets/compose-multiplaform-web.gif)
