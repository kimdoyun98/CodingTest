package DataStructure.Queue

fun card2(){
    val n = readln().toInt()
    val queue = ArrayDeque<Int>()

    repeat(n){
        queue.addFirst(it+1)
    }

    while(queue.size != 1){
        queue.removeLast()
        queue.addFirst(queue.removeLast())
    }

    println(queue.last())
}
