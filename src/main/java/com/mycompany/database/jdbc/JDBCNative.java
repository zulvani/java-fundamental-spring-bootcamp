package com.mycompany.database.jdbc;

import com.mycompany.database.exceptions.InvalidAccountNumberException;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class JDBCNative {

    Connection c = null;

    public JDBCNative() {
        try {
            c = createConnection();

            insertBankAccount("Agus", null);

//            selectBankAccount();
//            transfer("123123", "123456", 10000);
//            System.out.println("After transfer process -----------");
//            selectBankAccount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String createTransferSQL(String accountNumber, double amount, boolean from) {
        StringBuffer sb = new StringBuffer("UPDATE public.bank_account SET ")
                .append("saldo = saldo ").append(from ? "-" : "+").append(amount)
                .append("where account_number = '").append(accountNumber).append("'");
        return sb.toString();
    }

    private boolean transfer(String from, String to, double amount) throws SQLException {
        c.setAutoCommit(false);
        Statement stat = c.createStatement();
        String fromStr = createTransferSQL(from, amount, true);
        String toStr = createTransferSQL(to, amount, false);
        stat.executeUpdate(fromStr);

//        boolean execute = true;
//        try {
////            String n = null;
////            n.length(); // null pointer execption
//            File f = new File("/etcss/test.jbp");
//            f.createNewFile();
//            execute = true;
//        } catch (NullPointerException e){
////            e.printStackTrace();
////            c.rollback();
////            execute = false;
//        } catch (IOException ioe){
//            // statement create new file failed
//            ioe.printStackTrace();
//        } finally {
//            System.out.println("finally");
//        }
//
//        if(execute) {
//            stat.executeUpdate(toStr);
//            c.commit();
//        }
        return true;
    }

    private void selectBankAccount() throws SQLException {
        Statement stat = c.createStatement();
        ResultSet resultSet = stat.executeQuery("SELECT id, account_number, owner_name, saldo FROM public.bank_account");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String accountNumber = resultSet.getString("account_number");
            String ownerName = resultSet.getString("owner_name");
            double saldo = resultSet.getDouble("saldo");
            System.out.printf("%d - %s - %s - %f \n", id, accountNumber, ownerName, saldo);
        }
    }

    private int insertBankAccount(String ownerName, String accountNumber)
            throws SQLException, InvalidAccountNumberException {

        if(accountNumber == null || (accountNumber != null && accountNumber.length() == 0)){
            throw new InvalidAccountNumberException("Please input account number");
        }

        Statement stat = c.createStatement();
        StringBuffer sb = new StringBuffer("INSERT INTO public.bank_account (account_number, owner_name) VALUES ")
                .append("(")
                .append("'").append(accountNumber).append("'")
                .append(",")
                .append("'").append(ownerName).append("'")
                .append(")");
        return stat.executeUpdate(sb.toString());
    }

    private int updateBankAccount(String ownerName, String accountNumber) throws SQLException {
        Statement stat = c.createStatement();
        StringBuffer sb = new StringBuffer("UPDATE public.bank_account SET ")
                .append("owner_name = '").append(ownerName).append("'")
                .append("where account_number = '").append(accountNumber).append("'");
        return stat.executeUpdate(sb.toString());
    }

    private int deleteInvalidAccountNumber() throws SQLException {
        Statement stat = c.createStatement();
        StringBuffer sb = new StringBuffer("DELETE FROM public.bank_account WHERE account_number = 'null' ");
        return stat.executeUpdate(sb.toString());
    }

    private Connection createConnection() throws SQLException {
        String dbName = "bootcamp";
        String username = "ummah";
        String password = "ummah123";
        int port = 5432;

        //jdbc:postgresql://<host>:<port>/<dbName>
        //jdbc:mysql://<host>:<port>/<dbName>
        StringBuffer sb = new StringBuffer("jdbc:postgresql://localhost:")
                .append(port)
                .append("/")
                .append(dbName);
        return DriverManager.getConnection(sb.toString(), username, password);
    }

    public static void main(String[] args) {
        new JDBCNative();
    }
}
