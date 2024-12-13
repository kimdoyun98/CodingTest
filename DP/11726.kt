fun tiling_2xN(){
  val n = readln().toInt()
  val arr = Array<Int>(n){
    if(it == 0) 1 else if(it == 1) 2 else -1
  }

  arr.forEachIndexed { index, it ->
    if(it == -1){
      arr[index] = (arr[index-2] + arr[index-1])%10007
    }
  }

  print(arr[n-1])
}