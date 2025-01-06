package Coding

fun snail() {
    val N = readln().toInt()
    val number = readln().toInt()
    val numberLocation = Array(2){ -1 }

    val arr = Array(N) { Array(N){0} }

    var startX = N/2
    var startY = N/2

    val direction = arrayOf(
        0 to -1,
        -1 to 0,
        0 to 1,
        1 to 0
    )
    var directionIndex = 0

    // 입력 > 다음위치 설정
    repeat(N * N) {
        // 입력
        arr[startX][startY] = it + 1

        if(number == it + 1) {
            numberLocation[0] = startX + 1
            numberLocation[1] = startY + 1
        }

        // 다음 위치 설정
        if(directionIndex == 3) directionIndex = 0 else directionIndex++
        val tempX = startX + direction[directionIndex].first
        val tempY = startY + direction[directionIndex].second

        if(arr[tempX][tempY] == 0){
            startX = tempX
            startY = tempY
        }
        else{
            if(directionIndex == 0) directionIndex = 3 else directionIndex--
            startX += direction[directionIndex].first
            startY += direction[directionIndex].second
        }
    }

    arr.forEach {
        println(it.joinToString(" "))
    }
    print(numberLocation.joinToString(" "))
}
