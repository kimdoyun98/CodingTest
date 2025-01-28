package String

fun _20291() {
    val resultMap = HashMap<String, Int>()
    repeat(readln().toInt()) {
        val word = readln()
        val file = word.split(".")[1]

        if (resultMap.keys.contains(file)) {
            resultMap[file] = resultMap[file]!! + 1
        } else {
            resultMap[file] = 1
        }
    }

    println(
        resultMap.entries
            .sortedBy { it.key }
            .joinToString("\n") { "${it.key} ${it.value}" }
    )
}
