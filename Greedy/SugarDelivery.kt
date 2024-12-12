fun sugarDelivery() {
  val N = readln().toInt()

  if(N % 5 == 0) {
    print(N / 5)
    return
  }

  var t = N/5
  while(t >= 0){
    var k = N - (t * 5)

    if(k % 3 == 0) return print(t + k/3)
    t -= 1
  }

  return print(-1)
}