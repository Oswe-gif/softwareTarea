package com.example.demo.service;

import com.example.demo.controller.dto.MoneySender;
import com.example.demo.controller.dto.SavingsAccountDTO;

import java.sql.*;

public class SQLiteConnection implements OperationBD{

    static Connection conn = null;
    static String url = "jdbc:sqlite:ourdatabase";
    public static void connect() {


        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }



    @Override
    public String createCount(SavingsAccountDTO account) {

        String sql = "INSERT INTO users (Name,Document,CreationDate,AccountAmount,AccountNumber) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account.ownerName);
            pstmt.setInt(2, account.ownerDocument);
            pstmt.setString(3, account.creationDate);
            pstmt.setInt(4, account.accountFunds);
            pstmt.setInt(5, account.accountNumber);
            pstmt.executeUpdate();
            return "An account has been created: User:"+account.accountNumber+" "+ account.ownerDocument+ " "+account.creationDate+" "+account.accountFunds+" "+account.accountNumber;


        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return "check fields or data type";
        }

    }

    @Override
    public String depositMoney(int moneyAmount, int accountNumber) {
        
        String sql = "UPDATE users SET AccountAmount = AccountAmount + moneyAmount ? WHERE AccountNumber = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, moneyAmount);
            pstmt.setInt(2, accountNumber);
            pstmt.executeUpdate();
            return "An account has been recharged ";


        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return "check fields or data type";
        }

    }

    @Override
    public String checkBalance(int accountNumber) {
        String sql = "SELECT Name, AccountAmount FROM Users where AccountNumber=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountNumber);
            ResultSet rs  = pstmt.executeQuery();
            return "Name: "+rs.getString("Name") +" Money: $" +rs.getInt("AccountAmount");

        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return "check fields or the account does not exist";
        }
    }

    @Override
    public String transferMoney(MoneySender sender) {
        return "";
    }
}
