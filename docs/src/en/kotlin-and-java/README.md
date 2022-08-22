# Kotlin and Java

- Kotlin is designed with Java interoperability in mind
- Kotlin code may require annotation to be called from Java
- It is much more easier and natural to call Java from Kotli
  - For example: Java getter and Setter is converter to Kotlin propoerty

## Java from Kotlin example

```kotlin
import java.util.*
fun convertToArrayList(source: List<Int>): ArrayList<Int> {
    // instantiate as in Java without 'new'
    val list = ArrayList<Int>()
    // 'for'-loops work for Java collections:
    for (item in source) list.add(item)
    // get and set are called
    for (i in 0..source.size - 1) list[i] = source[i]
    return list
}
fun main(){
    val list = convertToArrayList(listOf(0, 2, -1))
    println("list: ${list}. type: ${list::class.qualifiedName}")
    //list: [0, 2, -1]. type: java.util.ArrayList
}
```