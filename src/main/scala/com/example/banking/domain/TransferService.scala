package com.example.banking.domain

trait TransferService {
    def transfer(fromIban : String, toIban: String, amount : Double) : Boolean
}
