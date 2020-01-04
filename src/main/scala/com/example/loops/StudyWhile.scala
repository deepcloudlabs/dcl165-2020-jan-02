package com.example.loops

object StudyWhile {
  def gcdWhile(x: Long, y: Long) : Long = {
    var a = x
    var b = y
    while (a>0) {
      val c = a ;
      a = b % a
      b = c
    }
    b
  }
  def gcdDoWhile(x: Long, y: Long) : Long = {
    var a = x
    var b = y
    do {
      val c = a ;
      a = b % a
      b = c
    } while (a>0)
    b
  }
  def gcd(x: Long, y: Long) : Long =
    if (y==0) x else gcd(y,x%y)
  def factorial(n : Long) : Long =
      if(n == 0 || n==1) 1 else factorial(n-1).*(n)

  def main(args: Array[String]): Unit = {
    println(gcdWhile(17,11))
    println(gcdWhile(18,6))
    println(gcdWhile(9,6))
    println(gcdDoWhile(17,11))
    println(gcdDoWhile(18,6))
    println(gcdDoWhile(9,6))
    var i=0
    while (i<args.length){
      println(args(i))
      i = i + 1
    }
    for (k <- 0 to args.length-1)
      println(args(k))
    for (k <- 0 until args.length)
      println(args(k))
    for ( arg <- args)
      println(arg)
    args.toList.foreach(println)
  }
}
