fun light(){
  val (light, n) = readln().split(" ").map{ it.toInt() }
  val _init_ = readln().split(" ").map{ it.toInt() }
  val state = Array(light){ _init_[it] }

  repeat(n){
    val (a, b, c) = readln().split(" ").map{ it.toInt() }

    when(a){
      1 -> {
        state[b-1] = c
      }

      else -> {
        (b-1 .. c-1).forEach{
          state[it] = if(a == 2) changeState(state[it]) else if(a == 3) 0 else 1
        }
      }
    }
  }

  print(state.joinToString(" "))
}

fun changeState(state: Int): Int {
  return if(state == 0) 1 else 0 
}