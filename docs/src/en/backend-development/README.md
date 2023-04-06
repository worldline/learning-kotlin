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

## nodejs

Thanks to Kotlin/JS, we can write apps that targets nodejs using Kotlin.

We can even import npm libraries as long as you declare the JS API surface that you'll be using in Kotlin.
This is called **external declaration** (You can think of it as an equivalent of TypeScript's type definitions) that declares the symbols that we want to access in Kotlin thanks to [@JsModule](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.js/-js-module/) and [@JsNonModule](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.js/-js-non-module/) annotations.
Defining such external declarations can be a hassle and there seems to be no official automatic generator ([dukat](https://github.com/Kotlin/dukat) has been removed in kotlin 1.8.20).
In that case, we have two options, either write the external declaration or import it as a dependency if available.

Fortunately for us, the next PW uses expressjs for which we can find an external type declaration.

### PW: express rest API with Kotlin/JS

- In IntelliJ, create a new nodejs project
- Once the project is loaded, edit **build.gradle.ts** as follows:
  - Set the kotlin version to the latest one in the `kotlin("js")` line
  - Add these two dependencies. The first one is the [**expressJS**]() library and the second one is it external definitions provided by [chrisnkrueger/kotlin-express](https://github.com/chrisnkrueger/kotlin-express).
  - add a `useCommonJs()` line inside the the `js` block. This [is required](https://github.com/Kotlin/dukat/issues/106) to be able to use [chrisnkrueger/kotlin-express](https://github.com/chrisnkrueger/kotlin-express) in our code.

```js
implementation(npm("express", "> 4.0.0 < 5.0.0"));
implementation("dev.chriskrueger:kotlin-express:1.2.0");
```

- Modify **main.kt** as follows. This created a REST API server that listens to port 3000 and provides a **GET /hello** endpoint

```kt
data class Message(val id: Int, val message: String)

fun main() {
    val messages = listOf(Message(0, "I love Kotlin/JS"))
    val app = express.Express()
    app.get("/hello") { req, res ->
        res.send(messages)
    }

    app.listen(3000) {
        console.log("server start at port 3000")
    }
}
```

- Run the task `nodeRun` from IntelliJ of from the command line (if you have Gradle installed)
  - If you encounter an error with Yarn lock, please run the task `kotlinUpgradeYarnLock` and try again
- Add @POST, @PUT and @DELETE endpoints
- Regarding the @POST body, expressjs leaves `req.body` undefined unless we specify a **body parser**.
  - For a JSON body, we need to call `app.use(bodyParser.json())`.
  - [**bodyParser**](https://www.npmjs.com/package/body-parser) is an npm library and unfortunately, [chrisnkrueger/kotlin-express](https://github.com/chrisnkrueger/kotlin-express) does not provide an external definition for **bodyParser** as of version 1.2.0.
  - Can you try to define it yourself by reading the [library's code](https://www.npmjs.com/package/body-parser?activeTab=code) ?
  - You can find a solution [here]()

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
The database API we'll be using is called `JPARepository`.
It is a lightweight API that provides common CRUD features by just defining an interface.

On the testing side, we'll see two different syntaxes.
The default one that is more familiar with Java style and the DSL one which is more readable and more familiar with Kotlin developers.

- Create a new Spring project using [Spring initializr](https://start.spring.io/) with Kotlin and the following dependencies: Spring Data JPA, H2 Database, Spring Boot DevTools, Spring Web
- Open the project and add this class in the `model` package `@Entity class Product(@Id @GeneratedValue var id: Long? = null, var name: String, var price: Int)`. This single defines the class as well as the minimal JPA annotations (`@Entity`, `@Id` and `@GeneratedValue`) to generate the corresponding table.
- In the `repository` package, declare the `ProductRepository` interface as follows `interface ProductRepository: JpaRepository<Product, Long>`. This is enough for Spring to generate an implementation with common features as we'll see later.
- Next, create a `ProductService` class which will contain the business logic. In terms of architecture, the controller calls a service which in turn rely on other services or repositories.

::: details ProductService.kt

```kt
@Service
class ProductService(@Autowired val productRepository: ProductRepository) {
    fun getAll() = productRepository.findAll()

    // use findByIdOrNull instad of findById because the latter returns an optional<Product> instead of Product?
    fun getById(id: Long) = productRepository.findByIdOrNull(id)
}
```

:::

- In the controller package, create a `ProductController` class that is mapped to `/product` and injects the with `@Autowired`. Reply to `@Get` as follows.

::: details ProductController.kt

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

:::

::: tip Kotlin makes getById(@PathVariable id: Long) more concise

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

In addition to that, Spring provides `@ControllerAdvice` to change the exception message.
You can see an [example here](https://spring.io/guides/tutorials/rest/).

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

Spring frameworks helps perform different types of tests by providing different classes out of the box:

- Unit testing of services, repositories and the REST API. This is done through mock utilities such as `MockMVC`.
- Integration testing of the REST API using `TestRestTemplate`. In this situation, a full server is run and tested.

Most, if not all classes provided by Spring provide an elegant syntax for Java developers.
Some of them go further by taking advantage of Kotlin specific features.
In the following, we're going to focus on parts that provide Kotlin DSLs, namely unit testing the REST API with `MockMVC`.

- Create a test class `ProductControllerUnitTests` with this initial content. `MockMvc` allows to unit test the REST API. The `@AutoConfigureMockMvc` annotation allows spring to configure it automatically

```kt
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTests(
    @Autowired val mockMvc: MockMvc,
    @Autowired val productRepository: ProductRepository) {

    @BeforeEach
    fun reset(){
        productRepository.deleteAll()
    }
}
```

- Add these two tests. The first one uses a classic approach while the second take advantage of Kotlin DSL capabilities. In addition to that, we name using a more readable string literal

<CodeGroup>
  <CodeGroupItem title="Without DSL (Test Get All)">

```kt
@Test
fun testWithClassicApproach(){
    mockMvc.perform(get("/product"))
        .andExpect(status().isOk)
        .andExpect(content().string(containsString("[]")))
}
```

  </CodeGroupItem>

  <CodeGroupItem title="With DSL (Test Get Single)">

```kt
@Test
fun `test GET a single product`() {
    mockMvc.get("/product/1").andExpect {
        status { isOk() }
        jsonPath("$.name") { value("A") }
        jsonPath("$.price") { value(1) }
        content { contentType(MediaType.APPLICATION_JSON) }
    }
}
```

  </CodeGroupItem>
</CodeGroup>

- As an exercise, unit tests for the other endpoints.

::: tip The request builder of JpaRepository

Spring repositories implement requests based on the name of their methods.
For example, to get all products sorted by name, we can add this method to the interface.

```kt
interface ProductRepository: JpaRepository<Product, Long> {
    fun findAllByOrderByNameAsc(): List<Product>;
}
```

[The official documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation) provides more detailed explanations and examples.

:::

### Completed projects

- [ktor Rest API](https://github.com/worldline/learning-kotlin/tree/master/material/ktor-api)
- [Spring boot Rest API](https://github.com/worldline/learning-kotlin/tree/master/material/spring-boot-kt-api)

## Going further

These official tutorials go even further:

- [This tutorial from kotlinlang](https://kotlinlang.org/docs/jvm-spring-boot-restful.html) shows how to create a RESTful web service with a database using Spring Boot.
- [This one from spring.io](https://spring.io/guides/tutorials/spring-boot-kotlin/) show how to build a web application with Spring Boot and Kotlin.
- [Rest ÄPIs with Spring](https://spring.io/guides/tutorials/rest/)
- [Quarkus and kotlin](https://quarkus.io/guides/kotlin)

## Links and references

- [JS in Kotlin/JS](https://dev.to/mpetuska/js-in-kotlinjs-c4g)
- [mockmvc kotlin dsl](https://www.baeldung.com/kotlin/mockmvc-kotlin-dsl)
- [spring-boot-kotlin tutorial](https://spring.io/guides/tutorials/spring-boot-kotlin/)
- [Working with Kotlin and JPA](https://www.baeldung.com/kotlin/jpa)
- [Spring Data JPA How to use Kotlin nulls instead of Optional](https://stackoverflow.com/questions/47143127/spring-data-jpa-how-to-use-kotlin-nulls-instead-of-optional)
