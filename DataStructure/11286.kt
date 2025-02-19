package DataStructure

import java.util.PriorityQueue
import kotlin.math.abs

fun _11286(){
    val priorityQueue = PriorityQueue<Int>{ o1, o2 ->
        val a = abs(o1)
        val b = abs(o2)

        if(a == b) o1.compareTo(o2)
        else a.compareTo(b)
    }

    repeat(readln().toInt()){
        val n = readln().toInt()

        if(n == 0){
            if(priorityQueue.isEmpty()) println(0)
            else println(priorityQueue.poll())
        }
        else priorityQueue.add(n)
    }
}
