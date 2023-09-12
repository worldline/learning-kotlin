data class Message(val id: Int, val message: String)

val messages = mutableListOf(Message(0, "I love Kotlin/JS"))

fun main() {
    val app = express.Express()
    app.use(bodyParser.json())

    app.get("/hello") { _, res ->
        res.send(messages)
    }

    app.post("/hello") { req, res ->
        // Kotlin does not keep the original field name when parsing JSON from JS (you can see it the in get response)
        if (req.body as? Message == null) {
            println("failed to get the body from Kotlin")
        }
        // Thus, we need to use js() to get the the field by its expected name
        // js() calls JS from Kotlin
        println("req.body from JS ${js("req.body.id")} - ${js("req.body.message")}")
        val id = js("req.body.id") as? Int
        val message = js("req.body.message") as? String
        if (message != null && id != null) {
            messages.add(Message(id, message))
            res.status(201).end()
        } else {
            res.status(400).send(js("{cause : 'error'}") as Any)
        }
    }

    app.listen(3000) {
        console.log("Server started at port 3000")
    }
}