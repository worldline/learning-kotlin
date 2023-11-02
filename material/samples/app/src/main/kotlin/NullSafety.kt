fun main() {
    var name: String
    name = null // compile error
    val name2: String?
    name2 = null
    println(name2.length) // compile error
    print(name?.length ?: 0)
}

fun getLength2(name: String?): Int {
    if (name == null) return 0
    return name.length
}
