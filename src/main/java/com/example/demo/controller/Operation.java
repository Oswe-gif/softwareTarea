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
        operationBD.createCount(savingsAccount);
        return "A new account has been created: ";
    }




}
