package String

fun _9935() {
    buildString {
        append(readln())
        val bomb = readln()
        val result = StringBuilder()

        for(c in this){
            result.append(c)

            if(result.length >= bomb.length){
                var count = 0
                for(i in bomb.indices){
                    val w = result[result.length - bomb.length + i]
                    if(w == bomb[i]) count++
                    else break

                    if(count == bomb.length){
                        result.delete(result.length - bomb.length,  result.length)
                    }
                }
            }
        }

        if (result.isEmpty()) println("FRULA")
        else println(result)
    }
}
