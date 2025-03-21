import{_ as n,c as s,a,o as t}from"./app-D-YqA8eI.js";const l={};function c(i,e){return t(),s("div",null,e[0]||(e[0]=[a(`<h1 id="📚-fonctionnalites-avancees-de-kotlin" tabindex="-1"><a class="header-anchor" href="#📚-fonctionnalites-avancees-de-kotlin"><span>📚 Fonctionnalités avancées de Kotlin</span></a></h1><h2 id="proprietes-deleguees" tabindex="-1"><a class="header-anchor" href="#proprietes-deleguees"><span>Propriétés déléguées</span></a></h2><p>Kotlin permet de déléguer le getter et le setter d&#39;une propriété à un autre objet, appelé délégué. C&#39;est une classe qui définit les méthodes <code>getValue</code> et <code>setValue</code>.</p><p>Kotlin fournit des délégués standard tels que des propriétés paresseuses et des propriétés observables.</p><p><a href="https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbi5yYW5kb20uUmFuZG9tXG5pbXBvcnQga290bGluLnByb3BlcnRpZXMuRGVsZWdhdGVzXG5pbXBvcnQga290bGluLnJlZmxlY3QuS1Byb3BlcnR5XG5cbmNsYXNzIFN1cGVySGVybyB7XG4gICAgdmFsIHJhbmRvbVN0cmVuZ3RoOiBJbnQgYnkgbGF6eSB7XG4gICAgICAgIHByaW50bG4oXCJjb21wdXRlZFwiKVxuICAgICAgICBSYW5kb20ubmV4dEludCg1MCwgMTAwKVxuICAgIH1cbiAgICBcbiAgICB2YXIgcG93ZXJOYW1lOiBTdHJpbmcgYnkgRGVsZWdhdGVzLm9ic2VydmFibGUoXCJMYXNlclwiKSB7IF8sIG9sZCwgbmV3IC0+XG4gICAgICAgIHByaW50bG4oXCJDaGFuZ2VkIHBvd2VyIGZyb20gJG9sZCB0byAkbmV3XCIpXG4gICAgfVxuICAgIFxuICAgIHZhciBjb2RlTmFtZTogU3RyaW5nIGJ5IENhcGl0YWxpemVEZWxlZ2F0ZSgpXG59XG5cbmNsYXNzIENhcGl0YWxpemVEZWxlZ2F0ZXtcbiAgICB2YXIgdXBwZXJjYXNlZCA9IFwiXCJcbiAgICBvcGVyYXRvciBmdW4gZ2V0VmFsdWUodGhpc1JlZjogQW55PywgcHJvcGVydHk6IEtQcm9wZXJ0eTwqPik6IFN0cmluZyB7XG4gICAgICAgIHByaW50bG4oXCIkdGhpc1JlZiwgdGhhbmsgeW91IGZvciBkZWxlZ2F0aW5nICcke3Byb3BlcnR5Lm5hbWV9JyB0byBtZSFcIilcbiAgICAgICAgcmV0dXJuIHVwcGVyY2FzZWRcbiAgICB9XG5cbiAgICBvcGVyYXRvciBmdW4gc2V0VmFsdWUodGhpc1JlZjogQW55PywgcHJvcGVydHk6IEtQcm9wZXJ0eTwqPiwgdmFsdWU6IFN0cmluZykge1xuICAgICAgICBwcmludGxuKFwiJyR2YWx1ZScgaGFzIGJlZW4gYXNzaWduZWQgdG8gJyR7cHJvcGVydHkubmFtZX0nIGluICR0aGlzUmVmLlwiKVxuICAgICAgICB1cHBlcmNhc2VkID0gdmFsdWUudXBwZXJjYXNlKClcbiAgICB9XG59XG5cbmZ1biBtYWluKCkge1xuICAgdmFsIHN1cGVyTGFuZGVyID0gU3VwZXJIZXJvKClcbiAgIHByaW50bG4oc3VwZXJMYW5kZXIucmFuZG9tU3RyZW5ndGgpXG4gICBwcmludGxuKHN1cGVyTGFuZGVyLnJhbmRvbVN0cmVuZ3RoKVxuICAgXG4gICBzdXBlckxhbmRlci5wb3dlck5hbWUgPSBcInNwZWVkXCJcbiAgICBcbiAgICBzdXBlckxhbmRlci5jb2RlTmFtZSA9IFwic3VwZXJsYW5kZXJcIlxuICAgIHByaW50bG4oc3VwZXJMYW5kZXIuY29kZU5hbWUpXG59In0=" target="_blank" rel="noopener noreferrer">▶️ this code</a> illustrates delegate properties.</p><h2 id="concurrence-et-coroutines" tabindex="-1"><a class="header-anchor" href="#concurrence-et-coroutines"><span>Concurrence et coroutines</span></a></h2><p>Kotlin fournit un modèle de concurrence de haut niveau appelé <em>Coroutines</em>. Le développeur peut déléguer la gestion des threads au compilateur et à l&#39;exécution et utiliser des constructions de niveau supérieur aux threads pour exprimer des opérations asynchrones.</p><p>Les coroutines de Kotlin tournent autour de ces concepts :</p><ul><li>Une coroutine est une instance de calcul suspendable. <ul><li>Kotlin a de nombreuses méthodes pour créer une coroutine telle que <code>launch</code>.</li></ul></li><li>Une coroutine doit exister dans une portée de coroutine. <ul><li>Par exemple, <code>runBlocking</code> crée une portée de coroutine dans laquelle les coroutines peuvent être lancées.</li></ul></li><li>Une coroutine peut exécuter des fonctions de suspension qui peuvent suspendre la coroutine mais ne bloquent pas le thread. <ul><li>Par exemple : le <code>delay</code> suspend la coroutine mais ne bloque pas le thread sur lequel elle s&#39;exécute.</li><li>Les fonctions de suspension sont des opérations qui peuvent prendre du temps telles que les requêtes http et les appels au système de fichiers.</li></ul></li><li>Le qualificateur <code>suspend</code> définit une fonction de suspension. Il s&#39;exécute dans une coroutine et peut appeler d&#39;autres fonctions de suspension.</li><li><code>Flow</code> permet de générer une liste de valeurs asynchrones.</li><li><code>Deferred</code> et <code>Channel</code> transfèrent respectivement une valeur unique et un flux de valeurs entre coroutines.</li></ul><p><a href="https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbnguY29yb3V0aW5lcy4qXG5cbnN1c3BlbmQgZnVuIHJ1blNvbWV0aGluZygpIHtcbiAgICBwcmludGxuKFwic3RhcnRpbmdcIilcbiAgICBkZWxheSg1MDApXG4gICAgcHJpbnRsbihcImZpbmlzaGVkXCIpXG59XG5cbi8vIHJ1bkJsb2NraW5nIGNyZWF0ZXMgYSBDb3JvdXRpbmVTY29wZVxuZnVuIG1haW4oKSA9IHJ1bkJsb2NraW5nIHsgXG4gICAgLy8gbGF1bmNoIGEgbmV3IGNvcm91dGluZVxuICAgIGxhdW5jaCB7IFxuICAgICAgICAvLyBTdXNwZW5kIHRoZSBjb3JvdXRpbmUgYnV0IGRvZXMgbm90IGJsb2NrIHRoZSB0aHJlYWRcbiAgICAgICAgZGVsYXkoMTAwMEwpIFxuICAgICAgICBwcmludGxuKFwiV29ybGQhXCIpIFxuICAgIH1cbiAgICAgICAgXG4gICAgLy8gbWFpbiBjb3JvdXRpbmUgY29udGludWVzIHdoaWxlIGEgcHJldmlvdXMgb25lIGlzIGRlbGF5ZWRcbiAgICBwcmludGxuKFwiSGVsbG9cIikgXG4gICAgXG4gICAgdmFsIGpvYiA9IGxhdW5jaCB7XG4gICAgICAgIHJ1blNvbWV0aGluZygpXG4gICAgfVxuICAgIGpvYi5qb2luKClcbiAgICBydW5Tb21ldGhpbmcoKVxuICAgIFxufSJ9" target="_blank" rel="noopener noreferrer">▶️ this code</a> show how to create a coroutine and suspend function and how to use them.</p><p><a href="https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbnguY29yb3V0aW5lcy4qXG5pbXBvcnQga290bGlueC5jb3JvdXRpbmVzLmZsb3cuKlxuXG5mdW4gZ2VucmF0ZUFzeW5jUmFuZG9tVmFsdWVzKCk6IEZsb3c8SW50PiA9IGZsb3cgeyBcbiAgICBwcmludGxuKFwiRmxvdyBzdGFydGVkXCIpXG4gICAgZm9yIChpIGluIDAuLjEwKSB7XG4gICAgICAgIGRlbGF5KDEwMClcbiAgICAgICAgZW1pdChpKVxuICAgIH1cbn1cblxuLy8gVGhpcyBjYW4gY2F1c2UgcHJvYmxlbXMgaW4gbm90IGhhbmRsZWRlZCBjb3JyZWN0bHlcbmZ1biBnZW5yYXRlQXN5bmNSYW5kb21WYWx1ZXNJbmZpbml0ZSgpOiBGbG93PEludD4gPSBmbG93IHsgXG4gICAgcHJpbnRsbihcIkZsb3cgc3RhcnRlZFwiKVxuICAgIHZhciBpID0gMFxuICAgIHdoaWxlICh0cnVlKSB7XG4gICAgICAgIGRlbGF5KDEwMClcbiAgICAgICAgZW1pdChpKVxuICAgICAgICBpICs9IDFcbiAgICB9XG59XG5cblxuXG4vLyBydW5CbG9ja2luZyBjcmVhdGVzIGEgQ29yb3V0aW5lU2NvcGVcbmZ1biBtYWluKCkgPSBydW5CbG9ja2luZzxVbml0PiB7XG4gICAgbGF1bmNoe1xuICAgICAgICBnZW5yYXRlQXN5bmNSYW5kb21WYWx1ZXMoKS5jb2xsZWN0IHtcbiAgICAgICBcdFx0cHJpbnRsbihcIjFzdCBmbG93OiBHb3QgJGl0XCIpXG4gICBcdFx0fVxuICAgIH1cbiAgIFxuICAgbGF1bmNoe1xuICAgICAgIHdpdGhUaW1lb3V0T3JOdWxsKDEwMDApe1xuICAgICAgICAgICBnZW5yYXRlQXN5bmNSYW5kb21WYWx1ZXMoKS5jb2xsZWN0IHtcbiAgICAgICAgICAgcHJpbnRsbihcIjJuZCBmbG93OiBHb3QgJGl0XCIpXG4gICAgICAgICB9XG4gICAgICAgfVxuICAgfVxufSJ9" target="_blank" rel="noopener noreferrer">▶️ this code</a> illustrated flows.</p><p><a href="https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbnguY29yb3V0aW5lcy4qXG5pbXBvcnQga290bGlueC5jb3JvdXRpbmVzLmNoYW5uZWxzLipcblxuZnVuIG1haW4oKSA9IHJ1bkJsb2NraW5nIHtcbiAgICBcbiAgICAvLyBhc3luYyBsYXVuY2hlcyBhIGNvcm91dGluZXMgYW5kIHJldHVybnMgYSBEZWZlcnJlZDxJbnQ+XG4gICAgdmFsIGRlZmVycmVkID0gYXN5bmMge1xuICAgICAgICA0MlxuICAgIH1cbiAgICBwcmludGxuKGRlZmVycmVkLmF3YWl0KCkpXG5cbiAgICB2YWwgY2hhbm5lbCA9IENoYW5uZWw8SW50PigpXG4gICAgbGF1bmNoIHtcbiAgICAgICAgLy8gdGhpcyBtaWdodCBiZSBoZWF2eSBDUFUtY29uc3VtaW5nIGNvbXB1dGF0aW9uIG9yIGFzeW5jIGxvZ2ljLCB3ZSdsbCBqdXN0IHNlbmQgZml2ZSBzcXVhcmVzXG4gICAgICAgIGZvciAoeCBpbiAxLi41KSBjaGFubmVsLnNlbmQoeCAqIHgpXG4gICAgfVxuICAgIC8vIGhlcmUgd2UgcHJpbnQgZml2ZSByZWNlaXZlZCBpbnRlZ2VyczpcbiAgICByZXBlYXQoNSkgeyBwcmludGxuKGNoYW5uZWwucmVjZWl2ZSgpKSB9XG4gICAgcHJpbnRsbihcIkRvbmUhXCIpXG5cbn0ifQ==" target="_blank" rel="noopener noreferrer">▶️ this code</a> illustrates channels and deferred.</p><h2 id="litteral-de-fonction-avec-recepteur-et-constructeurs-de-type-securise" tabindex="-1"><a class="header-anchor" href="#litteral-de-fonction-avec-recepteur-et-constructeurs-de-type-securise"><span>Littéral de fonction avec récepteur et constructeurs de type sécurisé</span></a></h2><p>Comme vu précédemment, les extensions de fonctions ajoute du comportement à des classes existantes sans utiliser l&#39;héritage. À l&#39;intérieur de la définition de l&#39;extension de fonction, nous pouvons référencer implicitement le <strong>récepteur d&#39;extension</strong> (<code>this</code>).</p><div class="language-kotlin line-numbers-mode" data-highlighter="prismjs" data-ext="kt" data-title="kt"><pre><code><span class="line"><span class="token keyword">fun</span> String<span class="token punctuation">.</span><span class="token function">countCharacters</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">=</span> length <span class="token comment">// or this.length</span></span>
<span class="line"><span class="token function">println</span><span class="token punctuation">(</span><span class="token string-literal singleline"><span class="token string">&quot;hello&quot;</span></span><span class="token punctuation">.</span><span class="token function">countCharacters</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token comment">// prints 5</span></span>
<span class="line"></span></code></pre><div class="line-numbers" aria-hidden="true" style="counter-reset:line-number 0;"><div class="line-number"></div><div class="line-number"></div></div></div><p>Nous pouvons définir cette extension avec une fonction littérale (ou lambda) au lieu d&#39;une fonction classique (déclarée avec <code>fun</code>).</p><div class="language-kotlin line-numbers-mode" data-highlighter="prismjs" data-ext="kt" data-title="kt"><pre><code><span class="line"><span class="token keyword">var</span> extFn<span class="token operator">:</span> String<span class="token punctuation">.</span><span class="token punctuation">(</span><span class="token punctuation">)</span> <span class="token operator">-&gt;</span> Int</span>
<span class="line">extFn <span class="token operator">=</span> <span class="token punctuation">{</span> length <span class="token punctuation">}</span> <span class="token comment">// extFn is a function literal</span></span>
<span class="line"><span class="token function">println</span><span class="token punctuation">(</span><span class="token string-literal singleline"><span class="token string">&quot;hello&quot;</span></span><span class="token punctuation">.</span><span class="token function">extFn</span><span class="token punctuation">(</span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token comment">// prints 5</span></span>
<span class="line"><span class="token function">println</span><span class="token punctuation">(</span><span class="token function">extFn</span><span class="token punctuation">(</span><span class="token string-literal singleline"><span class="token string">&quot;hello&quot;</span></span><span class="token punctuation">)</span><span class="token punctuation">)</span> <span class="token comment">// prints 5</span></span>
<span class="line"></span></code></pre><div class="line-numbers" aria-hidden="true" style="counter-reset:line-number 0;"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div><p><code>extFn</code> <strong>est une fonction littérale</strong> (lambda) qui a accès au <strong>récepteur</strong> (<code>this</code>). C&#39;est pourquoi on l&#39;appelle une <strong>fonction littérale avec récepteur</strong>.</p><p><code>extFn(&quot;hello&quot;)</code> ou <code>extFn(&quot;hello&quot;)</code> appelle l&#39;extension comme prévu par les fonctions d&#39;extension.</p><p>Le type d&#39;une fonction littérale avec récepteur est <code>funName: ReceiverType.(arg1Type, arg2Type, etc.) -&gt; ReturnType</code> et est appelé avec <code>funName(receiverValue, arg1Value, etc.)</code> ou <code>receiverValue.funName(arg1Value, etc.) .)</code>. Cependant, ce n&#39;est pas l&#39;aspect le plus intéressant.</p><p>La partie importante est <code>extFn = { length }</code> qui peut être placée comme argument de fonction dans une fonction d&#39;ordre supérieur. Le développeur qui appelle la fonction d&#39;ordre supérieur doit définir <code>extFn</code>, qui à son tour a accès au récepteur. Cela permet un style de programmation assez intéressant.</p><p><a href="https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiaW1wb3J0IGtvdGxpbi5yYW5kb20uUmFuZG9tXG5cbmZ1biBtYWluKCkge1xuICAgIC8vIGZuIGlzIGEgZnVuY3Rpb24gbGl0ZXJhbHMgd2l0aCByZWNlaXZlciB0aGF0IHJldHVybnMgYW4gaW50XG4gICAgZnVuIGRvU29tZXRoaW5nV2l0aFJhbmRvbUludChmbjogSW50LigpIC0+IEludCk6IEludCB7XG4gICAgXHR2YWwgcmFuZG9tSW50ID0gUmFuZG9tLm5leHRJbnQoMzIsIDk4KVxuICAgIFx0cmV0dXJuIHJhbmRvbUludC5mbigpXG5cdH1cbiAgICAgXG4gICAgdmFsIHJlc3VsdCA9IGRvU29tZXRoaW5nV2l0aFJhbmRvbUludCB7XG4gICAgICAgIC8vIFRoZSByZWNlaXZlciBpcyBpbXBsaWNpdGx5IGF2YWlsYWJsZSBpbiB0aGlzIGxhbWJkYVxuICAgICAgICBwcmludGxuKFwidGhpczogJHRoaXNcIilcbiAgICAgICAgcHJpbnRsbihcInBsdXM6ICR7cGx1cygxMDApfVwiKVxuICAgICAgICBtaW51cyg1MDApXG4gICAgfVxuICAgIHByaW50bG4oXCJyZXN1bHQgOiAkcmVzdWx0XCIpXG59In0=" target="_blank" rel="noopener noreferrer">▶️ ce code</a> montre un example.</p><p><a href="https://kotlinlang.org/docs/type-safe-builders.htmlhttps://kotlinlang.org/docs/type-safe-builders.html" target="_blank" rel="noopener noreferrer"><strong>Les Type-safe builders</strong></a> combinent les monteurs bien nommées et les fonctions littérales avec récepteur pour créer des monteur avec un typage statique et sécurisé. La syntaxe particulière possible avec technique permet de définir une sorte de sous-langage aussi appelé DSL (domain specific language).</p><div class="hint-container tip"><p class="hint-container-title">Le pattern monteur (Builder)</p><p>Est une technique permettant <a href="https://refactoring.guru/design-patterns/builder" target="_blank" rel="noopener noreferrer">de construire des objects avec une syntaxe élégante</a>.</p><div class="language-kotlin line-numbers-mode" data-highlighter="prismjs" data-ext="kt" data-title="kt"><pre><code><span class="line"><span class="token comment">// StirngBuilder uses the builder pattern</span></span>
<span class="line"><span class="token keyword">val</span> text <span class="token operator">=</span> <span class="token function">StringBuilder</span><span class="token punctuation">(</span><span class="token string-literal singleline"><span class="token string">&quot;Temp&quot;</span></span><span class="token punctuation">)</span></span>
<span class="line">  <span class="token punctuation">.</span><span class="token function">append</span><span class="token punctuation">(</span><span class="token number">1</span><span class="token punctuation">)</span></span>
<span class="line">  <span class="token punctuation">.</span><span class="token function">append</span><span class="token punctuation">(</span><span class="token boolean">true</span><span class="token punctuation">)</span></span>
<span class="line">  <span class="token punctuation">.</span><span class="token function">append</span><span class="token punctuation">(</span><span class="token string-literal singleline"><span class="token string">&quot;friend&quot;</span></span><span class="token punctuation">)</span></span>
<span class="line">  <span class="token punctuation">.</span><span class="token function">toString</span><span class="token punctuation">(</span><span class="token punctuation">)</span></span>
<span class="line"></span></code></pre><div class="line-numbers" aria-hidden="true" style="counter-reset:line-number 0;"><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div><div class="line-number"></div></div></div></div><p><a href="https://play.kotlinlang.org/#eyJ2ZXJzaW9uIjoiMS43LjEwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiY2xhc3MgTWlsa3tcbiAgICB2YXIgYnJhbmQ6IFN0cmluZyA9IFwiXCJcbiAgICB2YXIgcXVhbnRpdHk6IEludCA9IDBcbiAgICBmdW4gYnJhbmQoaGFuZGxlcjogTWlsay4oKS0+IFN0cmluZyl7XG4gICAgICAgIGJyYW5kID0gaGFuZGxlcigpXG4gICAgfVxuICAgIGZ1biBxdWFudGl0eShoYW5kbGVyOiBNaWxrLigpLT5JbnQpe1xuICAgICAgICBxdWFudGl0eSA9IGhhbmRsZXIoKVxuICAgIH1cbiAgICBvdmVycmlkZSBmdW4gdG9TdHJpbmcoKSA9IFwiJHF1YW50aXR5IEwgb2YgbWlsayBmcm9tICRicmFuZFwiXG59XG5cbi8vIHR5cGVzYWZlIGJ1aWxkZXIgZW50cnkgcG9pbnRcbmZ1biBwcm9kdWNlTWlsayhpbml0OiBNaWxrLigpIC0+IFVuaXQpOiBNaWxrIHtcbiAgICB2YWwgbWlsayA9IE1pbGsoKVxuICAgIG1pbGsuaW5pdCgpXG4gICAgcmV0dXJuIG1pbGtcbn1cblxuZnVuIG1haW4oKXtcbiAgICB2YWwgbWlsayA9IHByb2R1Y2VNaWxrIHtcbiAgICAgICAgYnJhbmQgeyBcIlN1cGVyIG1pbGtcIiB9XG4gICAgICAgIHF1YW50aXR5IHsgMTAwIH1cbiAgICB9XG4gICAgcHJpbnRsbihtaWxrKVxufSJ9" target="_blank" rel="noopener noreferrer">Ce code montre</a> un type-safe builder basique.</p><p><a href="https://kotlinlang.org/docs/type-safe-builders.html" target="_blank" rel="noopener noreferrer">Kotlin docs</a> fournit un exemple plus avancé d&#39;un monteur de documents HTML.</p><h2 id="exercises" tabindex="-1"><a class="header-anchor" href="#exercises"><span>Exercises</span></a></h2><h3 id="exercise-1" tabindex="-1"><a class="header-anchor" href="#exercise-1"><span>Exercise 1</span></a></h3><ol><li>open the <strong>java-integration-exercise</strong> projects in the <strong>materials</strong> folder.</li><li>Have a look at the Java class we provided you in the <code>src/main/java/com/worldline/learning/kotlin/java2kotlin</code> package. <em>(yes, that&#39;s the Pokemon class)</em></li><li>Convert that Java class in Kotlin using IntelliJ&#39;s awesome copy-pasta tool! <em>(just copy paste the java code in a kotlin file, one is provided at <code>src/main/kotlin/com/worldline/learning/kotlin/java2kotlin</code>)</em></li><li>Have a look at the generated Kotlin code, and note the major differences you spot!</li></ol>`,29)]))}const p=n(l,[["render",c],["__file","index.html.vue"]]),u=JSON.parse('{"path":"/fr/kotlin-features-advanced/","title":"📚 Fonctionnalités avancées de Kotlin","lang":"fr-FR","frontmatter":{},"headers":[{"level":2,"title":"Propriétés déléguées","slug":"proprietes-deleguees","link":"#proprietes-deleguees","children":[]},{"level":2,"title":"Concurrence et coroutines","slug":"concurrence-et-coroutines","link":"#concurrence-et-coroutines","children":[]},{"level":2,"title":"Littéral de fonction avec récepteur et constructeurs de type sécurisé","slug":"litteral-de-fonction-avec-recepteur-et-constructeurs-de-type-securise","link":"#litteral-de-fonction-avec-recepteur-et-constructeurs-de-type-securise","children":[]},{"level":2,"title":"Exercises","slug":"exercises","link":"#exercises","children":[{"level":3,"title":"Exercise 1","slug":"exercise-1","link":"#exercise-1","children":[]}]}],"git":{"updatedTime":1742570977000,"contributors":[{"name":"yostane","email":"1958676+yostane@users.noreply.github.com","commits":1}]},"filePathRelative":"fr/kotlin-features-advanced/README.md"}');export{p as comp,u as data};
