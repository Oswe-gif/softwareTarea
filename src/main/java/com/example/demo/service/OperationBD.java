package com.example.demo.service;

import com.example.demo.controller.dto.MoneySender;
import com.example.demo.controller.dto.SavingsAccountDTO;

public interface OperationBD {
    String createCount(SavingsAccountDTO account);
    String depositMoney(int moneyAmount, int accountNumber);
    String checkBalance(int accountNumber);
    String transferMoney(MoneySender sender);
}
