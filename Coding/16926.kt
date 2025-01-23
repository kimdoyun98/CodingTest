package Coding

import java.util.*

fun rotationArray2() {
    val (n, m, r) = readln().split(" ").map { it.toInt() }
    val arr = Array(n){ readln().split(" ").map{ it.toInt() }.toIntArray() }

    repeat(r){
        rotation(n, m, 0 to 0, arr, 0)
    }

    arr.forEach {
        println(it.joinToString(" "))
    }
}

private fun rotation(
    n: Int,
    m: Int,
    start: Pair<Int, Int>,
    arr: Array<IntArray>,
    count: Int
) {
    if (count == Math.min(n, m) / 2) return

    val queue: Queue<Int> = LinkedList()
    val moveX = arrayOf(1, 0, -1, 0)
    val moveY = arrayOf(0, 1, 0, -1)

    var x = start.first
    var y = start.second

    queue.add(arr[x][y])
    repeat(4) { index ->
        val doRepeat = if(moveX[index] == 0) m-1-(count*2) else n-1-(count*2)

        repeat(doRepeat) {
            x += moveX[index]
            y += moveY[index]
            queue.add(arr[x][y])

            arr[x][y] = queue.poll()
        }
    }

    rotation(n, m, start.first + 1 to start.second + 1, arr, count+1)
}
