package Coding

fun rainWater(){
    val (h, w) = readln().split(" ").map { it.toInt() }
    val block = readln().split(" ").map { it.toInt() }
    val result = Array(w){0}

    val startBlock = arrayOf(-1, 0)// index, blockCount
    for(index in block.indices){
        val count = block[index]

        if(startBlock[0] == -1 || (startBlock[0] == index-1 && startBlock[1] <= count)){
            startBlock[0] = index
            startBlock[1] = count
            continue
        }

        if(block[index-1] < count){
            for(i in startBlock[0]+1 until index){
                if(result[i] < count - block[i]) result[i] = count - block[i]
            }
        }

        if(startBlock[1] <= count){
            for(i in startBlock[0]+1 until index){
                result[i] = startBlock[1] - block[i]
            }
            startBlock[0] = index
            startBlock[1] = count
        }
    }
    println(result.sum())
}
