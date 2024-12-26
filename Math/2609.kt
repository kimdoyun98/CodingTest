fun lcm_gcd(){
  val (a, b) = readln().split(" ").map{ it.toInt() }
  println(gcd(a, b))
  print(lcm(a, b))
}

private fun lcm(a: Int, b: Int): Int {
  return a * b / gcd(a, b)
}

private fun gcd(a: Int, b: Int): Int {
  return if(a < b) {
    if(a == 0) b else gcd(a, b % a)
  } else {
    if(b == 0) a else gcd(b, a % b)
  }
}