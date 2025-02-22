package DataStructure

import java.util.*

fun _2800() {
    val string = readln()
    val parenthesisSet = mutableListOf<Parenthesis>()
    val result: MutableSet<String> = TreeSet<String>()


    val stack: Stack<Int> = Stack<Int>()

    string.forEachIndexed { index, c ->
        if (c == '(') {
            stack.add(index)
        } else if (c == ')') {
            parenthesisSet.add(Parenthesis(stack.pop(), index))
        }
    }

    checkParenthesis(string, 0, parenthesisSet, result)

    result.remove(string)

    println(
        result
            .map { it.replace(".", "") }
            .sorted()
            .joinToString("\n")
    )
}

private fun checkParenthesis(
    string: String,
    idx: Int,
    parenthesisSet: MutableList<Parenthesis>,
    result: MutableSet<String>
) {
    if(idx == parenthesisSet.size){
        result.add(string.replace(".", ""))
        return
    }

    val newString = StringBuilder(string)

    newString.setCharAt(parenthesisSet[idx].startIndex, '.')
    newString.setCharAt(parenthesisSet[idx].endIndex, '.')

    checkParenthesis(string, idx+1, parenthesisSet, result)
    checkParenthesis(newString.toString(), idx+1, parenthesisSet, result)
}

data class Parenthesis(
    val startIndex: Int,
    var endIndex: Int
)
