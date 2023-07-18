# Développement du backend

De nombreux frameworks supportent officiellement Kotlin comme [Spring](https://spring.io/blog/2017/01/04/introducing-kotlin-support-in-spring-framework-5-0), [Quarkus](https://quarkus.io/guides/kotlin) et [Ktor](https://github.com/ktorio/ktor), parmi d'autres [listés ici](https://kotlinlang.org/docs/server-overview.html#deploying-kotlin-server-side-applications).

En outre, Kotlin est théoriquement compatible avec tout framework qui cible la JVM ou JS.
Cependant, les frameworks qui ne supportent pas officiellement Kotlin peuvent nécessiter quelques ajustements pour l'utiliser.

## Ktor

Ktor est une bibliothèque Kotlin multiplateforme permettant de développer des clients et des serveurs HTTP.
Cela fait de Ktor une bibliothèque utile à la fois aux développeurs frontend, pour la partie client HTTP, ainsi qu'aux développeurs backend, pour la partie serveur HTTP.
Dans ce qui suit, nous allons créer une API REST avec le serveur Ktor.

### TP : développer une API avec Ktor

- Créez un projet sur [start.ktor.io](https://start.ktor.io/) avec les plugins suivants : ContentNegotiation, kotlinx.serialization, et Routing.
- Cliquez sur "Generate project".
- Téléchargez l'archive, décompressez-la et ouvrez le projet avec votre IDE préféré.
- Créez un package `models` et ajoutez-y une classe de données `Customer` avec ces propriétés immuables `id : String, firstName : String, lastName : Chaîne, email : Chaîne`.
- Annotez la classe avec `@Serializable`.
- Créez un nouveau package nommé `routes` et ajoutez-y un fichier `CustomerRoutes.kt` qui contiendra le code pour l'endpoint `/customer`.
- Le code ci-dessous fournit l'implémentation de certains endpoints. Veuillez implémenter les autres.
- Pour activer la route, appelez `customerRouting()` dans le fichier de configuration du routage situé dans `plugins/Routing.kt`.
- Pour plus de simplicité, utilisez une liste globale de clients en mémoire `val store = mutableListOf<Customer>()`.
- Lancer le serveur en exécutant la méthode main.
- Tester l'API sur l'IDE en utilisant un fichier http ou en utilisant n'importe quel autre client.

::: details CustomerRoutes.kt

```kotlin
val store = mutableListOf<Customer>()

fun Route.customerRouting() {
  route("/customer") {
    get {
      call.respond(store)
    }
    get("{id?}") {
      val id = call.parameters["id"] ? : return@get call.respondText(
        "Missing id",
        status = HttpStatusCode.BadRequest
      )
      val customer =
        store.find { it.id == id } ? : return@get call.respondText(
          "Pas de client avec l'id $id",
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
      // TODO
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

Vous pouvez spécifier le niveau que vous voulez retourner avec un label explicite en utilisant `return@lambda`.

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

[Ce code exécute un autre exemple](https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbi5yYW5kb20uUmFuZG9tXG5cbi8vIHJldHVybiB3aXRoIGltcGxpY2l0IGxhYmVsc1xuXG5mdW4gbWFpbigpIHtcbiAgIHZhbCBrb3RsaW4gPSBcIvCfmYJcIlxuICAga290bGluLmxldCB7XG4gICAgICAgaXQuYXBwbHkge1xuXHRcdFx0dmFsIHJhbmRvbUludCA9IFJhbmRvbS5uZXh0SW50KDAsIDEwMClcbiAgICAgICAgICAgIHByaW50bG4ocmFuZG9tSW50KVxuICAgICAgICAgICAgaWYgKHJhbmRvbUludCA+IDUwKSByZXR1cm5AYXBwHkgZWxzZSByZXR1cm5AbGV0XG4gICAgICAgfVxuICAgICAgIHByaW50bG4oXCJpbnQgbV0IGFmdGVyIGFwcGx5XCIpXG4gICB9XG59In0=).

:::

::: details CustomerTest.http

```http
POST http://127.0.0.1:8080/customer
Content-Type : application/json

{
  "id" : "100",
  "firstName" : "Jane",
  "lastName" : "Smith",
  "email" : "jane.smith@company.com"
}


###
POST http://127.0.0.1:8080/customer
Content-Type : application/json

{
  "id" : "200",
  "firstName" : "John",
  "lastName" : "Smith",
  "email" : "john.smith@company.com"
}

###
POST http://127.0.0.1:8080/customer
Content-Type : application/json

{
  "id" : "300",
  "firstName" : "Mary",
  "lastName" : "Smith",
  "email" : "mary.smith@company.com"
}


###
GET http://127.0.0.1:8080/customer
Accept : application/json

###
GET http://127.0.0.1:8080/customer/200
Accepte : application/json

###
GET http://127.0.0.1:8080/customer/500
Accepte : application/json

###
DELETE http://127.0.0.1:8080/customer/100

###
DELETE http://127.0.0.1:8080/customer/500
```

:::

[Cette page contient des étapes détaillées](https://ktor.io/docs/creating-http-apis.html)

## nodejs

Grâce à Kotlin/JS, nous pouvons écrire des applications qui ciblent nodejs en utilisant Kotlin.

On peut même importer des librairies npm à condition de déclarer les API JS que l'on va utiliser en Kotlin.
C'est ce qu'on appelle une **déclaration externe** (vous pouvez la considérer comme un équivalent des définitions de type de TypeScript) qui déclare les symboles auxquels nous voulons accéder en Kotlin grâce aux annotations [@JsModule](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.js/-js-module/) et [@JsNonModule](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.js/-js-non-module/).
Définir de telles déclarations externes peut s'avérer fastidieux et il ne semble pas y avoir de générateur automatique officiel et stable ([dukat](https://github.com/Kotlin/dukat) a été supprimé dans kotlin 1.8.20).
Dans ce cas, nous avons deux options, soit écrire la déclaration externe nous-même, soit l'importer en tant que dépendance si elle est disponible.

Heureusement pour nous, le prochain TP utilise la librairie Express pour laquelle nous pouvons trouver une déclaration de type externe.

### TP : API Rest avec Kotlin/JS et Express

- Dans IntelliJ, créer un nouveau projet nodejs
- Une fois le projet chargé, éditer **build.gradle.ts** comme suit :
  - Mettre la dernière version de Kotlin dans la ligne contenant `kotlin("js")`.
  - Ajoutez ces deux dépendances:
    - La première est la bibliothèque [**Express**](https://expressjs.com/),
    - et la seconde est la définition externe fournie par [chrisnkrueger/kotlin-express](https://github.com/chrisnkrueger/kotlin-express).
  - ajouter une ligne `useCommonJs()` à l'intérieur du bloc `js`. Ceci [est nécessaire](https://github.com/Kotlin/dukat/issues/106) pour pouvoir utiliser [chrisnkrueger/ kotlin-express](https://github.com/chrisnkrueger/kotlin-express) dans notre code.

```js
implementation(npm("express", "> 4.0.0 < 5.0.0"));
implementation("dev.chriskrueger:kotlin-express:1.2.0");
```

- Modifiez **main.kt** comme suit. Cela crée un serveur API REST qui écoute le port 3000 et fournit une route **GET /hello**.

```kotlin
data class Message(val id : Int, val message : String)

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

- Exécutez la tâche `nodeRun` depuis votre IDE ou depuis la ligne de commande (si vous avez installé Gradle).
  - Si vous rencontrez une erreur avec Yarn lock, exécutez la tâche `kotlinUpgradeYarnLock` puis réessayez.
- Ajouter des routes en POST, PUT et DELETE
- En ce qui concerne le corps du POST, Express positionne `req.body` à `undefined` à moins que nous ne spécifions un **body parser**.
  - Pour un corps en JSON, nous devons appeler `app.use(bodyParser.json())`.
  - [**bodyParser**](https://www.npmjs.com/package/body-parser) est une bibliothèque npm et malheureusement, [chrisnkrueger/kotlin-express](https://github.com/chrisnkrueger/kotlin-express) ne fournit pas de définition externe pour **bodyParser** au moment de l'écriture de ces lignes (chrisnkrueger/kotlin-express en version 1.2.0).
  - Pouvez-vous essayer de la définir vous-même en lisant le [code de la bibliothèque](https://www.npmjs.com/package/body-parser?activeTab=code) ?
  - Vous pouvez trouver une solution [ici](https://github.com/worldline/learning-kotlin/blob/main/material/kotlin-nodejs-demo/src/main/kotlin/BodyParser.kt)

## Spring framework

Spring est un framework célèbre pour le développement d'applications côté serveur : API REST, pages web générées par le serveur, microservices, etc.
Il s'appuie sur l'écosystème Java pour la compilation et l'exécution, ce qui le rend compatible avec Kotlin.
Mieux encore, Spring supporte officiellement Kotlin.
On peut même démarrer un nouveau projet avec Kotlin et Gradle-Kotlin.
Dans la prochaine section, nous utiliserons ce projet pour recréer notre API REST plus haut avec Spring.

### TP : Spring boot part 1 - développer la même API avec Spring Boot

- Créez un projet sur [start.spring.io (aussi appelé Spring initializr)](https://start.spring.io/) avec les dépendances suivantes : Spring Web et Spring Boot DevTools.
- Choisissez Kotlin comme langage et Kotlin-Grade comme gestionnaire de projet.
- Ajoutez les dépendances suivantes : **Spring Web** et **Spring Boot DevTools**.
- Cliquez sur **Generate**. Téléchargez l'archive, décompressez-la et ouvrez le projet avec IntelliJ (de préférence) ou VSCode.
  - Pour VSCode, installez une [extension Kotlin](https://marketplace.visualstudio.com/search?term=kotlin&target=VSCode&category=All%20categories&sortBy=Relevance) et [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack) ( ⚠️ l'extension Spring ne semble pas supporter kotlin).
- Vérifiez que la partie plugins `build.gradle.kts` utilise la dernière version de Kotlin. Voici à quoi cela devrait ressembler avec Kotlin _1.8.10_ :

```kts
plugins {
  id("org.springframework.boot") version "3.0.4"
  id("io.spring.dependency-management") version "1.1.0"
  kotlin("jvm") version "1.8.10"
  kotlin("plugin.spring") version "1.8.10"
}
```

- Créez la `data class Customer` dans le package `model` (sans l'annotation `@Serializable`).
- Créez un paquetage `controller` qui contient une classe `CustomerController` qui fournit un CRUD en utilisant une liste globale.
  - Vous pouvez trouver un squelette ci-dessous.
  - 💡 Dans Spring, les contrôleurs Rest servent de routes Ktor, où un contrôleur définit une ressource REST.
- Définissez les mêmes routes que dans le TP précédent.
- Démarrez le serveur de l'API REST en exécutant :
  - Sur Powershell : `.\gradlew.bat bootRun`
  - Tout shell Unix : `.\gradlew bootRun`
  - Ou bien, vérifiez si votre IDE fournit déjà des configurations d'exécution pour les projets Spring Boot.
- Veuillez tester les routes avec un client REST. Vous pouvez trouver des fichiers **http** ici au [format JetBrains](https://github.com/worldline/learning-kotlin/blob/main/material/spring-boot-kt-api/customer.jetbrains.http) ou [ au format de l'extension REST Client de VSCode](https://github.com/worldline/learning-kotlin/blob/main/material/spring-boot-kt-api/customer.vscode-resclient.http)

::: details CustomerController.kt

```kotlin
val store = mutableListOf<Customer>()

@RestController
@RequestMapping("/customer")
class CustomerController {
    @GetMapping
    fun getAll() = store

    @GetMapping("{id}")
    fun getById(@PathVariable id : String) { /* TODO : implement */ }

    @PostMapping
    fun addOne(@RequestBody customer : Customer) { /* TODO : implement */ }

    @DeleteMapping("{id}")
    fun deleteOne(@PathVariable id : String) { /* TODO : implement */ }
}
```

:::

### TP : Spring boot partie 2 - ajouter une base de données

Allons un peu plus loin en stockant des données dans une base de données et en écrivant quelques tests.

Nous utiliserons la base de données en mémoire H2 pour des raisons de simplicité, puisqu'elle ne nécessite pas de serveur pour fonctionner.
Les classes seront mappées aux tables de la base de données avec des annotations JPA.
L'API de base de données que nous utiliserons s'appelle `JPARepository`.
C'est une API légère qui fournit des fonctionnalités CRUD communes à partir d'une simple une interface.

- Créez un nouveau projet Spring en utilisant [Spring initializr](https://start.spring.io/) avec Kotlin et les dépendances suivantes : Spring Data JPA, H2 Database, Spring Boot DevTools, Spring Web.
- Ouvrez le projet et ajoutez cette classe dans le package `model` `@Entity class Product(@Id @GeneratedValue var id : Long ? = null, var name : String, var price : Int)`. Ceci définit la classe ainsi que les annotations JPA minimales (`@Entity`, `@Id` et `@GeneratedValue`) pour générer la table correspondante.
- Dans le package `repository`, déclarez l'interface `ProductRepository` comme suit `interface ProductRepository : JpaRepository<Produit, Long>`. C'est suffisant pour que Spring génère une implémentation avec des caractéristiques communes comme nous le verrons plus tard.
- Ensuite, créez une classe `ProductService` qui contiendra la logique métier. En termes d'architecture, le contrôleur appelle un service qui, à son tour, s'appuie sur d'autres services ou référentiels.

::: details ProductService.kt

```kotlin
@Service
class ProductService(@Autowired val productRepository: ProductRepository) {
    fun getAll() = productRepository.findAll()

    // use findByIdOrNull instad of findById because the latter returns an optional<Product> instead of Product?
    fun getById(id: Long) = productRepository.findByIdOrNull(id)
}
```

:::

- Dans le package controller, créez une classe `ProductController` qui est mappée à `/product` et injectée avec `@Autowired`. Répondez à `@Get` comme suit.

::: details ProductController.kt

```kotlin
@RestController
@RequestMapping("/product")
class ProductController(@Autowired val productService : ProductService) {
    @GetMapping fun getAll() = productService.getAll()

    @GetMapping("{id}")
    fun getById(@PathVariable id : Long) =
        productService.getById(id) ? : throw ResponseStatusException(HttpStatus.NOT_FOUND)
}
```

:::

::: tip Kotlin rend getById(@PathVariable id : Long) plus concis

L'opérateur Elvis `?:` permet de simplifier le code.
Voici une version plus longue en guise de référence.

```kotlin
@GetMapping("{id}")
fun getById(@PathVariable id : Long) : Produit {
    val product = productService.getById(id)
    if (product != null){
        return product
    }
    throw ResponseStatusException(HttpStatus.NOT_FOUND)
}
```

En outre, Spring fournit `@ControllerAdvice` pour modifier le message d'exception.
Vous pouvez voir un [exemple ici] (https://spring.io/guides/tutorials/rest/).

:::

- Exécutons le projet. Avant de lancer le projet, nous devons ajouter un plugin qui permet aux classes Kotlin de générer un constructeur par défaut `id("org.jetbrains.kotlin.plugin.jpa") version "1.8.10"`. Les plugins devraient ressembler à ce qui suit :

```js
plugins {
  id("org.jetbrains.kotlin.plugin.jpa") version "1.8.10"
  id("org.springframework.boot") version "3.0.4"
  id("io.spring.dependency-management") version "1.1.0"
  kotlin("jvm") version "1.8.10"
  kotlin("plugin.spring") version "1.8.10"
}

```

- En guise d'exercice, implémentez ces routes : POST d'un seul produit, DELETE par id (`/produit/{id}`) et GET par id (`/produit/{id}`).
  - Indice : `ProductController` fournit déjà les méthodes nécessaires.
- Appelez les différents points de terminaison avec un client REST.
- Tester votre API Rest avec un client HTTP

### TP : Spring boot partie 3 - ajouter des tests

Les frameworks Spring permettent d'effectuer différents types de tests en fournissant différentes classes dès le départ :

- Tests unitaires/de composants des services et de l'API REST. Cela se fait par le biais d'utilitaires de bouchonnage tels que `MockMVC`.
- Tests d'intégration de l'API REST en utilisant `TestRestTemplate`. Dans ce cas, un serveur complet est exécuté et testé.

La plupart des classes fournies par Spring, si ce n'est toutes, offrent une syntaxe élégante pour les développeurs Java.
Certaines d'entre elles vont plus loin en tirant parti des caractéristiques spécifiques de Kotlin.
Dans ce qui suit, nous allons nous concentrer sur les parties qui fournissent des DSLs Kotlin, à savoir le test unitaire de l'API REST avec `MockMVC`.

- Créer une classe de test `ProductControllerUnitTests` avec le contenu initial ci-dessous. `MockMvc` permet de tester unitairement l'API REST. L'annotation `@AutoConfigureMockMvc` permet à Spring de la configurer automatiquement.

```kotlin
@SpringBootTest
@AutoConfigureMockMvc
classe ProductControllerTests(
    @Autowired val mockMvc : MockMvc,
    @Autowired val productRepository : ProductRepository) {

    @BeforeEach
    fun reset(){
        productRepository.deleteAll()
    }
}
```

- Ajoutez les deux tests ci-dessous. Le premier utilise une approche classique tandis que le second tire parti des capacités du DSL de Kotlin. De plus, nous utilisons une chaîne littérale plus lisible.

<CodeGroup>
  <CodeGroupItem title="Sans DSL (Test Get All)">

```kotlin
@Test
fun testWithClassicApproach(){
    mockMvc.perform(get("/product"))
        .andExpect(status().isOk)
        .andExpect(content().string(containsString("[]")))
}
```

  </CodeGroupItem>

  <CodeGroupItem title="Avec DSL (Test Get Single)">

```kotlin
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

- En guise d'exercice, écrire des tests pour les autres points d'accès.

::: tip Le constructeur de requêtes de JpaRepository

Les **repository** Spring implémentent des requêtes basées sur le nom de leurs méthodes.
Par exemple, pour obtenir tous les produits triés par nom, nous pouvons ajouter cette méthode à l'interface.

```kotlin
interface ProductRepository : JpaRepository<Produit, Long> {
    fun findAllByOrderByNameAsc() : List<Produit> ;
}
```

La [documentation officielle] (https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation) fournit des explications et des exemples plus détaillés.

:::

### Projets terminés

- [Projet Ktor](https://github.com/worldline/learning-kotlin/tree/master/material/ktor-api)
- [Projet nodejs](https://github.com/worldline/learning-kotlin/tree/master/material/kotlin-nodejs-demo)
- [Projet Spring boot](https://github.com/worldline/learning-kotlin/tree/master/material/spring-boot-kt-api)

## Aller plus loin

Ces tutoriels officiels vont encore plus loin :

- [Ce tutoriel de kotlinlang](https://kotlinlang.org/docs/jvm-spring-boot-restful.html) montre comment créer un service web RESTful avec une base de données en utilisant Spring Boot.
- [Ce tutoriel de spring.io](https://spring.io/guides/tutorials/spring-boot-kotlin/) montre comment construire une application web avec Spring Boot et Kotlin.
- [Rest APIs with Spring](https://spring.io/guides/tutorials/rest/)
- [Quarkus et Kotlin](https://quarkus.io/guides/kotlin)

## Lien et références

- [JS et Kotlin/JS](https://dev.to/mpetuska/js-in-kotlinjs-c4g)
- [mockmvc kotlin dsl](https://www.baeldung.com/kotlin/mockmvc-kotlin-dsl)
- [spring-boot-kotlin tutorial](https://spring.io/guides/tutorials/spring-boot-kotlin/)
- [Kotlin et JPA](https://www.baeldung.com/kotlin/jpa)
- [Spring Data JPA Comment utiliser les nulls Kotlin au lieu de Optional](https://stackoverflow.com/questions/47143127/spring-data-jpa-how-to-use-kotlin-nulls-instead-of-optional)
