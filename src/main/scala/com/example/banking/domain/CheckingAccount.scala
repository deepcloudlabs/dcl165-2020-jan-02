package com.example.banking.domain

class CheckingAccount(ciban: String, cbalance: Double, overdraftAmount: Double) extends Account(ciban, cbalance) {
  override def withdraw(amount: Double): Boolean = {
    println("CheckingAccount::withdraw")
    if (amount <= 0) return false;
    if (amount > (balance + overdraftAmount)) return false;
    this.balance -= amount
    return true
  }
}
