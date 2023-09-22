// external means that this class is defined in JS
external class BodyParser {
    // we tell Kotlin that we want to use the json() function.
    fun json(): Any
    // It is not required to define all the functions of the module
}

// @JsModule is used to import the module from the NPM registry
@JsModule("body-parser")
external val bodyParser: BodyParser



