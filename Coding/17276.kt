package Coding

import java.util.*
import kotlin.math.abs

fun rotationArray() {
    repeat(readln().toInt()) {
        val (n, angle) = readln().split(" ").map { it.toInt() }
        val arr = Array(n){ readln().split(" ").map{ it.toInt() }.toIntArray() }

        val mid = n / 2 to n / 2
        val start = mid.first to mid.second - 1

        repeat(abs(angle / 45)) {
            rotation(start, arr, 1, angle < 0)
        }

        arr.forEach {
            println(it.joinToString(" "))
        }
    }
}

private fun rotation(
    start: Pair<Int, Int>,
    arr: Array<IntArray>,
    count: Int,
    reverse: Boolean
) {
    if (start.second < 0) return

    val queue: Queue<Int> = LinkedList()
    val moveX = arrayOf(-1, 0, 0, 1, 1, 0, 0, -1)
    val moveY = arrayOf(0, 1, 1, 0, 0, -1, -1, 0)

    var x = start.first
    var y = start.second
    queue.add(arr[x][y])

    repeat(8) {
        x += moveX[it] * if(reverse) -count else count
        y += moveY[it] * count
        queue.add(arr[x][y])
        arr[x][y] = queue.poll()
    }

    rotation(start.first to start.second - 1, arr, count + 1, reverse)
}
