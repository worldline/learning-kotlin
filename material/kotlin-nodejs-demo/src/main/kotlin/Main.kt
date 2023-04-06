data class Message(val id: Int, val message: String)

fun main() {
    val app = express.Express()
    app.get("/hello") { req, res ->
        res.send(Message(0, "I love Kotlin/JS"))
    }

    app.listen(3000) {
        console.log("server start at port 3000")
    }
}
