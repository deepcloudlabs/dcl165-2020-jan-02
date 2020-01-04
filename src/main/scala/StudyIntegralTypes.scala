object StudyIntegralTypes {
  def main(args: Array[String]): Unit = {
    var x: Byte = Byte.MaxValue // 1B, -128..127
    x = (x + 1).asInstanceOf[Byte]
    println(x)
    x = -128
    x = (x - 1).asInstanceOf[Byte]
    println(x)
    x = 0x2A
    println(x)
    var y: Short = 108 // 2B
    var z: Int = 549 // 4B
    var t: Long = 3615L // 8B
    var s : BigInt = BigInt(Long.MaxValue) * 200L
    println(s)
    //z = 0 / 0
    //println(z)
  }
}
