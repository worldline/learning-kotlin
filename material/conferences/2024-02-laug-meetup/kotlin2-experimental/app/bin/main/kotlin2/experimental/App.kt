// source: https://gist.github.com/dellisd/a1e2ae1a7e6b61590bef4b2542a555a0

package kotlin2.experimental

class Test {
    val names: List<String>
        field: MutableList<String> = mutableListOf<String>()

    fun doThing() {
        names.add("Hello!")
    }
}

fun main() {
    println(C().elementList)

    val list = [1, 2, 3]
    println(list)
}
