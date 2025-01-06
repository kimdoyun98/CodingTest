package String

fun unknown(){
    val (n, m) = readln().split(" ").map{ it.toInt() }
    val map = HashMap<String, MutableList<Int>>()

    repeat(n + m){
        val name = readln()
        map.getOrPut(name){ mutableListOf() }.add(1)
    }

    val result = map.filter { it.value.size > 1 }.keys.sorted()

    println(result.size)
    println(result.joinToString("\n"))
}
