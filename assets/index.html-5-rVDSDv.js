import{_ as e}from"./kotlin-wasm-webapp-R4_9ho9v.js";import{_ as s,c as a,a as t,o as l}from"./app-wjbM40hc.js";const o="/learning-kotlin/assets/kotlin-wasm-flag-BKaaN9Pq.png",i="/learning-kotlin/assets/wasm-build-conf-edit-CmamvRv7.png",p="/learning-kotlin/assets/wasm-run-configuration-x_w9-EC1.png",r="/learning-kotlin/assets/compose-multiplaform-web-wH6XfCHb.gif",u="/learning-kotlin/assets/compose-multiplaform-Dfyu_rxB.gif",c={};function d(m,n){return l(),a("div",null,n[0]||(n[0]=[t('<h1 id="📚-developpement-frontend" tabindex="-1"><a class="header-anchor" href="#📚-developpement-frontend"><span>📚 Développement frontend</span></a></h1><p>Kotlin supporte une large sélection de frameworks frontaux sur toutes les plateformes : mobile, desktop et web. Vous trouverez ci-dessous un aperçu des possibilités que vous pouvez faire directement à partir d&#39;IntelliJ :</p><ul><li>Côté bureau <ul><li>Grâce au support de la JVM, Kotlin supporte <a href="https://openjfx.io/" target="_blank" rel="noopener noreferrer">JavaFX</a>. 💡 Il existe même un équivalent en Kotlin appelé <a href="https://tornadofx.io/" target="_blank" rel="noopener noreferrer">tornadofx</a>.</li><li><a href="https://www.jetbrains.com/lp/compose-mpp/" target="_blank" rel="noopener noreferrer">Compose Multiplatform</a> apporte l&#39;API Jetpack Compose sur le bureau, le web et le mobile.</li></ul></li><li>Sur le web <ul><li><a href="https://ktor.io/docs/creating-interactive-website.html" target="_blank" rel="noopener noreferrer">Ktor</a> peut utiliser des moteurs de modèles <a href="https://freemarker.apache.org/" target="_blank" rel="noopener noreferrer">tels que FreeMarker</a> pour créer des pages de serveur.</li><li>Avec KotlinJS, les développeurs peuvent créer des applications React, nodsjs ou vanilla JS en utilisant Kotlin.</li><li>Kotlin WASM se compile en Web Assembly. Il peut compléter KotlinJS pour les tâches à forte intensité de calcul.</li><li><a href="https://www.jetbrains.com/lp/compose-mpp/" target="_blank" rel="noopener noreferrer">Compose Multiplatform</a> apporte deux options sur le web: Compose web et Compose for Web Canvas.</li></ul></li><li>Sur les mobiles <ul><li>Les développeurs Android utilisent <a href="https://developer.android.com/jetpack/compose" target="_blank" rel="noopener noreferrer">Jetpack Compose</a> ou l&#39;ancienne méthode de <strong>layout XML</strong>.</li><li><a href="https://www.jetbrains.com/lp/compose-mpp/" target="_blank" rel="noopener noreferrer">Compose Multiplatform</a> supporte Android de façon stable et iOS de façon expérimentale.</li></ul></li></ul><p>Comme nous pouvons le voir, Kotlin propose plusieurs options. L&#39;option la plus séduisante en terme de partage de code est Compose Multiplatform. Ceci est possible notamment grâce à <strong>KMP</strong></p><h2 id="kmp" tabindex="-1"><a class="header-anchor" href="#kmp"><span>KMP</span></a></h2><ul><li>KMP (Kotlin Multiplatform) permet de partager une base de code unique sur plusieurs cibles.</li><li><a href="https://blog.jetbrains.com/kotlin/2021/08/compose-multiplatform-goes-alpha/" target="_blank" rel="noopener noreferrer">KMP</a> s&#39;appuie sur Kotlin native et d&#39;autres fonctionnalités de Kotlin pour aider les développeurs à créer des projets destinés à plusieurs plates-formes en utilisant une base de code Kotlin commune.</li></ul><p><img src="https://kotlinlang.org/docs/images/kotlin-multiplatform.png" alt="KMP"></p><ul><li>De nombreuses combinaisons de cibles et de cas d&#39;utilisation sont possibles : <ul><li><a href="https://kotlinlang.org/docs/multiplatform-full-stack-app.html" target="_blank" rel="noopener noreferrer">Full-Stack web apps</a> : Un projet qui contient un backend et une application web tout en partageant une logique commune.</li><li><a href="https://kotlinlang.org/docs/multiplatform-library.html" target="_blank" rel="noopener noreferrer">Bibliothèques multiplateformes</a></li></ul></li><li>KMM est une ancienne dénomination qui est dépréciée.</li></ul><p>Dans la suite de ce chapitre, nous explorerons les différentes possibilités individuellement et on fera un projet KMP dans le chapitre suivant.</p><h2 id="kotlin-js-et-kotlin-wasm" tabindex="-1"><a class="header-anchor" href="#kotlin-js-et-kotlin-wasm"><span>Kotlin/JS et Kotlin/WASM</span></a></h2><ul><li>Kotlin/JS peut également cibler le web et même utiliser des frameworks web (tels que react) dans Kolitn.</li><li>Kotlin WASM est une autre possibilité de cibler le web, mais il génère WASM au lieu de code JS pur. <ul><li>Il peut être utilisé par exemple pour développer des bibliothèques à forte intensité de calcul.</li></ul></li><li>Nous pourrons peut-être faire encore plus à l&#39;avenir grâce à l&#39;évolution de toutes ces technologies (Kotlin, WASM et Kotlin/WASM). - Par exemple, [WASI] (https://wasi.dev/) permet à WASM de communiquer avec le système d&#39;exploitation. - Cela signifie que je pourrais voir des projets Kotlin/WASM à l&#39;avenir qui peuvent cibler à la fois le navigateur et le système d&#39;exploitation.</li><li>Continuons à observer 😄.</li></ul><h3 id="🧪-application-web-kotlin-wasm" tabindex="-1"><a class="header-anchor" href="#🧪-application-web-kotlin-wasm"><span>🧪 Application web Kotlin/WASM</span></a></h3><ul><li>Les assistants de création de projet Kotlin/WASM et Kotlin/JS sur IntelliJ fonctionnent de manière similaire: <ul><li>L&#39;IDE génère un fichier Kotlin qui sera compilé par la suite en WASM et/ou JS. Kotlin/JS ne génère que du JS tandis que Kotin/WASM génère à la fois du JS et du WASM.</li><li>Dans les deux cas, le point d&#39;entrée du code généré est un fichier JS appelé <strong>nom_du_module.js</strong>.</li><li>L&#39;IDE génère également dans le dossier des ressources un fichier <strong>index.html</strong> dont le but est de charger le JS généré (le fichier <strong>nom_du_module.js</strong>).</li><li>La tâche <code>wasmBrowserDevelopmentRun</code> ou <code>jsWasmBrowserDevelopmentRun</code> lancera un serveur local qui hébergera à la fois les fichiers <strong>index.html</strong> et les fichiers JS et WASM générés.</li></ul></li><li>Créons une application Kotlin/WASM. Tout d&#39;abord, activez l&#39;assistant Kotlin/WASM en activant <strong>kotlin.wasm.wizard</strong> dans le registre d&#39;IntelliJ (ouvrez le registre en appuyant deux fois sur shift et en tapant &quot;registry&quot; dans la boîte de recherche). Alternativement, clonez <a href="https://github.com/worldline/learning-kotlin/tree/main/material/kotlin-wasm-starter" target="_blank" rel="noopener noreferrer">ce projet</a>.</li></ul><p><img src="'+o+'" alt=""></p><ul><li>Vérifiez qu&#39;on est sur la dernière version de Kotlin dans <strong>build.gradle.kts</strong> (l&#39;assistant peut le configurer à une version antérieure).</li><li>Ouvrez <strong>src/wasmMain/kotlin/sample.kt</strong> et cliquez sur le bouton <strong>lancer</strong> qui apparaît à côté de la fonction <code>main</code>.</li><li>Si la compilation échoue parce que l&#39;IDE a utilisé la mauvaise tâche gradle, veuillez la changer en <code>wasmBrowserDevelopmentRun</code> et essayez de l&#39;exécuter à nouveau.</li></ul><p><img src="'+i+'" alt=""><img src="'+p+'" alt=""></p><ul><li>Le serveur de développement devrait démarrer et vous pouvez ouvrir votre application web sur <a href="http://localhost:8080/" target="_blank" rel="noopener noreferrer">http://localhost:8080/</a></li><li>⚠️ Il se peut que vous deviez activer certains drapeaux sur votre navigateur pour que l&#39;application fonctionne. Si vous voyez une page blanche, veuillez lire les journaux du navigateur pour vérifier les instructions.</li></ul><p><img src="'+e+`" alt=""></p><ul><li>Le fichier wasm généré est disponible dans <strong>build/js/packages/nom_du_projet/kotlin</strong></li><li>WASM étant un format binaire, nous devons d&#39;abord le convertir au format texte. <ul><li>Nous pouvons soit installer [WABT (The WebAssembly Binary Toolkit ou wabbit)] (https://github.com/WebAssembly/wabt) et utiliser l&#39;outil <em>wasm2wattool</em> <code>wasm2wat --enable-all -v .\\kotlin-wasm-demo-wasm.wasm -o wasm.wat</code>,</li><li>ou utiliser un convertisseur en ligne <a href="https://webassembly.github.io/wabt/demo/wasm2wat/" target="_blank" rel="noopener noreferrer">comme celui-ci</a></li><li>❗ Cependant, je n&#39;ai pas réussi à le faire fonctionner</li></ul></li></ul><h3 id="🧪-application-web-kotlinjs" tabindex="-1"><a class="header-anchor" href="#🧪-application-web-kotlinjs"><span>🧪 Application web KotlinJS</span></a></h3><p>L&#39;assistant Kotlin/JS crée une application très similaire à celle de Kotlin/WASM. Dans un prochain PW, nous créerons une application complète avec Ktor et Kotlin/JS.</p><h2 id="compose" tabindex="-1"><a class="header-anchor" href="#compose"><span>Compose</span></a></h2><p><a href="https://blog.jetbrains.com/kotlin/2021/08/compose-multiplatform-goes-alpha/" target="_blank" rel="noopener noreferrer">Compose multiplatform</a> est une famille de frameworks d&#39;interface utilisateur déclaratifs pour Android (Jetpack Compose), le bureau (Compose Desktop) et le web (Compose Web). Il dispose d&#39;un support expérimental pour iOS et Web Canvas.</p><div class="hint-container warning"><p class="hint-container-title">Compose multiplatform vs Jetpack Compose</p><p>Bien que très similaire, Compose multiplatform est différent de Jetpack Compose car ce dernier n&#39;est compatible qu&#39;avec Android. Google fournit un <a href="https://developer.android.com/jetpack/compose/tutorial" target="_blank" rel="noopener noreferrer">JetPack compose tutorial</a> pour le développement Android.</p></div><div class="hint-container tip"><p class="hint-container-title">Compose Web vs Compose for Web Canvas</p><ul><li>La surface de l&#39;API de Compose Web est différente des autres cibles de Compose car elle travaille directement avec le DOM.</li><li>Compose for Web Canvas a la même surface d&#39;API que celle du Desktop, Android et iOS car il dessine sur un Canvas et ne manipule pas le DOM.</li></ul><p>Cela signifie que le premier a un meilleur support web et que le second a plus de code réutilisable.</p></div><h3 id="🧪-compose-web" tabindex="-1"><a class="header-anchor" href="#🧪-compose-web"><span>🧪 Compose Web</span></a></h3><ul><li>Créez un nouveau projet IntelliJ -&gt; Compose Multiplaform.</li><li>Choisissez &quot;Single platform&quot; -&gt; &quot;Web&quot; et remplissez les autres champs.</li><li>Choisissez <strong>Finish</strong></li><li>IntelliJ peut prendre un certain temps pour préparer le projet et peut demander d&#39;installer des plugins supplémentaires.</li><li>Lancez le serveur de développement de l&#39;application web à l&#39;aide de la commande <code> ./gradlew jsBrowserRun --continuous</code>.</li><li>Modifiez <code>Main.kt</code> comme suit et lancez l&#39;application.</li><li>Ouvrez cette adresse : <code>localhost:8080</code>.</li></ul><div class="language-kotlin line-numbers-mode" data-highlighter="prismjs" data-ext="kt" data-title="kt"><pre><code><span class="line"><span class="token keyword">fun</span> <span class="token function">main</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span></span>
<span class="line">    <span class="token function">renderComposable</span><span class="token punctuation">(</span>rootElementId <span class="token operator">=</span> <span class="token string-literal singleline"><span class="token string">&quot;root&quot;</span></span><span class="token punctuation">)</span> <span class="token punctuation">{</span></span>
<span class="line">        <span class="token function">Div</span><span class="token punctuation">(</span><span class="token punctuation">{</span> style <span class="token punctuation">{</span> <span class="token function">padding</span><span class="token punctuation">(</span><span class="token number">25</span><span class="token punctuation">.</span>px<span class="token punctuation">)</span> <span class="token punctuation">}</span> <span class="token punctuation">}</span><span class="token punctuation">)</span> <span class="token punctuation">{</span></span>
<span class="line">            <span class="token keyword">var</span> expanded <span class="token keyword">by</span> remember <span class="token punctuation">{</span> <span class="token function">mutableStateOf</span><span class="token punctuation">(</span><span class="token boolean">false</span><span class="token punctuation">)</span> <span class="token punctuation">}</span></span>
<span class="line">            <span class="token function">Button</span><span class="token punctuation">(</span></span>
<span class="line">                attrs <span class="token operator">=</span> <span class="token punctuation">{</span></span>
<span class="line">                    onClick <span class="token punctuation">{</span> expanded <span class="token operator">=</span> <span class="token operator">!</span>expanded <span class="token punctuation">}</span></span>
<span class="line">                <span class="token punctuation">}</span></span>
<span class="line">            <span class="token punctuation">)</span> <span class="token punctuation">{</span> <span class="token function">Text</span><span class="token punctuation">(</span><span class="token string-literal singleline"><span class="token string">&quot;Cliquez sur moi&quot;</span></span><span class="token punctuation">)</span> <span class="token punctuation">}</span></span>
<span class="line">            <span class="token function">Div</span><span class="token punctuation">(</span><span class="token punctuation">{</span> style <span class="token punctuation">{</span> <span class="token function">display</span><span class="token punctuation">(</span><span class="token keyword">if</span> <span class="token punctuation">(</span>expanded<span class="token punctuation">)</span> DisplayStyle<span class="token punctuation">.</span>Block <span class="token keyword">else</span> DisplayStyle<span class="token punctuation">.</span>None<span class="token punctuation">)</span> <span class="token punctuation">}</span> <span class="token punctuation">}</span><span class="token punctuation">)</span> <span class="token punctuation">{</span></span>
<span class="line">                <span class="token function">Text</span><span class="token punctuation">(</span><span class="token string-literal singleline"><span class="token string">&quot;Cliquez sur moi !&quot;</span></span><span class="token punctuation">)</span></span>
<span class="line">            <span class="token punctuation">}</span></span>
<span class="line">        <span class="token punctuation">}</span></span>
<span class="line">    <span class="token punctuation">}</span></span>
<span class="line"><span class="token punctuation">}</span></span>
<span class="line"></span></code></pre><div class="line-numbers" aria-hidden="true" style="counter-reset:line-number 0;"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="`+r+`" alt="compose multiplatform demo"></p><h3 id="🧪-compose-desktop-android-app" tabindex="-1"><a class="header-anchor" href="#🧪-compose-desktop-android-app"><span>🧪 Compose desktop + Android app</span></a></h3><ul><li>Créez un nouveau projet sur IntelliJ -&gt; Compose Multiplatform.</li><li>Choisissez &quot;multiple platforms&quot; et remplissez les autres champs. Choisissez ensuite <strong>Finish</strong>.</li><li>IntelliJ commence à préparer le projet et peut demander l&#39;installation de plugins.</li><li>Une fois le projet prêt, lancez l&#39;application Android en utilisant le bouton vert run.</li><li>Lancez l&#39;application desktop en exécutant la fonction principale du projet desktop (qui devrait se trouver dans <code>Main.kt</code>).</li><li>Modifiez <code>App.kt</code> dans le projet principal comme suit et lancez l&#39;application.</li></ul><div class="language-kotlin line-numbers-mode" data-highlighter="prismjs" data-ext="kt" data-title="kt"><pre><code><span class="line"><span class="token annotation builtin">@Composable</span></span>
<span class="line"><span class="token keyword">fun</span> <span class="token function">App</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token punctuation">{</span></span>
<span class="line">    <span class="token keyword">val</span> platformName <span class="token operator">=</span> <span class="token function">getPlatformName</span><span class="token punctuation">(</span><span class="token punctuation">)</span></span>
<span class="line">    Card <span class="token punctuation">{</span></span>
<span class="line">        <span class="token keyword">var</span> expanded <span class="token keyword">by</span> remember <span class="token punctuation">{</span> <span class="token function">mutableStateOf</span><span class="token punctuation">(</span><span class="token boolean">false</span><span class="token punctuation">)</span> <span class="token punctuation">}</span></span>
<span class="line">        <span class="token function">Column</span><span class="token punctuation">(</span>Modifier<span class="token punctuation">.</span><span class="token function">clickable</span> <span class="token punctuation">{</span> expanded <span class="token operator">=</span> <span class="token operator">!</span>expanded <span class="token punctuation">}</span><span class="token punctuation">)</span> <span class="token punctuation">{</span></span>
<span class="line">            <span class="token function">Texte</span><span class="token punctuation">(</span></span>
<span class="line">                text<span class="token operator">=</span><span class="token string-literal singleline"><span class="token string">&quot;Cliquez sur moi !&quot;</span></span><span class="token punctuation">,</span></span>
<span class="line">                style <span class="token operator">=</span> MaterialTheme<span class="token punctuation">.</span>typography<span class="token punctuation">.</span>h2</span>
<span class="line">            <span class="token punctuation">)</span></span>
<span class="line">            <span class="token function">AnimatedVisibility</span><span class="token punctuation">(</span>expanded<span class="token punctuation">)</span><span class="token punctuation">{</span></span>
<span class="line">                <span class="token function">Texte</span><span class="token punctuation">(</span></span>
<span class="line">                    text <span class="token operator">=</span> <span class="token string-literal singleline"><span class="token string">&quot;Bonjour, </span><span class="token interpolation"><span class="token interpolation-punctuation punctuation">\${</span><span class="token expression">platformName</span><span class="token interpolation-punctuation punctuation">}</span></span><span class="token string"> 🎊&quot;</span></span><span class="token punctuation">,</span></span>
<span class="line">                    style <span class="token operator">=</span> MaterialTheme<span class="token punctuation">.</span>typography<span class="token punctuation">.</span>h1</span>
<span class="line">                <span class="token punctuation">)</span></span>
<span class="line">            <span class="token punctuation">}</span></span>
<span class="line">        <span class="token punctuation">}</span></span>
<span class="line">    <span class="token punctuation">}</span></span>
<span class="line"><span class="token punctuation">}</span></span>
<span class="line"></span></code></pre><div class="line-numbers" aria-hidden="true" style="counter-reset:line-number 0;"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><img src="`+u+'" alt="compose multiplatform demo"></p><h2 id="pour-aller-plus-loin" tabindex="-1"><a class="header-anchor" href="#pour-aller-plus-loin"><span>Pour aller plus loin</span></a></h2><ul><li><a href="https://seb.deleuze.fr/the-huge-potential-of-kotlin-wasm/" target="_blank" rel="noopener noreferrer">L&#39;énorme potentiel de Kotlin/Wasm</a></li></ul>',35)]))}const v=s(c,[["render",d],["__file","index.html.vue"]]),f=JSON.parse('{"path":"/fr/front-development/","title":"📚 Développement frontend","lang":"fr-FR","frontmatter":{},"headers":[{"level":2,"title":"KMP","slug":"kmp","link":"#kmp","children":[]},{"level":2,"title":"Kotlin/JS et Kotlin/WASM","slug":"kotlin-js-et-kotlin-wasm","link":"#kotlin-js-et-kotlin-wasm","children":[{"level":3,"title":"🧪 Application web Kotlin/WASM","slug":"🧪-application-web-kotlin-wasm","link":"#🧪-application-web-kotlin-wasm","children":[]},{"level":3,"title":"🧪 Application web KotlinJS","slug":"🧪-application-web-kotlinjs","link":"#🧪-application-web-kotlinjs","children":[]}]},{"level":2,"title":"Compose","slug":"compose","link":"#compose","children":[{"level":3,"title":"🧪 Compose Web","slug":"🧪-compose-web","link":"#🧪-compose-web","children":[]},{"level":3,"title":"🧪 Compose desktop + Android app","slug":"🧪-compose-desktop-android-app","link":"#🧪-compose-desktop-android-app","children":[]}]},{"level":2,"title":"Pour aller plus loin","slug":"pour-aller-plus-loin","link":"#pour-aller-plus-loin","children":[]}],"git":{"updatedTime":1734356975000,"contributors":[{"name":"Yassine Benabbas","email":"1958676+yostane@users.noreply.github.com","commits":1}]},"filePathRelative":"fr/front-development/README.md"}');export{v as comp,f as data};