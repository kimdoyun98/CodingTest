package String

fun _17413(){
    buildString {
        val result = StringBuilder()
        append(readln())

        var reverse = true
        val reverseWord = StringBuilder()

        while(isNotEmpty()){
            val word = get(0)
            if(word == '<') {
                reverse = false
                result.append(reverseWord)
                reverseWord.setLength(0)
            }

            if(reverse){
                if(word == ' '){
                    result.append(reverseWord)
                    result.append(word)
                    reverseWord.setLength(0)
                }
                else{
                    reverseWord.insert(0, word)
                }
            }
            else{
                result.append(word)
            }

            if(word == '>') reverse = true
            delete(0, 1)
        }
        println(result.toString() + reverseWord.toString())
    }
}