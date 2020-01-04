package com.example.exercises

import com.example.domain.Movie
import com.example.service.InMemoryMovieService

object Exercise1 {
  def main(args: Array[String]): Unit = {
    val movies = scala.jdk.CollectionConverters.CollectionHasAsScala(InMemoryMovieService.getInstance().findAllMovies()).asScala.toList
	  movies.foreach(println)
    val q1 = movies.toList.groupBy(_.getYear).maxBy(_._2.size)
    println(s"${q1._1}:${q1._2.size}")
    val q2 = movies.toList.map(_.getGenres)
                        .map(scala.jdk.CollectionConverters.CollectionHasAsScala(_).asScala.toList)
                        .flatten
                        //.groupMapReduce(_.getName)(_ => 1)(_+_)
                         .groupBy(_.getName)
    q2.foreach( pair => println(pair._1 +" : "+pair._2))
  }
}
