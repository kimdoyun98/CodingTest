fun convert_notation(){
  val (N, B) = readln().split(" ")
  var length = N.length-1
  var result = 0

  N.forEach { char ->
    val Asc = char.code
    val num = if(Asc >= 48 && Asc <= 57) Asc-48 else Asc-55

    result += num*(Math.pow(B.toDouble(), length.toDouble())).toInt()
    length--
  }

  println(result)
}