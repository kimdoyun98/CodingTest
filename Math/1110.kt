fun add_cycle(){
  val n = readln().toInt()
  val list = Array(2){-1}
  var count = 0

  list[0] = n/10
  list[1] = n%10

  while(true){
    val sec = (list[0] + list[1])%10

    list[0] = list[1]
    list[1] = sec

    count++
    if(n == getNumber(list)) break
  }

  print(count)
}

private fun getNumber(list: Array<Int>): Int {
  val string = list[0].toString() + list[1].toString()

  return string.toInt()
}