fun big(){
  val N = readln().toInt()
  val profileList = mutableListOf<Pair<Int, Int>>()
  val result = Array(N){1}

  repeat(N){
    val (hight, weight) = readln().split(" ").map{ it.toInt() }

    profileList.forEachIndexed{ index, compareProfile ->
      // 비교 대상이 profile보다 크다면 result[it] + 1
      if(hight < compareProfile.first && weight < compareProfile.second){
        result[it]++
      }
      // 비교 대상이 profile보다 작다면 result[compare] + 1
      if(hight > compareProfile.first && weight > compareProfile.second){
        result[index]++
      }
    }

    profileList.add(hight to weight)
  }

  println(result.joinToString(" "))
}