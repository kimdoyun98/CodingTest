package Greedy

var result = -1
fun _16953() {
    val (start, target) = readln().split(" ").map { it.toLong() }

    dfs(start, target, 0)

    println(result)
}

private fun dfs(number: Long, target: Long, count: Int) {
    if (number > target) return

    if (number == target) {
        result = if (result == -1) count+1
        else Math.min(result, count+1)
        return
    }
    if(number != 0L) dfs(number*2, target, count+1)
    dfs("${number}1".toLong(), target, count+1)
}
