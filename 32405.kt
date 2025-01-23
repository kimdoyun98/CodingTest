fun battleRoyale(){
    readln()
    var players = readln()
        .split(" ")
        .map { it.toInt() }
        .zip(
            readln()
                .split(" ")
                .map { it.toInt() }
        )
        .mapIndexed{ index, pair -> Player(index+1, pair.second, pair.first) }

    var atkSum = 0
    var loop = 0

    while (players.size != 1) {
        players = players.filter { player ->
            if (player.hp > atkSum - player.ap * loop) {
                atkSum += player.ap
                true
            } else false
        }
        loop++
    }
    print(players[0].index)
}

data class Player(
    val index: Int,
    var hp: Int,
    var ap: Int
)
