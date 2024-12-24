fun prime(){
  val M = readln().toInt()
  val N = readln().toInt()

  var minNum = -1
  var sum = 0

  (M..N).forEach {
    if(isPrime(it)){
      if(minNum == -1) minNum = it
      sum += it
    }
  }

  if(sum > 0) println(sum)
  print(minNum)
}

private fun isPrime(number: Int): Boolean {
  if(number <= 1) return false

  for(i in 2..Math.sqrt(number.toDouble()).toLong()){
    if(number % i == 0L) return false
  }

  return true
}