fun decryption(){
  val result = mutableListOf<Char>()

  repeat(readln().toInt()){
    readln()
      .replace(" ", "")
      .toList()
      .groupBy{ it }
      .toList()
      .sortedByDescending{ it.second.size }
      .also { list ->
        val count = list.count{ it.second.size == list[0].second.size }

        result.add(if(count == 1) list[0].first else '?')
      }
  }

  result.forEach{ println(it) }
}