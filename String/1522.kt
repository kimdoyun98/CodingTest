package String

fun _1522() {
    buildString {
        append(readln())
        val count = count { it == 'a' }
        val temp = StringBuilder()
        var result = 1000

        forEachIndexed { index, c ->
            val left = length - index
            val sliceString = StringBuilder()
            if (left < count) {
                sliceString.append(slice(index until length))
                sliceString.append(temp.slice(0 until count - left))
            } else {
                sliceString.append(slice(index until index + count))
            }
            temp.append(c)

            result = Math.min(sliceString.count { it == 'b' }, result)
        }

        println(result)
    }
}
