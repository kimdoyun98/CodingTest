package Coding

fun calendar(){
    val calendar = Array(366){0}
    var result = 0
    var h = 1
    var w = 0

    repeat(readln().toInt()){
        val (start, end) = readln().split(" ").map { it.toInt() }
        for(i in start .. end){
            calendar[i]++
        }
    }

    calendar.forEach {
        if(it == 0){
            result += w*h
            w = 0
            h = 1
        }
        else{
            w++
            h = Math.max(h, it)
        }
    }
    result += w*h

    println(result)
}
