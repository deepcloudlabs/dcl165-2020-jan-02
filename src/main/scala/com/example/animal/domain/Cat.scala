package com.example.animal.domain

class Cat(var name : String ) extends Animal(4) with Pet{
  def this() = this("Yoda")
  override def eat(): Unit = println(s"$name is eating now...")

  override def getName(): String = name

  override def setName(name: String): Unit = this.name = name

  override def play(): Unit = println(s"$name is playing now...")

  override def toString = s"Cat($name, $legs)"
}
