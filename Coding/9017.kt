fun crossContry(){
  repeat(readln().toInt()){
    readln().toInt()
    val scoreList = readln().split(" ").map{ it.toInt() }.toMutableList()
    val teamScore = HashMap<Int, MutableList<Int>>()

    val failTeams = scoreList
      .groupBy{ it }
      .toList()
      .filter{ it.second.size < 6 }
      .map{ it.first }

    scoreList.removeAll(failTeams)

    scoreList.forEachIndexed{ index, team -> 
      teamScore.getOrPut(team){ mutableListOf<Int>() }.add(index+1)
    }

    val result = teamScore.toList().sortedWith(
      compareBy(
        { team ->
          var sum = 0
          repeat(4){ sum += team.second[it] }
          sum
        },
        { team ->
          team.second[4]
        }
      )
    )
    println(result[0].first)
  }
}