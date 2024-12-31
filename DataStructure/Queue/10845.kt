import java.util.*

fun queue(){
  val queue: Queue<Int> = LinkedList()

  repeat(readln().toInt()){
    val input = readln().split(" ")

    when(input[0]){
      "push" -> {
        queue.add(input[1].toInt())
      }
      "pop" -> {
        println(
          if(queue.isNullOrEmpty()) -1
          else queue.poll()
        )
      }
      "size" -> {
        println(queue.size)
      }
      "empty" -> {
        println(
          if(queue.isNullOrEmpty()) 1
          else 0
        )
      }
      "front" -> {
        println(
          if(queue.isNullOrEmpty()) -1
          else queue.peek()
        )
      }
      "back" -> {
        println(
          if(queue.isNullOrEmpty()) -1
          else queue.last()
        )
      }
    }
  }
}