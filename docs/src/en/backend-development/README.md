# Backend development

Many frameworks officially support Kotlin: [Spring](https://spring.io/blog/2017/01/04/introducing-kotlin-support-in-spring-framework-5-0), [Quarkus](https://quarkus.io/guides/kotlin), [Ktor](https://github.com/ktorio/ktor), among others [listed here](https://kotlinlang.org/docs/server-overview.html#deploying-kotlin-server-side-applications).

In addition to that, Kotlin is theoretically compatible with any framework that targets the JVM or JS. For example, this tutorial shows [how to use nodejs with Kotlin](https://medium.com/@touskar/une-application-nodejs-avec-kotlin-1969994fb1d2).
However, frameworks that do not officially support Kotlin may require some tweaking to use it.

## Ktor

Ktor is a cross-platform Kotlin library for building both HTTP clients and servers.
This makes Ktor a useful library to learn for both front-end developers for its HTTP client capabilities and backend-development for its HTTP server capabilities.
In the following, we'll create a REST API with Ktor server.

### PW: develop an API with Ktor

- Create a project on [start.ktor.io](https://start.ktor.io/) with the following plugins: ContentNegotiation, kotlinx.serialization, and Routing.
- Click on "Generate project".
- Download the archive, unzip it, and open the project with IntelliJ.
- Create a `models` package and add to it a `Customer` data class with these immutable properties `id: String, firstName: String, lastName: String, email: String`.
- Annotate the class with `@Serializable`.
- Create a new package named `routes` and add to it a file `CustomerRoutes.kt` that will contain the code for the `/customer` endpoint.
- The code below provides the implementation of some endpoints. Please implement the remaining ones.
- To enable the route call `customerRouting()` in the routing configuration file located in `plugins/Routing.kt`.
- For simplicity, use a global in-memory list of customers `val customerStorage = mutableListOf<Customer>()`.
- Run the server by running the main method.
- Test the api on the IDE by using an http file or using any other client.

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

::: details plugins/Routing.kt

```kotlin
fun Application.configureRouting() {
    routing {
        customerRouting()
    }
}
```

:::

::: tip return@label

You can specify which level you want to return with an explicit label using `return@lambda`.

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

## Spring framework

Spring is a famous framework for developing server-side applications: APIs, server generated web pages, microservices, etc.
It relies on the the Java ecosystem to build and run, thus making it compatible with Kotlin.
Even better, Spring officially supports Kotlin.
It even allows in start a new project with Kotlin and Gradle-Kotlin.
In the next section, we'll use this starter to recreate our above REST API with Spring.

### PW: Spring boot part 1 - develop the same API with Spring Boot

- Create a project on [start.spring.io (also called Spring initializr)](https://start.spring.io/) with the following dependencies: Spring Web and Spring Boot DevTools.
- Choose Kotlin as the language and Kotlin-Grade as the project manager.
- Add these dependencies: **Spring Web** and **Spring Boot DevTools**.
- Click on "Generate". Download the archive, unzip it, and open the project with IntelliJ (preferably) or VSCode.
  - For VSCode, install a [Kotlin extension](https://marketplace.visualstudio.com/search?term=kotlin&target=VSCode&category=All%20categories&sortBy=Relevance) and [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack) ( :warning: Spring extension do not seem to support kotlin).
- Check that plugins part `build.gradle.kts` uses the latest version of Kotlin. Here is what is should look like with with Kotlin _1.8.10_:

```kt
plugins {
	id("org.springframework.boot") version "3.0.4"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.10"
	kotlin("plugin.spring") version "1.8.10"
}
```

- Create the same `Customer` data class in the `model` package withotut the `@Serializable` annotation.
- Create a `controller` package that contains a `CustomerController` class which provides a CRUD using a global list. You can find a skeleton below.
  - :bulb: In Spring, Rest controllers serve the purpose of Ktor routes, where a controller defines a REST resource.
- Define the same endpoints as in the previous PW.
- Start the REST API server by running:
  - On Powershell: `.\gradlew.bat bootRun`
  - Any Unix shell: `.\gradlew bootRun`
  - IntelliJ already provides run configurations for spring boot projects.
- Please test the endpoints with a REST client. You can find http files here in [JetBrains format](https://github.com/worldline/learning-kotlin/blob/main/material/spring-boot-kt-api/customer.jetbrains.http) or [VSCode's REST Client extension](https://github.com/worldline/learning-kotlin/blob/main/material/spring-boot-kt-api/customer.vscode-resclient.http)

::: details CustomerController.kt

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

::: tip Models or model package ? plural or not ?

Both are ok as long as you follow the same convention in the project.

:::

### PW: Spring boot part 2 - adding a database

Let's go a little bit further by storing data in a database and writing some tests.

We'll use the H2 in-memory database for the sake of simplicity, since it does not require a server to run.
Classes will mapped to database tables with JPA annotations.
The database API we'll be using is called `CrudRepository`.
It is a lightweight API that provides common CRUD features by just defining an interface.

On the testing side, we'll see two different syntaxes.
The default one that is more familiar with Java style and the DSL one which is more readable and more familiar with Kotlin developers.

- Create a new Spring project using [Spring initializr](https://start.spring.io/) with Kotlin and the following dependencies: Spring Data JPA, H2 Database, Spring Boot DevTools, Spring Web
- Open the project and add this class in the `model` package `@Entity class Product(@Id @GeneratedValue var id: Long? = null, var name: String, var price: Int)`. This single defines the class as well as the minimal JPA annotations (`@Entity`, `@Id` and `@GeneratedValue`) to generate the corresponding table.
- In the `repository` package, declare the `ProductRepository` interface as follows `interface ProductRepository: CrudRepository<Product, Long>`. This is enough for Spring to generate an implementation with common features as we'll see later.
- Next, create a `ProductService` class which will contain the business logic. In terms of architecture, the controller calls a service which in turn rely on other services or repositories.

```kt
@Service
class ProductService(@Autowired val productRepository: ProductRepository) {
    fun getAll() = productRepository.findAll()

    // use findByIdOrNull instad of findById because the latter returns an optional<Product> instead of Product?
    fun getById(id: Long) = productRepository.findByIdOrNull(id)
}
```

- In the controller package, create a `ProductController` class that is mapped to `/product` and injects the with `@Autowired`. Reply to `@Get` as follows.

```kt
@RestController
@RequestMapping("/product")
class ProductController(@Autowired val productService: ProductService) {
    @GetMapping fun getAll() = productService.getAll()

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long) =
        productService.getById(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
}
```

::: tip - Please note how concise getById(@PathVariable id: Long) is

The Elvis operator `?:` allows to simplify the code.
Here is a longer version as reference.

```kt
@GetMapping("{id}")
fun getById(@PathVariable id: Long): Product {
    val product = productService.getById(id)
    if (product != null){
        return product
    }
    throw ResponseStatusException(HttpStatus.NOT_FOUND)
}
```

:::

- Let's run the project. Before running the project, we need to add a plugin that allows Kotlin classes to generate a default constructor `id("org.jetbrains.kotlin.plugin.jpa") version "1.8.10"`. The plugins should look as follows:

```js
plugins {
    id("org.jetbrains.kotlin.plugin.jpa") version "1.8.10"
	id("org.springframework.boot") version "3.0.4"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.10"
	kotlin("plugin.spring") version "1.8.10"
}
```

- As an exercise, implement these endpoints: POST a single product, DELETE by id (`/product/{id}`) and GET by id (`/product/{id}`).
  - Hint: `ProductController` already provides the necessary methods.
- Call the different endpoints with a REST client.

### PW: Spring boot part 2 - adding tests

We're going to write tests for the repository and the REST API.

### Completed projects

- [ktor Rest API](https://github.com/worldline/learning-kotlin/tree/master/material/ktor-api)
- [Spring boot Rest API](https://github.com/worldline/learning-kotlin/tree/master/material/spring-boot-kt-api)

## Going further

These official tutorials go even further:

- [This tutorial from kotlinlang](https://kotlinlang.org/docs/jvm-spring-boot-restful.html) shows how to create a RESTful web service with a database using Spring Boot.
- [This one from spring.io](https://spring.io/guides/tutorials/spring-boot-kotlin/) show how to build a web application with Spring Boot and Kotlin.
- [Quarkus and kotlin](https://quarkus.io/guides/kotlin)

## Links and references

- [mockmvc kotlin dsl](https://www.baeldung.com/kotlin/mockmvc-kotlin-dsl)
- [spring-boot-kotlin tutorial](https://spring.io/guides/tutorials/spring-boot-kotlin/)
- [Working with Kotlin and JPA](https://www.baeldung.com/kotlin/jpa)
- [Spring Data JPA How to use Kotlin nulls instead of Optional](https://stackoverflow.com/questions/47143127/spring-data-jpa-how-to-use-kotlin-nulls-instead-of-optional)
