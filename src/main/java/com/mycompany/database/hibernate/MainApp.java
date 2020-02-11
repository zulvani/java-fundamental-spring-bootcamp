package com.mycompany.database.hibernate;

import com.mycompany.database.hibernate.model.AccountTransaction;
import com.mycompany.database.hibernate.model.BankAccount;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class MainApp {

    EntityManager em = null;

    public MainApp() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("my-persistence-unit");
        em = emf.createEntityManager();

//        addSaldo("111222333", new BigDecimal("50000"));
//        findById(1);
//        showAllBankAccounts();

//        registerBankAccount("Jamila", "111222333");

//        unregisterBankAccount("111222333");
//        showAllAccountNumberAndOwnerNameBankAccounts();
        getAllBankAccounts();
        em.close();
    }

    private void findById(long id){
        BankAccount b = em.find(BankAccount.class, id);
        if(b != null){
            System.out.printf("%d - %s - %s - %f", b.getId(), b.getAccountNumber(), b.getOwnerName(), b.getSaldo());
        }
    }

    private List<BankAccount> getAllBankAccounts(){
        List<BankAccount> bankAccounts = em.createQuery("from BankAccount", BankAccount.class).getResultList();
        for(BankAccount b : bankAccounts){
            System.out.printf("%d - %s - %s - %f", b.getId(), b.getAccountNumber(), b.getOwnerName(), b.getSaldo());
        }
        return bankAccounts;
    }

    private void showAllAccountNumberAndOwnerNameBankAccounts(){
        Query q = em.createQuery("select accountNumber, ownerName from BankAccount order by id desc");
        List<Object[]> bankAccounts = q.getResultList();
        int no = 1;
        for(Object[] b : bankAccounts){
            System.out.printf("%d - %s - %s \n", no, b[0], b[1]);
            no++;
        }
    }

    private int unregisterBankAccount(String accountNumber){
        em.getTransaction().begin();
        Query q = em.createQuery("delete from BankAccount where accountNumber = :accountNumber")
                .setParameter("accountNumber", accountNumber);
        int r = q.executeUpdate();
        em.getTransaction().commit();
        return r;
    }

    private void showAllBankAccounts(){
        Query q = em.createQuery("from BankAccount order by id desc", BankAccount.class);
        List<BankAccount> bankAccounts = q.getResultList();
        int no = 1;
        for(BankAccount b : bankAccounts){
            System.out.printf("%d - %s - %s - %f \n", no, b.getAccountNumber(), b.getOwnerName(), b.getSaldo());
            no++;
        }
    }

    private void registerBankAccount(String ownerName, String accountNumber){
        em.getTransaction().begin();
        BankAccount b = new BankAccount();
        b.setAccountNumber(accountNumber);
        b.setOwnerName(ownerName);
        b.setSaldo(BigDecimal.ZERO);
        em.persist(b);
        em.getTransaction().commit();
    }

    private void addSaldo(String accountNumber, BigDecimal amount){
        Query q = em.createQuery("from BankAccount where accountNumber = :accountNumber", BankAccount.class)
                .setParameter("accountNumber", accountNumber);
        List<BankAccount> bankAccounts = q.getResultList();

        if(bankAccounts.size() > 0){
            em.getTransaction().begin();
            BankAccount b = bankAccounts.get(0);
            b.setSaldo(b.getSaldo().add(amount));
            em.persist(b);

            AccountTransaction t = new AccountTransaction();
            t.setAmount(amount);
            t.setBankAccount(b);
            t.setTransactionDate(new Date());
            t.setTransactionName("KREDIT");
            em.persist(t);
            em.getTransaction().commit();
        } else {
            // account number was not found
        }
    }

    public static void main(String[] args){
        new MainApp();
    }
}
