package sample

import kotlin.browser.*

actual class Sample {
    actual fun checkMe() = 12
}

actual object Platform {
    actual val name: String = "Javascript"
}


@Suppress("unused")
@JsName("helloWorld")
fun helloWorld(salutation: String) {
    val message = "$salutation from Kotlin.JS ${hello()}, checar mi valor que es....: ${Sample().checkMe()}"
    document.getElementById("js-response")?.textContent = message
    document.getElementById("gato")?.textContent="Guevos putos"

}

fun main() {
    document.addEventListener("DOMContentLoaded", {
        helloWorld("Holita!")
    })
}                