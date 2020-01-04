package com.example.banking.app

import com.example.banking.domain.{Account, CheckingAccount, Customer}

object CustomerApp {
  def main(args: Array[String]): Unit = {
    val jack = new Customer("1", "Jack Bauer")
    jack.addAccount(new Account("TR1", 10_000))
    jack.addAccount(new CheckingAccount("TR2", 20_000, 1500))
    jack.addAccount(new Account("TR3", 30_000))
    jack.addAccount(new CheckingAccount("TR4", 40_000, 1500))
    println(jack.getNumberOfAccounts())
    println(jack.getTotalBalance())
    for (i <- 0 to 3) println(jack.getAccount(i))
    println(jack.getAccount("TR3").getOrElse("Not found!"))
    println(jack.getAccount("TR5").getOrElse("Not found!"))
    println(jack.removeAccount("TR3"))
    for (i <- 0 to 2) println(jack.getAccount(i))
    println(jack.getAccountTypeCounts())
  }
}
