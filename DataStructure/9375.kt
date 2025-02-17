package DataStructure

fun _9375() {
    repeat(readln().toInt()) { _ ->
        val map = HashMap<String, Int>()
        var result = 0

        repeat(readln().toInt()) {
            val (_, category) = readln().split(" ")

            if (map.containsKey(category)) map[category] = map[category]!! + 1
            else map[category] = 1
        }

        map.entries.forEach{ entry ->
            val num = entry.value
            val num2 = num * result

            result += num + num2
        }

        println(result)
    }
}
