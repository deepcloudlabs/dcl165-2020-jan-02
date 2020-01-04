package com.example.banking.domain

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class Customer(identityNo : String,fullname : String) {
    val accounts : mutable.HashMap[String,Account] = mutable.HashMap()
    def getFullname() = fullname
    def getIdentityNo() = identityNo
    def addAccount(acc : Account) : Unit = accounts.update(acc.getIban(),acc)
    def getNumberOfAccounts() : Int = accounts.size
    def getAccount(index : Int) : Account = accounts.drop(index-1).head._2
    def getAccount(iban : String) : Option[Account] = accounts.get(iban)
    def getTotalBalance() : Double = accounts.map(_._2.getBalance).sum
    def getMaxAccount() : Account = accounts.maxBy(_._2.getBalance)._2
    def removeAccount(acc : Account) : Unit = accounts.remove(acc.getIban())
    def removeAccount(iban : String) : Boolean = getAccount(iban) match {
      case None => false
      case Some(acc) => {
        accounts.remove(acc.getIban())
        true
      }
    }
  def getAccountTypeCounts() =
    accounts.map(_._2).groupMapReduce(_.getClass.getSimpleName)(account => 1)(_+_)

  override def toString = s"Customer($getFullname, $getTotalBalance)"
}
