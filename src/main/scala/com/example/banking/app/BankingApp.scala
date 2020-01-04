package com.example.banking.app

import com.example.banking.domain.{Account, CheckingAccount}

object BankingApp {
  def main(args: Array[String]): Unit = {
    val acc1: Account = new CheckingAccount("TR1", 1000, 500)
    val acc2: Account =
      new Account("TR2", 10000)
    println(acc1.getBalance())
    acc1.withdraw(1500)
    acc2.withdraw(1500)
    println(acc1.getBalance())
    val accounts : List[Account] = List(acc1,acc2)
    val totalBalance =
      accounts.filter(_.isInstanceOf[CheckingAccount])
           .map(_.getBalance )
           .reduce( _+_)
    println(totalBalance)
    accounts.foreach(acc => acc.withdraw(50))
  }
}
