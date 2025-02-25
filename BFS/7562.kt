package BFS

import java.util.*

fun _7562(){
    repeat(readln().toInt()){
        val n = readln().toInt()
        val current = readln().split(" ").map { it.toInt() }
        val goal = readln().split(" ").map { it.toInt() }
        var result = 0

        val board = Array(n){ Array(n){ false } }
        board[current[0]][current[1]] = true

        val queue: Queue<Night> = LinkedList()
        queue.add(Night(current[0], current[1], 0))

        val dirX = arrayOf(-1, -2, -2, -1, 1, 2, 2, 1)
        val dirY = arrayOf(-2, -1, 1, 2, 2, 1, -1, -2)

        while(queue.isNotEmpty()){
            val night = queue.poll()

            for(i in dirX.indices){
                val nextX = night.x + dirX[i]
                val nextY = night.y + dirY[i]
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || board[nextX][nextY]) continue

                if(nextX == goal[0] && nextY == goal[1]){
                    result = night.count + 1
                    queue.clear()
                    break
                }

                board[nextX][nextY] = true
                queue.add(Night(nextX, nextY, night.count+1))
            }
        }

        println(result)
    }
}

data class Night(
    val x: Int,
    val y: Int,
    val count: Int
)
