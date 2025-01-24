package String

fun b_20920() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val note = HashMap<String, Int>()

    repeat(n) {
        val word = readln()

        if (word.length >= m) {
            if(note.contains(word)){
                note[word] = note[word]!! + 1
            }
            else{
                note[word] = 1
            }
        }
    }

    println(
        note
            .entries
            .sortedWith(
                compareBy(
                    { -it.value },
                    { -it.key.length },
                    { it.key }
                )

            )
            .joinToString("\n") { it.key }
    )
}
