package Coding

fun standInLine() {
    val n = readln().toInt()
    val list = readln()
        .split(" ")
        .mapIndexed { index, data -> Spot(index+1, data.toInt()) }
    val arr = Array(n){false}

    list.forEachIndexed{ index, spot ->
        if(spot.data == 0){
            arr[index] = true
            dfs(list, arr, mutableListOf(spot))
            arr[index] = false
        }
    }
}

fun dfs(spots: List<Spot>, arr: Array<Boolean>, result: MutableList<Spot>){
    if(result.size >= spots.size){
        println(result.joinToString(" ") { it.index.toString() })
        return
    }
    val copyArr = arr.copyOf()

    for(index in spots.indices){
        if(copyArr[index]) continue

        val spot = spots[index]
        val copyResult = mutableListOf<Spot>().apply { addAll(result) }

        if(result.count { it.index > spot.index} == spot.data){
            copyArr[index] = true
            copyResult.add(spots[index])
            dfs(spots, copyArr, copyResult)
            copyArr[index] = false
        }
    }
}

data class Spot(
    val index: Int,
    val data: Int
)
