fun coin0(){
  var result = 0
  val (N, price) = readln().split(" ").map{ it.toInt() }
  var change = price

  val money = mutableListOf<Int>()
  repeat(N){
    money.add(readln().toInt())
  }

  money.sortDescending()

  money.forEach {
    result += change/it
    change %= it
  }

  println(result)
}