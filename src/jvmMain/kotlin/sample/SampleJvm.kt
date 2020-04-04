package sample

import io.ktor.application.*
import io.ktor.html.*
import io.ktor.http.content.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.html.*
import java.io.*

actual class Sample {
    actual fun checkMe() = 42
}

actual object Platform {
    actual val name: String = "JVM"
}

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        routing {
            get("/") {
                call.respondHtml {
                    head {
                        title("titulo del navegador!")
                    }
                    body {
                        +"${hello()} from kaka. Checar valor ${Sample().checkMe()}"
                        div {

                            id = "js-response"
                            +"CARGANDO VRG..."
                        }
                        div{
                            id="gato"
                        }
                        script(src = "/static/multiplata.js") {}
                    }
                }
            }
            static("/static") {
                resource("multiplata.js")
            }
        }
    }.start(wait = true)
}