package com.mycompany.database.jdbc;

import java.sql.*;

public class JDBCNative {

    Connection c = null;

    public JDBCNative() {
        try {
            c = createConnection();
            selectBankAccount();

            transfer("123456", "123123", 10000);

            System.out.println("After Transfer ----------");
            selectBankAccount();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                // exception when close jdbc connection
            }
        }
    }

    private String createTransferSQL(String accountNumber, double amount, boolean from){
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
        try {
            String s = null;
            s.length();
        } catch (NullPointerException npe){
            c.rollback();
        }
        stat.executeUpdate(toStr);
        c.commit();
        return true;
    }

    private void selectBankAccount() throws SQLException {
        Statement stat = c.createStatement();
        ResultSet resultSet = stat.executeQuery("SELECT id, account_number, owner_name, saldo FROM public.bank_account");
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String accountNumber = resultSet.getString("account_number");
            String ownerName = resultSet.getString("owner_name");
            double saldo = resultSet.getDouble("saldo");
            System.out.printf("%d - %s - %s - %f \n", id, accountNumber, ownerName, saldo);
        }
    }

    private int insertBankAccount(String ownerName, String accountNumber) throws SQLException {
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
        StringBuffer sb = new StringBuffer("jdbc:postgresql://localhost:")
                .append(port)
                .append("/")
                .append(dbName);
        return DriverManager.getConnection(sb.toString(), username, password);

//        try () {
//
//            System.out.println("Java JDBC PostgreSQL Example");
//            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within
//            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
////          Class.forName("org.postgresql.Driver");
//
////            System.out.println("Connected to PostgreSQL database!");
//            Statement statement = connection.createStatement();
////            System.out.println("Reading car records...");
////            System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.bank_account");
//            while (resultSet.next()) {
//                System.out.printf("%s", resultSet.getString(2));
//            }
//
//        } catch (SQLException e) {
////            System.out.println("Connection failure.");
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args){
        new JDBCNative();
    }
}
