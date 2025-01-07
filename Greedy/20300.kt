package Greedy

import kotlin.math.max

fun sogangHealth(){
    readln()
    val machines = readln().split(" ").map{ it.toLong() }.sorted()
    var result = 0L

    if(machines.size % 2 == 1){
        result = machines.last()

        repeat(machines.size/2){
            val m = machines[it] + machines[machines.lastIndex - it - 1]
            result = max(result, m)
        }
    }
    else{
        repeat(machines.size/2){
            val m = machines[it] + machines[machines.lastIndex - it]
            result = max(result, m)
        }
    }

    print(result)
}
