package com.example.banking.domain

import scala.collection.mutable

class Bank(id: Int, name: String) extends TransferService {
  def getTotalBalance(): Double = accounts.map(_._2.getBalance).sum

  val customers: mutable.HashMap[String, Customer] = mutable.HashMap()
  val accounts: mutable.HashMap[String, Account] = mutable.HashMap()

  def createCustomer(identityNo: String, fullname: String): Customer = {
    val customer = new Customer(identityNo, fullname)
    customers.update(identityNo, customer)
    customer
  }
  def removeCustomer(identityNo : String) ={
    val customer = customers.remove(identityNo)
    if (customer.isDefined){
      customer.get.accounts.map(_._2).foreach( acc => accounts.remove(acc.getIban()))
    }
    customer
  }
  def addAccountToCustomer(account: Account, customer: Customer) = {
    accounts.update(account.getIban(), account)
    customer.addAccount(account)
  }

  override def transfer(fromIban: String, toIban: String, amount: Double): Boolean = {
    val from = accounts.get(fromIban)
    val to = accounts.get(toIban)
    if (from.isDefined && to.isDefined) {
      if (from.get.withdraw(amount))
        return to.get.deposit(amount)
    }
    false
  }
}
