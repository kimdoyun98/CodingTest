fun miracle_stock(){
  val initMoney = readln().toInt()
  val priceOfDays = readln().split(" ").map{ it.toInt() }

  val bnp = Asset("BNP", initMoney, 0)
  val timing = Asset("TIMING", initMoney, 0)
  var wave = 0

  priceOfDays.forEachIndexed{ index, price ->
    if(index > 0) {
      if(price > priceOfDays[index-1]){
        if(wave < 0) wave = 1 else wave += 1
      }
      else{
        if(wave > 0) wave = -1 else wave -= 1
      }
    }

    if(bnp.money >= price) buy(bnp, price)

    if(wave >= 3) sell(timing, price)
    else if(wave <= -3) buy(timing, price)
  }

  sell(bnp, priceOfDays.last())
  sell(timing, priceOfDays.last())

  println(
    if(bnp.money == timing.money) "SAMESAME"
    else if(bnp.money > timing.money) bnp.name
    else timing.name
  )
}

private fun buy(person: Asset, price: Int){
  val count = person.money / price
  person.money -= price * count
  person.stock += count
}

private fun sell(person: Asset, price: Int){
  person.money += price * person.stock
  person.stock = 0
}

data class Asset(
  val name: String,
  var money: Int,
  var stock: Int
)