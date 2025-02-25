package BFS

import java.util.*

fun _2583() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }

    val arr: Array<Array<Boolean>> = Array(n) { Array(m) { false } }
    var areaCount = 0
    val areaList = mutableListOf<Int>()

    repeat(k) { _ ->
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }

        for (x in x1 until x2) {
            for (y in y1 until y2) {
                arr[y][x] = true
            }
        }
    }

    for (x in 0 until n) {
        for (y in 0 until m) {
            if (arr[x][y]) continue

            arr[x][y] = true
            areaList.add(bfs(arr, x to y))
            areaCount++
        }
    }

    println(areaCount)
    println(areaList.sorted().joinToString(" "))
}

private fun bfs(arr: Array<Array<Boolean>>, start: Pair<Int, Int>): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(start)
    var count = 0
    val dirX = arrayOf(1, -1, 0, 0)
    val dirY = arrayOf(0, 0, 1, -1)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        count++

        for (i in 0 until 4) {
            val nextX = x + dirX[i]
            val nextY = y + dirY[i]
            if (nextX < 0 || nextX >= arr.size || nextY < 0 || nextY >= arr[0].size || arr[nextX][nextY]) {
                continue
            }

            arr[nextX][nextY] = true
            queue.add(nextX to nextY)
        }
    }

    return count
}

