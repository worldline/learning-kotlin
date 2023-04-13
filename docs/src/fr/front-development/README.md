# Développement frontend (25min)

Kotlin supporte une large sélection de frameworks frontaux sur toutes les plateformes : mobile, desktop et web.
Vous trouverez ci-dessous un aperçu des possibilités que vous pouvez faire directement à partir d'IntelliJ :

- Côté bureau
  - Grâce au support de la JVM, Kotlin supporte [JavaFX](https://openjfx.io/). 💡 Il existe même un équivalent en Kotlin appelé [tornadofx](https://tornadofx.io/).
  - [Compose Multiplatform](https://www.jetbrains.com/lp/compose-mpp/) apporte l'API Jetpack Compose sur le bureau, le web et le mobile.
- Sur le web
  - [Ktor](https://ktor.io/docs/creating-interactive-website.html) peut utiliser des moteurs de modèles [tels que FreeMarker](https://freemarker.apache.org/) pour créer des pages de serveur.
  - Avec KotlinJS, les développeurs peuvent créer des applications React, nodsjs ou vanilla JS en utilisant Kotlin.
  - Kotlin WASM se compile en Web Assembly. Il peut compléter KotlinJS pour les tâches à forte intensité de calcul.
  - [Compose Multiplatform](https://www.jetbrains.com/lp/compose-mpp/) apporte deux options sur le web: Compose web et Compose for Web Canvas.
- Sur les mobiles
  - Les développeurs Android utilisent [Jetpack Compose](https://developer.android.com/jetpack/compose) ou l'ancienne méthode de **layout XML**.
  - [Compose Multiplatform](https://www.jetbrains.com/lp/compose-mpp/) supporte Android de façon stable et iOS de façon expérimentale.

Comme nous pouvons le voir, Kotlin propose plusieurs options.
L'option la plus séduisante en terme de partage de code est Compose Multiplatform.
Ceci est possible notamment grâce à **KMP et KMM**

## KMP & KMM

- KMP (Kotlin Multiplatform) et KMM (Kotlin Multiplatform Mobile) sont les deux technologies Kotlin qui permettent de partager une base de code unique sur plusieurs cibles.
- [KMP](https://blog.jetbrains.com/kotlin/2021/08/compose-multiplatform-goes-alpha/) s'appuie sur Kotlin native et d'autres fonctionnalités de Kotlin pour aider les développeurs à créer des projets destinés à plusieurs plates-formes en utilisant une base de code Kotlin commune.

![KMP](https://kotlinlang.org/docs/images/kotlin-multiplatform.png)

- De nombreuses combinaisons de cibles et de cas d'utilisation sont possibles :
  - [Full-Stack web apps](https://kotlinlang.org/docs/multiplatform-full-stack-app.html) : Un projet qui contient un backend et une application web tout en partageant une logique commune.
  - [Bibliothèques multiplateformes](https://kotlinlang.org/docs/multiplatform-library.html)
  - [KMM](https://kotlinlang.org/lp/mobile/) : dénomination spéciale pour KMP lorsqu'il est utilisé pour des projets iOS et Android.
- KMM est basé sur KMP et vise à aider les développeurs mobiles à créer un SDK multiplateforme pour le mobile de façon aisée.

![KMM](https://kotlinlang.org/lp/mobile/static/sdk-313e52f7d9d3b3e3e48471ef06e8e3aa.svg)

Dans la suite de ce chapitre, nous explorerons les différentes possibilités individuellement et on fera un projet KMP dans le chapitre suivant.

## Kotlin/JS et Kotlin/WASM

- Kotlin/JS peut également cibler le web et même utiliser des frameworks web (tels que react) dans Kolitn.
- Kotlin WASM est une autre possibilité de cibler le web, mais il génère WASM au lieu de code JS pur.
  - Il peut être utilisé par exemple pour développer des bibliothèques à forte intensité de calcul.
- Nous pourrons peut-être faire encore plus à l'avenir grâce à l'évolution de toutes ces technologies (Kotlin, WASM et Kotlin/WASM). - Par exemple, [WASI] (https://wasi.dev/) permet à WASM de communiquer avec le système d'exploitation. - Cela signifie que je pourrais voir des projets Kotlin/WASM à l'avenir qui peuvent cibler à la fois le navigateur et le système d'exploitation.
- Continuons à observer 😄.

### TP : Application web Kotlin/WASM

- Les assistants de création de projet Kotlin/WASM et Kotlin/JS sur IntelliJ fonctionnent de manière similaire:
  - L'IDE génère un fichier Kotlin qui sera compilé par la suite en WASM et/ou JS. Kotlin/JS ne génère que du JS tandis que Kotin/WASM génère à la fois du JS et du WASM.
  - Dans les deux cas, le point d'entrée du code généré est un fichier JS appelé **nom_du_module.js**.
  - L'IDE génère également dans le dossier des ressources un fichier **index.html** dont le but est de charger le JS généré (le fichier **nom_du_module.js**).
  - La tâche `wasmBrowserDevelopmentRun` ou `jsWasmBrowserDevelopmentRun` lancera un serveur local qui hébergera à la fois les fichiers **index.html** et les fichiers JS et WASM générés.
- Créons une application Kotlin/WASM. Tout d'abord, activez l'assistant Kotlin/WASM en activant **kotlin.wasm.wizard** dans le registre d'IntelliJ (ouvrez le registre en appuyant deux fois sur shift et en tapant "registry" dans la boîte de recherche). Alternativement, clonez [ce projet](https://github.com/worldline/learning-kotlin/tree/main/material/kotlin-wasm-starter).

![](../../assets/kotlin-wasm-flag.png)

- Vérifiez qu'on est sur la dernière version de Kotlin dans **build.gradle.kts** (l'assistant peut le configurer à une version antérieure).
- Ouvrez **src/wasmMain/kotlin/sample.kt** et cliquez sur le bouton **lancer** qui apparaît à côté de la fonction `main`.
- Si la compilation échoue parce que l'IDE a utilisé la mauvaise tâche gradle, veuillez la changer en `wasmBrowserDevelopmentRun` et essayez de l'exécuter à nouveau.

![](../../assets/wasm-build-conf-edit.png)
![](../../assets/wasm-run-configuration.png)

- Le serveur de développement devrait démarrer et vous pouvez ouvrir votre application web sur [http://localhost:8080/](http://localhost:8080/)
- ⚠️ Il se peut que vous deviez activer certains drapeaux sur votre navigateur pour que l'application fonctionne. Si vous voyez une page blanche, veuillez lire les journaux du navigateur pour vérifier les instructions.

![](../../assets/kotlin-wasm-webapp.png)

- Le fichier wasm généré est disponible dans **build/js/packages/nom_du_projet/kotlin**
- WASM étant un format binaire, nous devons d'abord le convertir au format texte.
  - Nous pouvons soit installer [WABT (The WebAssembly Binary Toolkit ou wabbit)] (https://github.com/WebAssembly/wabt) et utiliser l'outil _wasm2wattool_ `wasm2wat --enable-all -v .\kotlin-wasm-demo-wasm.wasm -o wasm.wat`,
  - ou utiliser un convertisseur en ligne [comme celui-ci](https://webassembly.github.io/wabt/demo/wasm2wat/)
  - ❗ Cependant, je n'ai pas réussi à le faire fonctionner

### PW : Application web KotlinJS

L'assistant Kotlin/JS crée une application très similaire à celle de Kotlin/WASM.
Dans un prochain PW, nous créerons une application complète avec Ktor et Kotlin/JS.

## Compose

[Compose multiplatform](https://blog.jetbrains.com/kotlin/2021/08/compose-multiplatform-goes-alpha/) est une famille de frameworks d'interface utilisateur déclaratifs pour Android (Jetpack Compose), le bureau (Compose Desktop) et le web (Compose Web). Il dispose d'un support expérimental pour iOS et Web Canvas.

::: warning Compose multiplatform vs Jetpack Compose

Bien que très similaire, Compose multiplatform est différent de Jetpack Compose car ce dernier n'est compatible qu'avec Android.
Google fournit un [JetPack compose tutorial](https://developer.android.com/jetpack/compose/tutorial) pour le développement Android.

:::

::: tip Compose Web vs Compose for Web Canvas

- La surface de l'API de Compose Web est différente des autres cibles de Compose car elle travaille directement avec le DOM.
- Compose for Web Canvas a la même surface d'API que celle du Desktop, Android et iOS car il dessine sur un Canvas et ne manipule pas le DOM.

Cela signifie que le premier a un meilleur support web et que le second a plus de code réutilisable.

:::

### TP : Compose Web

- Créez un nouveau projet IntelliJ -> Compose Multiplaform.
- Choisissez "Single platform" -> "Web" et remplissez les autres champs.
- Choisissez **Finish**
- IntelliJ peut prendre un certain temps pour préparer le projet et peut demander d'installer des plugins supplémentaires.
- Lancez le serveur de développement de l'application web à l'aide de la commande ` ./gradlew jsBrowserRun --continuous`.
- Modifiez `Main.kt` comme suit et lancez l'application.
- Ouvrez cette adresse : `localhost:8080`.

```kotlin
fun main() {
    renderComposable(rootElementId = "root") {
        Div({ style { padding(25.px) } }) {
            var expanded by remember { mutableStateOf(false) }
            Button(
                attrs = {
                    onClick { expanded = !expanded }
                }
            ) { Text("Cliquez sur moi") }
            Div({ style { display(if (expanded) DisplayStyle.Block else DisplayStyle.None) } }) {
                Text("Cliquez sur moi !")
            }
        }
    }
}
```

![compose multiplatform demo](../../assets/compose-multiplaform-web.gif)

### TP : Compose desktop + Android app

- Créez un nouveau projet sur IntelliJ -> Compose Multiplatform.
- Choisissez "multiple platforms" et remplissez les autres champs. Choisissez ensuite **Finish**.
- IntelliJ commence à préparer le projet et peut demander l'installation de plugins.
- Une fois le projet prêt, lancez l'application Android en utilisant le bouton vert run.
- Lancez l'application desktop en exécutant la fonction principale du projet desktop (qui devrait se trouver dans `Main.kt`).
- Modifiez `App.kt` dans le projet principal comme suit et lancez l'application.

```kotlin
@Composable
fun App() {
    val platformName = getPlatformName()
    Card {
        var expanded by remember { mutableStateOf(false) }
        Column(Modifier.clickable { expanded = !expanded }) {
            Texte(
                text="Cliquez sur moi !",
                style = MaterialTheme.typography.h2
            )
            AnimatedVisibility(expanded){
                Texte(
                    text = "Bonjour, ${platformName} 🎊",
                    style = MaterialTheme.typography.h1
                )
            }
        }
    }
}
```

![compose multiplatform demo](../../assets/compose-multiplaform.gif)

## Pour aller plus loin

- [L'énorme potentiel de Kotlin/Wasm](https://seb.deleuze.fr/the-huge-potential-of-kotlin-wasm/)
