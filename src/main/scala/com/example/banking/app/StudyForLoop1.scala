package com.example.banking.app

import com.example.banking.domain.{Account, Bank, CheckingAccount}

object StudyForLoop1 {
  def main(args: Array[String]): Unit = {
    val garantiBbva : Bank = new Bank(1,"Garanti Bank A.S.")
    val jack = garantiBbva.createCustomer("1","Jack Bauer")
    val kate = garantiBbva.createCustomer("2","Kate Austen")
    garantiBbva.addAccountToCustomer(
      new Account("TR1",10_000),jack)
    garantiBbva.addAccountToCustomer(
      new CheckingAccount("TR2",20_000,5_000),jack)
    garantiBbva.addAccountToCustomer(
      new Account("TR3",30_000),kate)
    garantiBbva.addAccountToCustomer(
      new CheckingAccount("TR4",40_000,7_000),kate)
    for {
      custPair <- garantiBbva.customers.toList
      cust = custPair._2
      accPair <- (cust.accounts.toList)
      acc = accPair._2
    } println( f"${cust.getFullname()}%-12s ${acc.getClass().getSimpleName}%-14s ${acc.getBalance()}%-8.0f")
    val richCustomers = for {
      custPair <- garantiBbva.customers.toList
      cust = custPair._2
      if (cust.getTotalBalance() > 50_000)
    } yield cust
    println(richCustomers)
    val anotherRichCustomers = garantiBbva.customers.map(_._2)
                                   .filter(_.getTotalBalance()>50_000)
    println(anotherRichCustomers)
  }
}
