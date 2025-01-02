fun sale_2_plus_1(){
  val cart = mutableListOf<Int>()
  var result = 0
  repeat(readln().toInt()){
    cart.add(readln().toInt())
  }

  var free = cart.size / 3
  cart.sortDescending()

  cart.forEachIndexed{ index, price ->
    if((index+1) % 3 == 0 && free > 0){
      free--
    }
    else {
      result += price
    }
  }

  println(result)
}