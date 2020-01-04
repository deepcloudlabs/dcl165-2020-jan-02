package com.example.banking.domain

class Account(val iban :String,protected var balance : Double = 0.0)  {
  def withdraw(amount :Double) : Boolean = {
    println("Account::withdraw")
    // validation
    if (amount <= 0) return false
    // business rule
    if (amount > this.balance) return false
    this.balance = this.balance - amount
    return true
  }
  def deposit(amount :Double) : Boolean = {
    if (amount <= 0) return false
    this.balance += amount
    return true
  }
  def getBalance() = balance
  def getIban() = iban

  override def toString = s"Account(iban:$iban, balance:$balance)"
}
