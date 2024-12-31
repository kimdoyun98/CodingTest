import java.util.*

fun stack(){
  val stack: Deque<Int> = ArrayDeque()

  repeat(readln().toInt()){
    val input = readln().split(" ")

    when(input[0]){
      "push" -> {
        stack.add(input[1].toInt())
      }
      "pop" -> {
        println(
          if(stack.isNullOrEmpty()) -1 
          else stack.pollLast()
        )
      }
      "size" -> {
        println(stack.size)
      }
      "empty" -> {
        println(if(stack.isNullOrEmpty()) 1 else 0)
      }
      "top" -> {
        println(
          if(stack.isNullOrEmpty()) -1 
          else stack.peekLast()
        )
      }
    }
  }
}