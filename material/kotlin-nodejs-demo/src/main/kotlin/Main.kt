data class Message(val id: Int, val message: String)

fun main() {
    val messages = listOf(Message(0, "I love Kotlin/JS"))
    val app = express.Express()
    app.get("/hello") { req, res ->
        res.send(messages)
    }

    app.listen(3000) {
        console.log("server start at port 3000")
    }
}

fun greeting(message: String) = "Hello, $message"