package DataStructure

fun _2075() {
    val n = readln().toInt()

    val arr = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val arrIndex = Array(n) { n - 1 }

    var current = arr[n - 1].indexOf(arr[n - 1].maxOf { it })
    var count = 1

    if(n == 1) println(arr[0][0])

    while (count < n) {
        arrIndex[current]--

        var currentNum = arr[arrIndex[current]][current]

        for (y in 0 until n) {
            if (currentNum < arr[arrIndex[y]][y]) {
                currentNum = arr[arrIndex[y]][y]
                current = y
            }
        }

        count++

        if (count == n) println(currentNum)
    }
}
