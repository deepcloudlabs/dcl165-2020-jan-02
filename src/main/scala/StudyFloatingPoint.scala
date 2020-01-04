object StudyFloatingPoint {
  def main(args: Array[String]): Unit = {
    var x : Float = 3.1415F // 4B IEEE-754 v5
    var y : Double = 3.1415 // 8B
    y = 2.0
    y = y.-(1.1)
    println(f"$y%16.16f")
    x = 1_000_000_000
    x = x + 50.0F
    println(f"$x%16.16f")
    var z : BigDecimal =
      BigDecimal("1000000000").+(BigDecimal("50"))
    println(z)
    y = 0.0 / 0
    println(y!=y)
    println(y.isNaN)

  }
}
