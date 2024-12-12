import java.util.Queue
import java.util.LinkedList

fun gradingStatus(){
  val N = readln().toInt()

  if(N == 1){
    print(0)
    return
  }

  val queue: Queue<Pair<Int, Int>> = LinkedList()
  queue.add(N to 0)

  while(!queue.isNullOrEmpty()){
    val (X, count) = queue.poll()

    if(X == 1){
      print(count)
      return
    }

    repeat(3){
      when(it) {
        0 -> if(X % 3 == 0) queue.add(X/3 to count+1)

        1 -> if(X % 2 == 0) queue.add(X/2 to count+1)

        2 -> queue.add(X-1 to count+1)
      }
    }
  }
}