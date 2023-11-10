fun main() {
    val name: String = "john doe"
    println(name.length)

    val name2: String?
    name2 = null
    print(name?.length ?: 0)
}

fun getLength2(name: String?): Int {
    if (name == null) return 0
    return name.length
}
