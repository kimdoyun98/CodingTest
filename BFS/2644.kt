package BFS

import java.util.*

fun _2644() {
    val n = readln().toInt()
    val (a, b) = readln().split(" ").map { it.toInt() }
    val arr = Array(n + 1) { Node(-1, mutableListOf()) }
    val checked = Array(n + 1){ false }
    var result = -1

    repeat(readln().toInt()) {
        val (x, y) = readln().split(" ").map { it.toInt() }

        arr[y].parent = x
        arr[x].child.add(y)
    }

    val childQueue: Queue<Pair<Node, Int>> = LinkedList()
    val parentQueue: Queue<Pair<Node, Int>> = LinkedList()
    childQueue.add(arr[a] to 0)
    parentQueue.add(arr[a] to 0)
    checked[a] = true

    while (result == -1) {
        if(parentQueue.isNotEmpty()){
            val (parentNode, count) = parentQueue.poll()
            if (parentNode.parent == b) {
                result = count + 1
                break
            }

            if (parentNode.parent != -1) {
                parentQueue.add(arr[parentNode.parent] to count + 1)
                childQueue.add(arr[parentNode.parent] to count + 1)
                checked[parentNode.parent] = true
            }
        }

        if(childQueue.isNotEmpty()){
            val (childNode, count) = childQueue.poll()

            for (child in childNode.child) {
                if(checked[child]) continue

                if (child == b) {
                    result = count + 1
                    break
                }

                childQueue.add(arr[child] to count + 1)
                checked[child] = true
            }
        }

        if(childQueue.isEmpty() && parentQueue.isEmpty()) break
    }

    println(result)
}

data class Node(
    var parent: Int,
    val child: MutableList<Int>
)
