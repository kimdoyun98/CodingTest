fun fatigue(){
  val (A, B, C, M) = readln().split(" ").map{ it.toInt() }
  var tired = 0
  var task = 0

  (1..24).forEach{
    if(tired + A > M){
      tired -= C
      if(tired < 0 ) tired = 0
    }
    else{
      tired += A
      task += B
    }
  }

  print(task)
}