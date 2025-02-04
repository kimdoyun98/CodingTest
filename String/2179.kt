package String

fun _2179() {
    val map = HashMap<String, PrefixSet>()

    repeat(readln().toInt()) { index ->
        buildString {
            val input = readln()
            append(input)

            while (isNotEmpty()) {
                if (map.containsKey(toString())) {
                    map[toString()]!!.end.add(input)
                } else {
                    map.getOrPut(toString()) { PrefixSet(start = input to index, end = mutableListOf()) }
                }

                deleteAt(lastIndex)
            }
        }
    }

    val result = map.entries
        .filter { it.value.end.isNotEmpty() }
        .sortedWith(
            compareBy(
                { -it.key.length },
                { it.value.start.second }
            )
        ).first()

    println("${result.value.start.first}\n${result.value.end[0]}")
}

data class PrefixSet(
    val start: Pair<String, Int>,
    val end: MutableList<String>
)
