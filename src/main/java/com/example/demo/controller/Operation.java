package com.example.demo.controller;


import com.example.demo.controller.dto.SavingsAccountDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class Operation {

    @GetMapping(path = "/account/SavingsAccountDTO")
    public String createAccount() {


        return "A new account has been created";
    }
}
