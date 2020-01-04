package com.example.exercises

import com.example.dao.InMemoryWorldDao
import com.example.domain.Country
import scala.jdk.CollectionConverters

object Exercise2 {
  def main(args: Array[String]): Unit = {
    val worldDao = InMemoryWorldDao.getInstance()
    val countries: Iterable[Country] = scala.jdk.CollectionConverters.CollectionHasAsScala(worldDao.findAllCountries()).asScala
    val q1 = countries.map(_.getCities)
                      .map(scala.jdk.CollectionConverters.CollectionHasAsScala(_).asScala.toList)
                      .flatten
                      .toList
                      .sortBy(_.getPopulation)(Ordering.Int.reverse)
                      .take(10)
    q1.foreach(println)
/*
    val q2 = countries.groupMapReduce(_.getContinent)(country => scala.jdk.CollectionConverters.CollectionHasAsScala(country.getCities()).asScala)
    println(q2)
*/

  }
}
