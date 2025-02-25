package DFS

fun _11724(){
    val (n, m) = readln().split(" ").map { it.toInt() }

    val arr = Array(n+1){ mutableListOf<Int>() }
    val checked = Array(n+1){ false }

    repeat(m){
        val (a, b) = readln().split(" ").map { it.toInt() }

        arr[a].add(b)
        arr[b].add(a)
    }

    var result = 0

    fun dfs(idx: Int){
        checked[idx] = true

        for(i in arr[idx]) {
            if (!checked[i]) {
                dfs(i)
            }
        }
    }

    for(i in 1..n){
        if(!checked[i]){
            result++
            dfs(i)
        }
    }
    println(result)
}
