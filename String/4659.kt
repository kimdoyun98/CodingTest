package String

fun sayPassword(){
    val accept = "is acceptable."
    val not_accept = "is not acceptable."

    while(true){
        val testcase = readln()
        if(testcase == "end") break

        if(checkPassword(testcase)) println("<$testcase> $accept")
        else println("<$testcase> $not_accept")
    }
}

private fun checkPassword(password: String): Boolean{
    val vowels = arrayOf('a', 'e', 'i', 'o', 'u')
    var vowelCount = 0
    var consonantCount = 0

    var firstRule = false

    password.forEachIndexed{ index, alphabet ->
        if(vowels.contains(alphabet)) {
            firstRule = true
            vowelCount++
            consonantCount = 0
        }
        else{
            vowelCount = 0
            consonantCount++
        }

        if(index != 0 && alphabet == password[index-1]){
            if(alphabet != 'e' && alphabet != 'o') return false
        }

        if(vowelCount == 3 || consonantCount == 3) return false
    }

    return firstRule
}
