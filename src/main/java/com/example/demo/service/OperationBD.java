package com.example.demo.service;

import com.example.demo.controller.dto.MoneySender;
import com.example.demo.controller.dto.SavingsAccountDTO;

public interface OperationBD {
    void createCount(SavingsAccountDTO account);
    void depositMoney(int moneyAmount, int accountNumber);
    void checkBalance(int accountNumber);
    void transferMoney(MoneySender sender);
}
