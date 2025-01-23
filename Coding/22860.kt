package Coding

import java.util.*
import kotlin.collections.HashMap

fun categorizeFolder() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val folders = HashMap<String, Folder>()

    repeat(N + M) {
        val (parent, child, isFolder) = readln().split(" ")
        if (isFolder == "1") {
            folders.getOrPut(parent){ Folder(mutableListOf(), mutableListOf()) }.folders.add(child)
            folders.getOrPut(child){ Folder(mutableListOf(), mutableListOf()) }
        } else {
            folders.getOrPut(parent){ Folder(mutableListOf(), mutableListOf()) }.files.add(child)
        }
    }

    repeat(readln().toInt()) {
        val query = readln().split("/")

        println(findFiles(folders, query.last()))
    }
}

private fun findFiles(folders: HashMap<String, Folder>, lastFolderName: String): String {
    val lastFolder = folders[lastFolderName]!!
    val queue: Queue<Folder> = LinkedList()
    queue.add(lastFolder)

    val fileType = mutableSetOf<String>()
    var totalFile = 0

    while (queue.isNotEmpty()) {
        val currentFolder = queue.poll()

        fileType.addAll(currentFolder.files)
        totalFile += currentFolder.files.size

        queue.addAll(currentFolder.folders.map { folders[it]!! })
    }

    return "${fileType.size} $totalFile"
}

data class Folder(
    val folders: MutableList<String>,
    val files: MutableList<String>
)
