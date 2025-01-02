fun polyomino(){
  val board = readln().split(".")
  val A = "AAAA"
  val B = "BB"

  if(board.any{ it.length % 2 == 1 }){
    print(-1)
    return
  }

  board.forEachIndexed { index, it ->
    if(index != 0) print(".")

    val A_Count = it.length / 4
    val B_Count = (it.length - (A_Count*4)) / 2

    repeat(A_Count){ print(A) }
    repeat(B_Count){ print(B) }
  }

}