fun common_divisor(){
  readln()
  val list = readln().split(" ").map{ it.toInt() }.sorted()

  (1..list[0]/2).forEach{
    if(isCommonDivisor(list, it)) println(it)
  }

  if(isCommonDivisor(list, list[0])) println(list[0])
}

private fun isCommonDivisor(list: List<Int>, number: Int): Boolean {
  list.forEach{
    if(it % number != 0) return false
  }

  return true
}