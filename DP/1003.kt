fun fibonacciFunc(){
  val n = readln().toInt()

  val numList = mutableListOf<Int>()
  repeat(n) {
    numList.add(readln().toInt())
  }

  val result = Array<Array<Int>>(numList.max()+1){ 
    if(it == 0) arrayOf(1, 0)
    else if(it == 1) arrayOf(0, 1)
    else arrayOf(-1, -1)
  }

  result.forEachIndexed { index, it ->
    if(it[0] < 0){
      it[0] = result[index-2][0] + result[index-1][0]
      it[1] = result[index-1][0] + result[index-1][1]
    }
  }

  numList.forEach {
    println(result[it].joinToString(" "))
  }
}