fun climbingStairs(){
  val scoreList = mutableListOf<Int>()
  repeat(readln().toInt()) { 
    scoreList.add(readln().toInt())
  }

  val arr = Array<Score?>(scoreList.size){ 
    if(it == 0) Score(scoreList[it], scoreList[it]) 
    else if(it == 1) Score(scoreList[it], scoreList[0]+scoreList[it]) 
    else null
  }

  scoreList.forEachIndexed { index, score ->
    if(arr[index] == null) {
      arr[index] = Score(
        oneStep = Math.max(arr[index-2]!!.oneStep, arr[index-2]!!.twoStep) + score,
        twoStep = arr[index-1]!!.oneStep + score
      )
    }
  }

  print(
    Math.max(
      arr.last()!!.oneStep, 
      arr.last()!!.twoStep
    )
  )
}

data class Score(
  val oneStep: Int = 0,
  val twoStep: Int = 0
)
