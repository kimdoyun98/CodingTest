package DFS

var count = 0
var result = 0
fun _1743(){
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val arr = Array(n){ IntArray(m){ 0 } }
    val checked = Array(n){ Array(m){ false } }
    val trashList = mutableListOf<Pair<Int, Int>>()

    repeat(k){
        val (r, c) = readln().split(" ").map { it.toInt() }
        arr[r-1][c-1] = 1
        trashList.add(r-1 to c-1)
    }

    for(t in trashList){
        if(checked[t.first][t.second]) continue
        dfs(t.first, t.second, arr, checked)

        result = Math.max(count, result)
        count = 0
    }

    println(result)
}

private fun dfs(x: Int, y: Int, arr: Array<IntArray>, checked: Array<Array<Boolean>>){
    val dirX = arrayOf(1, -1, 0, 0)
    val dirY = arrayOf(0, 0, 1, -1)

    count++
    checked[x][y] = true

    for(i in 0..3){
        val nextX = x + dirX[i]
        val nextY = y + dirY[i]

        if(nextX < 0 || nextY < 0 || nextX >= arr.size || nextY >= arr[0].size) continue
        if(arr[nextX][nextY] == 0 || checked[nextX][nextY]) continue

        dfs(nextX, nextY, arr , checked)
    }
}
