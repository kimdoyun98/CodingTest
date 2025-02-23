package DataStructure

import java.util.*

fun _3190() {
    val n = readln().toInt()
    val appleCount = readln().toInt()
    val board = Array(n) { IntArray(n) { -1 } }
    board[0][0] = 0

    repeat(appleCount) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        board[x-1][y-1] = 1
    }

    val queue: Queue<Turn> = LinkedList()
    repeat(readln().toInt()) {
        val (sec, dir) = readln().split(" ")

        queue.add(Turn(sec.toInt(), dir))
    }

    var sec = 0
    var currentDir = Turn.RIGHT
    val snake = mutableListOf<Pair<Int, Int>>(0 to 0)
    while (true) {
        sec++

        val head = snake.last()
        val nextX = head.first + currentDir[0]
        val nextY = head.second + currentDir[1]

        if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || board[nextX][nextY] == 0) {
            break
        }

        val next = board[nextX][nextY]

        when(next){
            1 -> {
                snake.add(nextX to nextY)
                board[nextX][nextY] = 0
            }
            -1 -> {
                snake.add(nextX to nextY)
                board[nextX][nextY] = 0

                val snakeTail = snake.first()
                board[snakeTail.first][snakeTail.second] = -1
                snake.removeFirst()

            }
        }

        if (queue.isNotEmpty() && queue.peek().sec == sec) {
            val dir = queue.poll().dir
            currentDir = turnDir(dir, currentDir)
        }
    }

    println(sec)
}

private fun turnDir(dir: String, current: Array<Int>): Array<Int> {
    return when (current) {
        Turn.UP -> {
            if (dir == "L") Turn.LEFT
            else Turn.RIGHT
        }

        Turn.DOWN -> {
            if (dir == "L") Turn.RIGHT
            else Turn.LEFT
        }

        Turn.RIGHT -> {
            if (dir == "L") Turn.UP
            else Turn.DOWN
        }

        else -> {
            if (dir == "L") Turn.DOWN
            else Turn.UP
        }
    }
}

data class Turn(
    val sec: Int,
    val dir: String
) {
    companion object {
        val LEFT = arrayOf(0, -1)
        val RIGHT = arrayOf(0, 1)
        val UP = arrayOf(-1, 0)
        val DOWN = arrayOf(1, 0)
    }
}
