package DataStructure.Heap

import java.util.*

fun _1927() {
    val arr = PriorityQueue<Int>()

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
