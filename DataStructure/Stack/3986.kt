package DataStructure.Stack

fun goodWord(){
    var result = 0
    repeat(readln().toInt()){
        val word = readln()

        val string = buildString {
            word.forEach {
                if(this.isNotBlank() && this.last() == it){
                    setLength(this.length - 1)
                }
                else {
                    append(it)
                }
            }
        }

        if(string.isBlank()) result++
    }
    print(result)
}
