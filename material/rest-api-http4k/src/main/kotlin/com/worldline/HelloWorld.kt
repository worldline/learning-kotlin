package com.worldline

import com.worldline.formats.kotlinXMessage
import com.worldline.formats.kotlinXMessageLens
import com.worldline.models.JTEViewModel
import org.http4k.core.*
import org.http4k.core.ContentType.Companion.TEXT_HTML
import org.http4k.core.Method.GET
import org.http4k.core.Status.Companion.OK
import org.http4k.filter.DebuggingFilters.PrintRequest
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.Undertow
import org.http4k.server.asServer
import org.http4k.template.JTETemplates
import org.http4k.template.viewModel

val app: HttpHandler = routes(
    "/ping" bind GET to {
        Response(OK).body("pong")
    },

    "/formats/json/kotlinx" bind GET to {
        Response(OK).with(kotlinXMessageLens of kotlinXMessage)
    },

    "/templates/jte" bind GET to {
        val renderer = JTETemplates().CachingClasspath()
        val view = Body.viewModel(renderer, TEXT_HTML).toLens()
        val viewModel = JTEViewModel("Hello there!")
        Response(OK).with(view of viewModel)
    }
)

fun main() {
    val printingApp: HttpHandler = PrintRequest().then(app)

    val server = printingApp.asServer(Undertow(3001)).start()

    println("Server started on " + server.port())
}
