package DataStructure

fun _1991() {
    val nodeMap = HashMap<String, Node>()

    repeat(readln().toInt()) {
        val (nodeName, left, right) = readln().split(" ")
        val node = nodeMap.getOrPut(nodeName) { Node(null, nodeName) }
        if(left != ".") {
            node.left = left
            nodeMap[left] = Node(nodeName, left)
        }

        if(right != ".") {
            node.right = right
            nodeMap[right] = Node(nodeName, right)
        }
    }

    preorderTraversal(nodeMap)
    nodeMap.values.map { it.checked = false }
    inorderTraversal(nodeMap)
    nodeMap.values.map { it.checked = false }
    postorderTraversal(nodeMap)
}

private fun preorderTraversal(nodeMap: HashMap<String, Node>){
    var currentNode = nodeMap["A"]!!

    while(true){
        if(!currentNode.checked){
            print(currentNode.name)
            currentNode.checked = true
        }

        if(currentNode.left != null && !nodeMap[currentNode.left]!!.checked){
            currentNode = nodeMap[currentNode.left]!!
            continue
        }

        if(currentNode.right == null || nodeMap[currentNode.right]!!.checked){
            currentNode = nodeMap[currentNode.parent] ?: break
        } else {
            currentNode = nodeMap[currentNode.right]!!
        }
    }
}

private fun inorderTraversal(nodeMap: HashMap<String, Node>){
    println()
    var currentNode = nodeMap["A"]!!

    while(true){
        if(currentNode.left != null && !nodeMap[currentNode.left]!!.checked){
            currentNode = nodeMap[currentNode.left]!!
            continue
        } else {
            if(!currentNode.checked){
                print(currentNode.name)
                currentNode.checked = true
            }
        }

        if(currentNode.right != null && !nodeMap[currentNode.right]!!.checked){
            currentNode = nodeMap[currentNode.right]!!
            continue
        } else {
            currentNode = nodeMap[currentNode.parent] ?: break
        }
    }
}

private fun postorderTraversal(nodeMap: HashMap<String, Node>){
    println()
    var currentNode = nodeMap["A"]!!

    while(true){
        if(currentNode.left != null && !nodeMap[currentNode.left]!!.checked){
            currentNode = nodeMap[currentNode.left]!!
            continue
        }

        if(currentNode.right != null && !nodeMap[currentNode.right]!!.checked){
            currentNode = nodeMap[currentNode.right]!!
            continue
        } else {
            print(currentNode.name)
            currentNode.checked = true
            currentNode = nodeMap[currentNode.parent] ?: break
        }
    }
}

data class Node(
    val parent: String?,
    val name: String,
    var left: String? = null,
    var right: String? = null,
    var checked: Boolean = false
)
