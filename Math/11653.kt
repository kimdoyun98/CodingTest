fun prime_factorization(){
  var N = readln().toInt()
  var num = 2

  while(N > 1){
    if(N % num == 0){
      N = N / num
      println(num)
    }
    else {
      num++
    }
  }
}