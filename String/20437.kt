package String

fun _20437() {
    repeat(readln().toInt()) {
        buildString {
            append(readln())
            val n = readln().toInt()

            val map = HashMap<Char, Int>()
            for (c in 'a'..'z') {
                map.getOrPut(c) { count { it == c } }
            }
            val vaildWords = map.entries.filter { it.value >= n }.map { it.key }
            val alphabetIndex = HashMap<Char, MutableList<IndexCount>>()
            var short = 10001
            var long = -1

            forEachIndexed { index, c ->
                if (vaildWords.contains(c)) {
                    alphabetIndex.getOrPut(c) { mutableListOf(IndexCount(index)) }
                        .apply {
                            add(IndexCount(index))

                            forEach {
                                if(it.count < n){
                                    it.count++
                                    if (it.count == n) {
                                        val stringLength = index - it.index + 1
                                        short = Math.min(short, stringLength)
                                        long = Math.max(long, stringLength)
                                    }
                                }
                            }
                        }
                }
            }

            if (short == 10001 && long == -1) println(-1)
            else println("$short $long")
        }
    }
}

data class IndexCount(
    val index: Int,
    var count: Int = 0
)
