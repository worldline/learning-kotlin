data class Message(val id: Int, val message: String)

fun main() {
    val messages = mutableListOf(Message(0, "I love Kotlin/JS"))
    val app = express.Express()
    app.use(bodyParser.json())
    app.get("/hello") { _, res ->
        res.send(messages)
    }

    app.post("/hello") { req, res ->
        val id = js("req.body.id") as? Int
        val message = js("req.body.message") as? String
        if (message != null && id != null) {
            messages.add(Message(id, message))
            res.status(201).end()
        }else{
            res.status(400).send(js("{cause : 'error'}") as Any)
        }
    }

    app.listen(3000) {
        console.log("server start at port 3000")
    }
}

fun greeting(message: String) = "Hello, $message"