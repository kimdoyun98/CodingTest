package BFS

import java.util.*

fun _3055(){
    val (a, b) = readln().split(" ").map{ it.toInt() }
    val playerQueue: Queue<S> = LinkedList()
    val waterQueue: Queue<Water> = LinkedList()
    val arr = Array(a){
        val input = readln().toMutableList()
        input.forEachIndexed { index, s ->
            if(s == 'S') playerQueue.add(S(it, index))
            if(s == '*') waterQueue.add(Water(it, index))
        }
        input
    }

    val dirX = arrayOf(1, -1, 0, 0)
    val dirY = arrayOf(0, 0, 1, -1)

    // 물 먼저 차고 이동
    while(playerQueue.isNotEmpty()){
        repeat(waterQueue.size){
            val currentWater = waterQueue.poll()
            for(i in 0..3){
                val nextX = currentWater.x + dirX[i]
                val nextY = currentWater.y + dirY[i]

                if(nextX < 0 || nextY < 0 || nextX >= a || nextY >= b) continue

                if(arr[nextX][nextY] == '.'){
                    waterQueue.add(Water(nextX, nextY))
                    arr[nextX][nextY] = '*'
                }
            }
        }

        repeat(playerQueue.size){
            val currentPlayer = playerQueue.poll()
            for(i in 0..3){
                val nextX = currentPlayer.x + dirX[i]
                val nextY = currentPlayer.y + dirY[i]

                if(nextX < 0 || nextY < 0 || nextX >= a || nextY >= b) continue

                if(arr[nextX][nextY] == 'D'){
                    println(currentPlayer.count+1)
                    return
                }

                if(arr[nextX][nextY] == '.'){
                    playerQueue.add(S(nextX, nextY, currentPlayer.count+1))
                    arr[nextX][nextY] = 'S'
                }
            }
        }
    }

    println("KAKTUS")
}

data class S(
    val x: Int,
    val y: Int,
    val count: Int = 0
)

data class Water(
    val x: Int,
    val y: Int
)
