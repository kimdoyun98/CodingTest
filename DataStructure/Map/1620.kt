fun pokemon(){
  val (N, M) = readln().split(" ").map{ it.toInt() }
  val book = HashMap<String, Int>()
  val bookIndex = HashMap<Int, String>()

  repeat(N) { 
    val name = readln()
    book.getOrPut(name) { it+1 }
    bookIndex.getOrPut(it+1){ name }
  }

  repeat(M){
    val quize = readln()
    try{
      val index = quize.toInt()
      println(bookIndex[index])
    } catch(e: Exception){
      println(book[quize])
    }
  }
}