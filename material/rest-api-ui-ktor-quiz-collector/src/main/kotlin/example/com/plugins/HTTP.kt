package example.com.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.plugins.cors.routing.*

fun Application.configureHTTP() {
    install(Compression) {
        gzip {
            priority = 1.0
        }
        deflate {
            priority = 10.0
            minimumSize(1024) // condition
        }
    }
    install(CORS) {
        allowMethod(HttpMethod.Options)
        allowHeader(HttpHeaders.ContentType)
        allowHost("verbal-paula-yostane-5911cad1.koyeb.app", schemes = listOf("https"))
        allowHost("localhost:9091")
    }
}
