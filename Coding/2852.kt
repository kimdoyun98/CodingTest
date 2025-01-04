package Coding

fun basketball_NBA(){
    val done = "48:00"
    val result = Array<Int>(2){0}
    var winScoreA = 0
    var winScoreB = 0
    var startWinnerTime = -1

    repeat(readln().toInt()){
        val (team, time) = readln().split(" ")
        val nowTimeSec = getSecTime(time)
        when(team){
            "1" -> {
                winScoreA++
                if(winScoreA > winScoreB && winScoreA - winScoreB == 1){
                    startWinnerTime = nowTimeSec
                }

                if(winScoreA == winScoreB){
                    result[1] += nowTimeSec - startWinnerTime
                }
            }
            "2" -> {
                winScoreB++
                if(winScoreA < winScoreB && winScoreB - winScoreA == 1){
                    startWinnerTime = nowTimeSec
                }

                if(winScoreA == winScoreB){
                    result[0] += nowTimeSec - startWinnerTime
                }
            }
        }
    }

    if(winScoreA > winScoreB){
        result[0] += getSecTime(done) - startWinnerTime
    }
    else if(winScoreA < winScoreB){
        result[1] += getSecTime(done) - startWinnerTime
    }

    print(result.joinToString("\n") { changeSecToMinute(it) })
}

private fun changeSecToMinute(sec: Int): String{
    val minute = (sec / 60).toString().padStart(2, '0')
    val second = (sec % 60).toString().padStart(2, '0')

    return "$minute:$second"
}

private fun getSecTime(time: String): Int{
    val (minute, sec) = time.split(":").map{ it.toInt() }

    return (minute*60) + sec
}