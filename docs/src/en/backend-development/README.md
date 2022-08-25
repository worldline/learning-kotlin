# Backend development

Many frameworks officially support Kotlin: [Spring](https://spring.io/blog/2017/01/04/introducing-kotlin-support-in-spring-framework-5-0), [Quarkus](https://quarkus.io/guides/kotlin), [Ktor](https://github.com/ktorio/ktor), among others [listed here](https://kotlinlang.org/docs/server-overview.html#deploying-kotlin-server-side-applications).

In addition to that, Kotlin is theoretically compatible with any framework that targets the JVM or JS.
However, this generally requires more effort to achieve.
For example, this tutorial shows [how to use nodejs with kotlin](https://medium.com/@touskar/une-application-nodejs-avec-kotlin-1969994fb1d2)

## PW: develop an API with Ktor

- Create a project on [start.ktor.io](https://start.ktor.io/) with the following plugins: ContentNegotiation, kotlinx.serialization, and Routing.
- Click on "Generate project"
- Download the archive, unzip it, and open it with IntelliJ
- Create a  `models` package and add to it a `Customer` data class with these fields immutable properties `id: String, firstName: String, lastName: String, email: String`.
- Annotate the class with `@Serializable`
- Create a new package routes and add to it a file `CustomerRoutes.kt`.
- Define the missing endpoints of the provided code below.
- For simplicity, use a global in-memory list of customers `val customerStorage = mutableListOf<Customer>()`.
- Run the server by running the main method.
- Test the api on the IDE by using an http file or using any other client

::: details CustomerRoutes.kt

```kotlin
val store = mutableListOf<Customer>()

fun Route.customerRouting() {
    route("/customer") {
        get {
            call.respond(store)
        }
        get("{id?}") {
            val id = call.parameters["id"] ?: return@get call.respondText(
                "Missing id",
                status = HttpStatusCode.BadRequest
            )
            val customer =
                store.find { it.id == id } ?: return@get call.respondText(
                    "No customer with id $id",
                    status = HttpStatusCode.NotFound
                )
            call.respond(customer)
        }
        post {
            val customer = call.receive<Customer>()
            store.add(customer)
            call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
        }
        delete("{id?}") {

        }
    }
}
```

:::

::: tip Use `return@lembda` in case of nested lambdas

You can specify which level you want to return with an explicit label using `return@lembda`.

```kotlin
lambdaA {
    lambdaB {
        lambdaC {
            val randomInt = Random.nextInt(0, 100)
            if (randomInt > 50) return@lambdaC else return@lambdaB
        }
        printf("In lambdaB")
    }
}
```


[This code runs another example](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbi5yYW5kb20uUmFuZG9tXG5cbi8vIHJldHVybiB3aXRoIGltcGxpY2l0IGxhYmVsc1xuXG5mdW4gbWFpbigpIHtcbiAgIHZhbCBrb3RsaW4gPSBcIvCfmYJcIlxuICAga290bGluLmxldCB7XG4gICAgICAgaXQuYXBwbHkge1xuXHRcdFx0dmFsIHJhbmRvbUludCA9IFJhbmRvbS5uZXh0SW50KDAsIDEwMClcbiAgICAgICAgICAgIHByaW50bG4ocmFuZG9tSW50KVxuICAgICAgICAgICAgaWYgKHJhbmRvbUludCA+IDUwKSByZXR1cm5AYXBwbHkgZWxzZSByZXR1cm5AbGV0XG4gICAgICAgfVxuICAgICAgIHByaW50bG4oXCJpbnQgbGV0IGFmdGVyIGFwcGx5XCIpXG4gICB9XG59In0=).

:::

::: details CustomerTest.http

```http
POST http://127.0.0.1:8080/customer
Content-Type: application/json

{
  "id": "100",
  "firstName": "Jane",
  "lastName": "Smith",
  "email": "jane.smith@company.com"
}


###
POST http://127.0.0.1:8080/customer
Content-Type: application/json

{
  "id": "200",
  "firstName": "John",
  "lastName": "Smith",
  "email": "john.smith@company.com"
}

###
POST http://127.0.0.1:8080/customer
Content-Type: application/json

{
  "id": "300",
  "firstName": "Mary",
  "lastName": "Smith",
  "email": "mary.smith@company.com"
}


###
GET http://127.0.0.1:8080/customer
Accept: application/json

###
GET http://127.0.0.1:8080/customer/200
Accept: application/json

###
GET http://127.0.0.1:8080/customer/500
Accept: application/json

###
DELETE http://127.0.0.1:8080/customer/100

###
DELETE http://127.0.0.1:8080/customer/500
```

:::


[This page has detailed steps](https://ktor.io/docs/creating-http-apis.html)

## PW: develop the same API with Spring Boot

- Create a project on [start.ktor.io](https://start.ktor.io/) with the following dependencies: Spring Web, Spring Boot DevTools.
- Choose Kotlin as the language and set the other settings as you like.
- Click on "Generate"
- Download the archive, unzip it, and open it with IntelliJ (preferably) or VSCode
  - For VSCode, install a [Kotlin extension](https://marketplace.visualstudio.com/search?term=kotlin&target=VSCode&category=All%20categories&sortBy=Relevance) and [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack). However, Spring extension do not seem to support kotlin.
- Create the same `Customer` data class in the `model` package withotut the `@Serializable` annotation.
- In Spring, Rest controllers serve the purpose of Ktor routes, where a controller defined a Rest resource.
- Create a `controller` package that contains a `CustomerController` class.
- Define the same endpoints as in the previous PW.
- Run and test the API. IntelliJ already provides run configurations for spring boot projects.

::: details MessageController.kt

```kotlin
val store = mutableListOf<Customer>()

@RestController
@RequestMapping("/customer")
class CustomerController {
    @GetMapping
    fun getAll() = store

    @GetMapping("{id}")
    fun getById(@PathVariable id: String) { /* TODO: implement */ }

    @PostMapping
    fun addOne(@RequestBody customer: Customer) { /* TODO: implement */ }

    @DeleteMapping("{id}")
    fun deleteOne(@PathVariable id: String) { /* TODO: implement */ }
}
```

:::

::: tip Check that you're using the latest version of Kotlin
For example, on a Gradle project, The tag `kotlin.version` in `pom.xml` configures the Kotlin version used in the project.
Please change it to the latest version.
:::

::: tip models or model package ? plural or not ?

Both are ok as long as you follow the same convention in the project.

:::

### Completed projects

- [ktor Rest API]()
- [Spring boot Rest API]()

## Going further

These official tutorial go even further:

- [This tutorial from kotlinlang](https://kotlinlang.org/docs/jvm-spring-boot-restful.html) shows how to create a RESTful web service with a database using Spring Boot.
- [This one from spring.io](https://spring.io/guides/tutorials/spring-boot-kotlin/) show how to build a web application with Spring Boot and Kotlin.
- [Quarkus and kotlin](https://quarkus.io/guides/kotlin)