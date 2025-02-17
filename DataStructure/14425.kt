package DataStructure

fun _14425(){
    val (n, m) = readln().split(" ").map { it.toInt() }
    var result = 0
    val map = HashMap<String, Boolean>()

    repeat(n){
        map.getOrPut(readln()){true}
    }

    repeat(m){
        if(map.containsKey(readln())) {
            result++
        }
    }

    println(result)
}
