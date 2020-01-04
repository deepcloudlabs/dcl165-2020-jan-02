package com.example.animal.app

import com.example.animal.domain.{Animal, Cat, Fish, Pet, Spider}

object AnimalApp {
  def main(args: Array[String]): Unit = {
    val animals : List[Animal] = List(
      new Spider,
      new Cat ,
      new Spider,
      new Fish("Free Willy"),
      new Cat("Garfield"),
      new Spider,
      new Fish("Jaws")
    )
    animals.foreach( animal => {
      animal.walk()
      animal.eat()
      if(animal.isInstanceOf[Pet])
        animal.asInstanceOf[Pet].play()
    })
    animals.filter(_.isInstanceOf[Pet])
                      .sortWith( (a,b) => a.getLegs()>b.getLegs())
                      .map(_.asInstanceOf[Pet].getName)
                      //.map(_.getName)
                      .foreach( println )
    val part1 = animals.filter(_.getLegs() > 0)
                       .partition(_.isInstanceOf[Pet])
    println(part1._1)
    println(part1._2)
  }
}
