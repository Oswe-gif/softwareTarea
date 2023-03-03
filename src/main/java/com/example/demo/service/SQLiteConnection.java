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
    public void createCount(SavingsAccountDTO account) {

            String sql = "INSERT INTO users (Name,Document,CreationDate,AccountAmount,AccountNumber) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, account.ownerName);
            pstmt.setInt(2, account.ownerDocument);
            pstmt.setString(3, account.creationDate);
            pstmt.setInt(4, account.accountFunds);
            pstmt.setInt(5, account.accountNumber);

            pstmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void depositMoney(int moneyAmount, int accountNumber) {

    }

    @Override
    public void checkBalance(int accountNumber) {

    }

    @Override
    public void transferMoney(MoneySender sender) {

    }
}
