data class Message(val id: Int, val message: String)

val messages = mutableListOf(Message(0, "I love Kotlin/JS"))

fun main() {
    val app = express.Express()

    // REST API that provides a **GET /hello** endpoint
    app.get("/hello") { _, res ->
        res.send(messages)
    }

    // Create a server that listens to port 3000
    app.listen(3000) {
        console.log("Server started at port 3000")
    }
}