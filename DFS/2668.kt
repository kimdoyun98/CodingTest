package DFS

fun _2668() {
    val n = readln().toInt()
    val arr = Array(n + 1) { if (it == 0) -1 else readln().toInt() }
    val checked = Array(n+1) { false }
    val result = mutableSetOf<Int>()

    for (i in 1..n) {
        if (checked[i]) continue

        checked[i] = true
        dfs(i, i, checked, arr, result)
        checked[i] = false
    }

    println(result.size)
    println(result.joinToString("\n"))
}

private fun dfs(start: Int, target: Int, checked: Array<Boolean>, arr: Array<Int>, result: MutableSet<Int>) {
    if (!checked[arr[start]]) {
        checked[arr[start]] = true
        dfs(arr[start], target, checked, arr, result)
        checked[arr[start]] = false
    }

    if (arr[start] == target) result.add(target)
}