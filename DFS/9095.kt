var count = 0
fun sum_1_2_3(){
  val nums = arrayOf(1,2,3)
  val result = mutableListOf<Int>()
  repeat(readln().toInt()) { 
    count = 0
    val number = readln().toInt()

    dfs(nums, number, 0)

    result.add(count)
  }

  result.forEach {
    println(it)
  }
}

private fun dfs(nums: Array<Int>, number: Int, sum: Int) {
  if(sum == number) {
    count += 1
    return
  }

  if(sum > number) return

  nums.forEach { n ->
    dfs(nums, number, sum+n)
  }
}