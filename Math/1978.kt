fun find_prime(){
  readln()
  val numberList = readln().split(" ").map{ it.toInt() }

  var count = 0
  numberList.forEach{
    if(isPrime(it)) count++
  }

  print(count)
}

private fun isPrime(number: Int): Boolean {
  if(number <= 1) return false

  for(i in 2 .. Math.sqrt(number.toDouble()).toLong()){
    if(number % i == 0L) return false
  }

  return true
}