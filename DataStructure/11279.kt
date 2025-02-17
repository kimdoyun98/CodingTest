package DataStructure

import java.util.*

fun _11279() {
    val arr = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(readln().toInt()) {
        val input = readln().toInt()

        if (input == 0) {
            if (arr.isEmpty()) println(0)
            else println(arr.poll())
        } else {
            arr.add(input)
        }
    }
}