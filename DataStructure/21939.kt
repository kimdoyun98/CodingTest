package DataStructure

import java.util.*
import kotlin.collections.HashMap

fun _21939(){
    val map = HashMap<Int, Q>()
    val recommend = TreeSet<Q>{ o1, o2 ->
        val level1 = o1.level
        val level2 = o2.level

        if(level1 == level2) o1.number.compareTo(o2.number)
        else level1.compareTo(level2)
    }

    repeat(readln().toInt()){
        val (number, level) = readln().split(" ").map { it.toInt() }
        val q = Q(number, level)
        recommend.add(q)
        map[number] = q
    }

    repeat(readln().toInt()){
        val input = readln().split(" ")
        val commend = input[0]

        when(commend){
            "recommend" -> {
                val x = input[1].toInt()
                if(x == 1){
                    println(recommend.last().number)
                }
                else{
                    println(recommend.first().number)
                }
            }

            "solved" -> {
                recommend.remove(map[input[1].toInt()])
            }

            "add" -> {
                val q = Q(input[1].toInt(), input[2].toInt())
                recommend.add(q)
                map.getOrPut(input[1].toInt()){ q }
            }
        }
    }
}

data class Q(
    val number: Int,
    val level: Int
)
