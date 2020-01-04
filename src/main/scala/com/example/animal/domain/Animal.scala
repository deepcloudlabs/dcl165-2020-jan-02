package com.example.animal.domain

abstract class Animal(protected val legs : Int) {
  def getLegs() = legs
  def walk() = println(s"Animal with $legs legs is walking now")
  def eat() : Unit
}
