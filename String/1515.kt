package String

fun b_1515(){
    buildString {
        append(readln())

        var result = 1

        while(isNotEmpty()){
            val currentNum = StringBuilder(result.toString())

            while(isNotEmpty()){
                if(!currentNum.contains(get(0))) break

                val index = currentNum.indexOf(get(0))
                currentNum.delete(0, index+1)

                delete(0, 1)
            }

            result++
        }

        if(result == 1) print(1)
        else print(result-1)
    }
}
