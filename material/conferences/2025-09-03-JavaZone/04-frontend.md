# Frontend development in Kotlin

Kotlin can be used for frontend development in several ways thanks to its multiplatform capabilities.
We are going to see two examples, one with JavaFx and one with Compose Multiplatform.

## JavaFx


## Compose Multiplatform

Compose Multiplatform is the cross-platform equivalent of Compose for Android (which is the current official UI kit for Android).
It runs on iOS, Android, the web and desktop (through the JVM).

The current best way to get started in with the [Kotlin playground](https://play.kotlinlang.org/) which renders UI components in the browser thanks to the support of the web platform.

Let's start by running our first Compose Multiplatform application in the Kotlin playground:

1. Please open [this link to load a simple app](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMi4yLjAiLCJwbGF0Zm9ybSI6ImNvbXBvc2Utd2FzbSIsImFyZ3MiOiIiLCJub25lTWFya2VycyI6dHJ1ZSwidGhlbWUiOiJpZGVhIiwiY29kZSI6ImltcG9ydCBhbmRyb2lkeC5jb21wb3NlLnVpLkV4cGVyaW1lbnRhbENvbXBvc2VVaUFwaVxuaW1wb3J0IGFuZHJvaWR4LmNvbXBvc2UudWkud2luZG93LkNhbnZhc0Jhc2VkV2luZG93XG5pbXBvcnQgYW5kcm9pZHguY29tcG9zZS5hbmltYXRpb24uQW5pbWF0ZWRWaXNpYmlsaXR5XG5pbXBvcnQgYW5kcm9pZHguY29tcG9zZS5mb3VuZGF0aW9uLkltYWdlXG5pbXBvcnQgYW5kcm9pZHguY29tcG9zZS5mb3VuZGF0aW9uLmxheW91dC5Db2x1bW5cbmltcG9ydCBhbmRyb2lkeC5jb21wb3NlLmZvdW5kYXRpb24ubGF5b3V0LmZpbGxNYXhXaWR0aFxuaW1wb3J0IGFuZHJvaWR4LmNvbXBvc2UubWF0ZXJpYWwuQnV0dG9uXG5pbXBvcnQgYW5kcm9pZHguY29tcG9zZS5tYXRlcmlhbC5NYXRlcmlhbFRoZW1lXG5pbXBvcnQgYW5kcm9pZHguY29tcG9zZS5tYXRlcmlhbC5UZXh0XG5pbXBvcnQgYW5kcm9pZHguY29tcG9zZS5ydW50aW1lLkNvbXBvc2FibGVcbmltcG9ydCBhbmRyb2lkeC5jb21wb3NlLnJ1bnRpbWUuZ2V0VmFsdWVcbmltcG9ydCBhbmRyb2lkeC5jb21wb3NlLnJ1bnRpbWUubXV0YWJsZVN0YXRlT2ZcbmltcG9ydCBhbmRyb2lkeC5jb21wb3NlLnJ1bnRpbWUucmVtZW1iZXJcbmltcG9ydCBhbmRyb2lkeC5jb21wb3NlLnJ1bnRpbWUuc2V0VmFsdWVcbmltcG9ydCBhbmRyb2lkeC5jb21wb3NlLnVpLkFsaWdubWVudFxuaW1wb3J0IGFuZHJvaWR4LmNvbXBvc2UudWkuTW9kaWZpZXJcblxuQE9wdEluKEV4cGVyaW1lbnRhbENvbXBvc2VVaUFwaTo6Y2xhc3MpXG5mdW4gbWFpbigpIHtcbiAgQ2FudmFzQmFzZWRXaW5kb3cgeyBBcHAoKSB9XG59XG5cbkBDb21wb3NhYmxlXG5mdW4gQXBwKCkge1xuICBNYXRlcmlhbFRoZW1lIHtcbiAgICB2YXIgZ3JlZXRpbmdUZXh0IGJ5IHJlbWVtYmVyIHsgbXV0YWJsZVN0YXRlT2YoXCJIZWxsbyBXb3JsZCFcIikgfVxuICAgIHZhciBzaG93SW1hZ2UgYnkgcmVtZW1iZXIgeyBtdXRhYmxlU3RhdGVPZihmYWxzZSkgfVxuICAgIHZhciBjb3VudGVyIGJ5IHJlbWVtYmVyIHsgbXV0YWJsZVN0YXRlT2YoMCkgfVxuICAgIENvbHVtbihNb2RpZmllci5maWxsTWF4V2lkdGgoKSwgaG9yaXpvbnRhbEFsaWdubWVudCA9IEFsaWdubWVudC5DZW50ZXJIb3Jpem9udGFsbHkpIHtcbiAgICAgIEJ1dHRvbihvbkNsaWNrID0ge1xuICAgICAgICBjb3VudGVyKytcbiAgICAgICAgZ3JlZXRpbmdUZXh0ID0gXCJDb21wb3NlOiAke0dyZWV0aW5nKCkuZ3JlZXQoKX1cIlxuICAgICAgICBzaG93SW1hZ2UgPSAhc2hvd0ltYWdlXG4gICAgICB9KSB7XG4gICAgICAgIFRleHQoZ3JlZXRpbmdUZXh0KVxuICAgICAgfVxuICAgICAgQW5pbWF0ZWRWaXNpYmlsaXR5KHNob3dJbWFnZSkge1xuICAgICAgICBUZXh0KGNvdW50ZXIudG9TdHJpbmcoKSlcbiAgICAgIH1cbiAgICB9XG4gIH1cbn1cblxucHJpdmF0ZSB2YWwgcGxhdGZvcm0gPSBvYmplY3QgOiBQbGF0Zm9ybSB7XG5cbiAgb3ZlcnJpZGUgdmFsIG5hbWU6IFN0cmluZ1xuICAgIGdldCgpID0gXCJXZWIgd2l0aCBLb3RsaW4vV2FzbVwiXG59XG5cbmZ1biBnZXRQbGF0Zm9ybSgpOiBQbGF0Zm9ybSA9IHBsYXRmb3JtXG5cbmNsYXNzIEdyZWV0aW5nIHtcbiAgcHJpdmF0ZSB2YWwgcGxhdGZvcm0gPSBnZXRQbGF0Zm9ybSgpXG5cbiAgZnVuIGdyZWV0KCk6IFN0cmluZyB7XG4gICAgcmV0dXJuIFwiSGVsbG8sICR7cGxhdGZvcm0ubmFtZX0hXCJcbiAgfVxufVxuXG5pbnRlcmZhY2UgUGxhdGZvcm0ge1xuICB2YWwgbmFtZTogU3RyaW5nXG59In0=). 
1. Click on the "Run" button to execute the code.
1. You should see a simple UI with a button. Click on the button once and then click it another time.
1. Read the code and analyze how the components are structured.

Compose works a declarative way simialr to React:

- You define the UI in a function using a syntax similar to HTML. 
  - In reality, it is a composition of Higher Order Functions (parenthesis are omitted as we have seen in the first part).
  - The first letter is capitalized, which is a convention in Compose (also similar to React).
  - The function must have the `Composable` annotation.
- Any element that changes in the UI must as a **state** using this syntax: `var myStateVar by remember { mutableStateOf("Hello World!") }`

The general form of a composable function is:

```kotlin
@Composable
fun MyComposable() {
    var myStateVar by remember { mutableStateOf(initialValue) }
    UiElementWithParams(params) {
        UiElementWithNoParams {
            // Nested UI elements
        }
        UiElementWithParams(params) {
            // Nested UI elements
        }
        // ...
    }
}
```

Let's analyse the `App` function:

```kotlin
@Composable // 1
fun App() { // 2
    MaterialTheme { // 3
        var greetingText by remember { mutableStateOf("Hello World!") } // 4
        var showImage by remember { mutableStateOf(false) } // 5
        var counter by remember { mutableStateOf(0) } // 6
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) { // 7
            Button(onClick = { // 8
                counter++
                greetingText = "Compose: ${Greeting().greet()}"
                showImage = !showImage
            }) { // 9
                Text(greetingText)
            }
            AnimatedVisibility(showImage) { // 10
                Text(counter.toString())  // 11
            }
        }
    }
}
```

1. The `@Composable` annotation indicates that this function is a composable function, which means it can be used to build the UI.
2. The function `App` is defined, which will be the entry point of our UI (called from the `main` function).
3. `MaterialTheme` is a composable function that provides a Material Design theme for the UI. All the UI are embedded in this theme to ensure consistent styling.
4. `greetingText` is a mutable state variable initialized with `"Hello World!"`. This means that whenever this variable changes, the UI will be recomposed to reflect the new value.
5. `showImage` is also a mutable state variable initialized with `false`, which will control the visibility of the image.
6. `counter` is also a mutable state variable initialized with `0`, which will be used to count the number of button clicks.
7. `Column` is a composable function that arranges its children in a vertical column. The `Modifier.fillMaxWidth()` makes the column take the full width of the parent, and `horizontalAlignment = Alignment.CenterHorizontally` centers the children
   horizontally.
8. `Button` is a composable function that creates a button. The `onClick` lambda is executed when the button is clicked.
9. Inside the button, we display the `greetingText` using a `Text` composable function.
10. `AnimatedVisibility` is a composable function that controls the visibility of its child based on the `showImage` state. If `showImage` is `true`, the child will be visible, otherwise it will be hidden.
11. Inside the `AnimatedVisibility`, we display the `counter` value as a `Text` composable function.

Once you are familiar with the basics, you can use the [Kotlin Multiplatform template](https://kmp.jetbrains.com/) which generates ready to use Gradle projects.
From this page, generate a new project with the following options (Alternatively, you can use this link to download the [project template directly](https://kmp.jetbrains.com/generateKmtProject?name=JavaZone2025&id=no.javazone.kotlinworkshop&spec=%7B%22template_id%22%3A%22kmt%22%2C%22targets%22%3A%7B%22android%22%3A%7B%22ui%22%3A%5B%22compose%22%5D%7D%2C%22ios%22%3A%7B%22ui%22%3A%5B%22compose%22%5D%7D%2C%22desktop%22%3A%7B%22ui%22%3A%5B%22compose%22%5D%7D%2C%22web%22%3A%7B%22ui%22%3A%5B%22compose%22%5D%7D%7D%2C%22include_tests%22%3Atrue%7D):

- Project Name: `JavaZone 2025 Kotlin workshop`
- Project ID: `no.javazone.kotlinworkshop`
- Platforms: Android, iOS (with shared UI), desktop, web (with shared UI)

Once the project is downloaded, unzip it and open it in IntelliJ IDEA or Android Studio.
Next, the IDE takes some time to load the project and download the necessary dependencies.