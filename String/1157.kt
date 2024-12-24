fun study_word(){
  val list = readln().toList()
    .map{ it.uppercase() }
    .groupBy { it }
    .toList()
    .sortedByDescending{ it.second.size }

  val count = list.count { it.second.size == list[0].second.size }
  println(if(count == 1) list[0].first else "?")
}