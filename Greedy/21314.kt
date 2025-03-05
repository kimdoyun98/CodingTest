package Greedy

fun _21314(){
    val input = readln()

    println(getMax(input))
    print(getMin(input))
}

private fun getMax(input: String): String{
    var mCount = 0

    return buildString {
        input.forEach { c ->
            if(c == 'M') mCount++

            if(c == 'K'){
                append("5")
                if(mCount != 0) append("0".repeat(mCount))
                mCount = 0
            }
        }

        if(mCount != -1) append("1".repeat(mCount))
    }
}

private fun getMin(input: String): String{
    var mCount = -1

    return buildString {
        input.forEach { c ->
            if(c == 'M') mCount++

            if(c == 'K'){
                if(mCount != -1) {
                    append("1")
                    append("0".repeat(mCount))
                }
                mCount = -1

                append("5")
            }
        }

        if(mCount != -1) {
            append("1")
            append("0".repeat(mCount))
        }
    }
}
