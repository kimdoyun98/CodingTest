package DFS

fun _10026() {
    val n = readln().toInt()
    val arr = Array(n) { readln().toList() }
    val checked = Array(n) { Array(n) { false } }
    val checked2 = Array(n) { Array(n) { false } }
    var result1 = 0
    var result2 = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!checked[i][j]) {
                result1++
                dfs(i, j, arr, checked, arr[i][j])
            }

            if (!checked2[i][j]) {
                result2++
                dfs(i, j, arr, checked2, arr[i][j], false)
            }
        }
    }

    println("$result1 $result2")
}

private fun dfs(
    x: Int,
    y: Int,
    board: Array<List<Char>>,
    checked: Array<Array<Boolean>>,
    color: Char,
    status: Boolean = true
) {
    if (x < 0 || y < 0 || x >= board.size || y >= board.size || checked[x][y]) return

    if(status){
        if(board[x][y] != color) return
    } else {
        if(color == 'B' && board[x][y] != color) return
        if(color != 'B' && board[x][y] == 'B') return
    }

    checked[x][y] = true

    val dirX = arrayOf(1, -1, 0, 0)
    val dirY = arrayOf(0, 0, -1, 1)

    for(i in 0..3){
        dfs(x+dirX[i], y+dirY[i], board, checked, color, status)
    }
}