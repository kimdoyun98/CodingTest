fun weatherCaster(){
  val (N, _) = readln().split(" ").map{ it.toInt() }

  var c = -1

  repeat(N){
    val weather = readln()

    weather.forEachIndexed { index, w ->
      if(index != 0) print(" ")

      if(w == 'c') c = 0
      else{
        if(c != -1) c+= 1 
      }

      print(c)
    }
    println()
    c = -1
  }
}