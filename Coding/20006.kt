package Coding

fun rankWaiting() {
    val (p, m) = readln().split(" ").map { it.toInt() }
    val rooms = mutableListOf<Room>()

    repeat(p) {
        val (level, name) = readln().split(" ")
        val player = Player(name, level.toInt())

        val enterRoom =
            rooms.filter { it.player.size < m && it.minLevel <= player.level && it.maxLevel >= player.level }
                .sortedBy { it.create }

        if (enterRoom.isEmpty()) {
            rooms.add(
                Room(
                    player = mutableListOf(player),
                    minLevel = player.level - 10,
                    maxLevel = player.level + 10,
                    create = rooms.size
                )
            )
        } else {
            enterRoom.first().player.add(player)
        }
    }

    print(rooms.sortedBy { it.create }.joinToString("\n") { it.toString(m) })
}

data class Room(
    val player: MutableList<Player>,
    val minLevel: Int,
    val maxLevel: Int,
    val create: Int
) {
    fun toString(m: Int): String {
        val sortPlayer = player.sortedBy { it.name }.joinToString("\n") { it.toString() }

        return if (player.size == m) "Started!\n$sortPlayer" else "Waiting!\n$sortPlayer"
    }
}

data class Player(
    val name: String,
    val level: Int
) {
    override fun toString(): String {
        return "$level $name"
    }
}
