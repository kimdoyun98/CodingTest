package String

fun _1213(){
    val input = readln()
    val words = input.groupBy { it }.toList().sortedByDescending { it.first }.map { it.first to it.second.size }

    val isOddLength = input.length % 2 == 1
    val odds = words.filter{ it.second % 2 == 1 }.map { it.first }

    if(odds.size > 1 || (odds.isNotEmpty() && !isOddLength)) {
        println("I'm Sorry Hansoo")
        return
    }

    buildString {
        if (isOddLength) {
            append(odds[0])
        }

        words.forEach { word ->
            repeat(word.second / 2) {
                insert(0, word.first)
                append(word.first)
            }
        }

        if (this == reverse()) println(toString())
        else println("I'm Sorry Hansoo")
    }
}
