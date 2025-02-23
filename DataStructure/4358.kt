package DataStructure

fun _4358(){
    val map = HashMap<String, Int>()

    while(true){
        val input = readlnOrNull() ?: break

        if(map.containsKey(input)) map[input] = map[input]!! + 1
        else map[input] = 1
    }

    val total = map.values.sum()

    map.entries
        .sortedBy { it.key }
        .forEach {
            val value = it.value.toDouble()
            println("${it.key} ${String.format("%.4f", value/total*100)}")
        }
}
