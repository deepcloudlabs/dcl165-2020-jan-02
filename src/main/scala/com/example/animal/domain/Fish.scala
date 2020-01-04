package com.example.animal.domain

class Fish(var name : String) extends Animal(0) with Pet {
  override def eat(): Unit = println(s"$name is eating now...")

  override def getName(): String = name

  override def setName(name: String): Unit = this.name = name

  override def play(): Unit = println(s"$name is playing now...")

  override def walk(): Unit = println(s"$name is swimming now...")

  override def toString = s"Fish($name, $legs)"
}
