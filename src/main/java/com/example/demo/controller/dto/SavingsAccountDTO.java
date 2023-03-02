package com.example.demo.controller.dto;
import org.joda.time.DateTime;


public class SavingsAccountDTO {
    public String ownerName;
    public int ownerDocument;
    public DateTime creationDate = DateTime.now();
    public int accountFunds=0;
    public int accountNumber;


}
