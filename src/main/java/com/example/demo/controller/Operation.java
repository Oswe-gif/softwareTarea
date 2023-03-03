package com.example.demo.controller;


import com.example.demo.controller.dto.SavingsAccountDTO;
import com.example.demo.service.OperationBD;
import com.example.demo.service.SQLiteConnection;
import org.springframework.web.bind.annotation.*;

@RestController
public class Operation {
    OperationBD operationBD = new SQLiteConnection();

    @PostMapping(path = "/account/SavingsAccount")
    public String createAccount(@RequestBody SavingsAccountDTO savingsAccount) {
        return operationBD.createCount(savingsAccount);

    }
    @PutMapping (path = "/account/depositMoney/{moneyAmount}/{accountNumber}")
    public String depositMoney(@RequestBody int moneyAmount, @RequestBody int accountNumber) {
        return operationBD.depositMoney(moneyAmount,accountNumber);

    }




}
