#

- Run the server: `./gradlew :sharedFullStack:run`
  - Call http://127.0.0.1:8081/quiz with a rest client to get a JSON of a quiz
  - open http://127.0.0.1:8081 to open a Kotlin react webapp that calls the API
- Run the desktop app: `./gradlew :desktopApp:run`
- Run the Compose web canvas app: `./gradlew :composeWebCanvasApp:jsBrowserRun`
  - Open the page: http://localhost:8080/
- Run the Android app: `:androidApp:assembleDebug`
