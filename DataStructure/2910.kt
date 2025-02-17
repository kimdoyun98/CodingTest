package DataStructure

fun _2910() {
    val (n, c) = readln().split(" ").map { it.toInt() }
    val map = HashMap<Int, Num>()
    readln()
        .split(" ")
        .mapIndexed { index, s ->
            map.getOrPut(s.toInt()) { Num(index = index) }.count++
        }

    map.entries.sortedWith(
        compareBy(
            { -it.value.count },
            { it.value.index }
        )
    ).forEach {
        repeat(it.value.count) { _ ->
            print("${it.key} ")
        }
    }
}

data class Num(
    var count: Int = 0,
    val index: Int
)
