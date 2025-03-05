package Greedy

fun _20365(){
    val n = readln().toInt()
    val input = readln()

    var red = 0
    var blue = 0
    var before = -1 // 0 red, 1 blue

    input.forEach {
        when(it){
            'R' -> {
                if(before == -1){
                    before = 0
                    red++
                }

                if (before == 1) {
                    before = 0
                    red++
                }
            }

            'B' -> {
                if (before == -1) {
                    before = 1
                    blue++
                }

                if (before == 0) {
                    before = 1
                    blue++
                }
            }
        }
    }

    println(1 + Math.min(red, blue))
}
