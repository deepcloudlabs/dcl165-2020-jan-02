package com.example.banking.app

import com.example.banking.domain.{Account, CheckingAccount}

object StudyForLoop2 {

  def main(args: Array[String]): Unit = {
    val accounts : Array[Account] = Array(
      new Account("TR1",10_000),
      new CheckingAccount("TR2",20_000,5_000),
      new Account("TR3",30_000),
      new CheckingAccount("TR4",40_000,7_000)
    )
    for { acc <- accounts
         balance = acc.getBalance
         if (acc.getBalance() > 20_000)
         if (acc.isInstanceOf[CheckingAccount])
    }  println(balance)
    accounts.filter(_.getBalance() > 20_000)
            .filter(_.isInstanceOf[CheckingAccount])
            .map(_.getBalance)
            .foreach(println)
  }
}
