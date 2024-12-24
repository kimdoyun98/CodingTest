fun read_vertical(){
  val list = mutableListOf<String>()
  repeat(5){
    list.add(readln())
  }

  (1..15).forEach{ index ->
    list.forEach{ string ->
      try{
        print(string[index-1])
      }catch(e: Exception){}
    }
  }
}