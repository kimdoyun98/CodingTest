package DataStructure

fun _2304() {
    val list = mutableListOf<Pillar>()
    var result = 0
    repeat(readln().toInt()) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        list.add(Pillar(x = x, y = y))
    }

    list.sortBy { it.x }

    val tempList = mutableListOf<Pillar>()
    list.forEach {
        if (tempList.isEmpty() || tempList.first().y > it.y) {
            tempList.add(it)
        } else if (tempList.first().y <= it.y) {
            result += (it.x - tempList.first().x) * tempList.first().y
            tempList.clear()
            tempList.add(it)
        }
    }

    tempList.reverse()

    val temp2 = mutableListOf<Pillar>()
    tempList.forEach {
        if (temp2.isEmpty() || temp2.first().y > it.y) {
            temp2.add(it)
        } else if (temp2.first().y <= it.y) {
            result += (temp2.first().x - it.x) * temp2.first().y
            temp2.clear()
            temp2.add(it)
        }
    }

    println(result + temp2[0].y)
}

data class Pillar(
    val x: Int,
    val y: Int
)
