fun change_money(){
  val n = readln().toInt()

  if(n == 1 || n == 3) {
    print(-1)
    return
  }

  if((n % 5) % 2 == 1){
    val five = n/5 - 1
    val two = (n - (five*5))/2
    print(five + two)
  }
  else {
    val five = n/5
    val two = (n - (five*5))/2
    print(five + two)
  }
}