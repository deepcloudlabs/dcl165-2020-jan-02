package com.example.animal.domain

trait Pet {
  def getName() : String
  def setName(name: String) : Unit
  def play() : Unit
}
