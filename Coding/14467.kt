fun cross_road_cow(){
  val map = HashMap<Int, Int>()
  var count = 0
  repeat(readln().toInt()){
    val (cow, road) = readln().split(" ").map{ it.toInt() }
    val road2 = map.getOrPut(cow){ road }

    if(road != road2) {
      count++

      map.replace(cow, road)
    }
  }

  print(count)
}