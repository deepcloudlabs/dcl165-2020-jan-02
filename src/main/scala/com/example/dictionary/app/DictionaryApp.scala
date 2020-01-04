package com.example.dictionary.app

import scala.io.Source

object DictionaryApp {
  def main(args: Array[String]): Unit = {
    val words = Source.fromFile("c:/tmp/dictionary-tur.txt")
                      .getLines()
                      .toList
    //Find the words starting with letters A to M
    val count = words.filter(_.matches("^a.*z$")).length
    val q1 = words.takeWhile(_.matches("^[a-m].*"))
    println(q1)
    //Find the words starting with the letter N to the end of the dictionary
    val q2 = words.dropWhile(_.matches("^[a-m].*"))
    println(q2)
    //Group the dictionary words by their first three letters
    val q3 = words.filter(_.length >= 3).groupBy(_.subSequence(0,3))
    println(q3)
    //Find the palindromes in the dictionary
    val q4 = words.filter( word => word.equals(reverse(word)) )
    println(q4)
    //Count the vowels used in words
    val q5 = words.map( _.toCharArray ).flatten.filter(_.toString.matches("[eiuo]")).groupMapReduce(identity)(c => 1)(_+_)
    println(q5)
    //Find the words starting with the letter a, and ends with the letter z
    val q6 = words.filter(_.matches("^a.*z$"))
    println(q6)
    //Find the longest word in the dictionary
    val q7 = words.sortBy(_.length)(Ordering.Int.reverse).take(10)
    println(q7)
  }

  def reverse(s: String) : String =
    (for(i <- s.length until 0 by -1) yield s(i-1)).mkString

}
