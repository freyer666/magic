/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.industrialisation.serie4b.services;

import ch.hearc.ig.industrialisation.serie4b.business.Account;
import ch.hearc.ig.industrialisation.serie4b.business.AccountWithCreditLimit;
import ch.hearc.ig.industrialisation.serie4b.business.AccountWithDebitLimit;
import ch.hearc.ig.industrialisation.serie4b.connexion.OracleConnection;
import ch.hearc.ig.industrialisation.serie4b.datamapper.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Freyer
 */
public class AccountServices {

    /**
     *
     * @param aInt
     * @return
     */
    public static Set<Account> getAllAccountsByCustomer(int aInt) {
        Connection c = OracleConnection.getJDBCConnection();
        return AccountMapper.getAllAccountsByCustomer(c, aInt);

    }

    /**
     *
     * @param acc
     * @return
     */
    public static Integer insertAccount(Account acc) {
        Connection c = OracleConnection.getJDBCConnection();
        return AccountMapper.insertAccount(c, acc);

    }

    /**
     *
     * @param acc
     */
    public static void deleteAccount(Account acc) {
        Connection c = OracleConnection.getJDBCConnection();
        AccountMapper.deleteAccount(c, acc);

    }

    /**
     *
     * @param acc
     * @return
     */
    public static int updateAccount(Account acc) {

        Connection c = OracleConnection.getJDBCConnection();

        return AccountMapper.updateAccount(c, acc);
    }

    public static Set<AccountWithDebitLimit> getAllAccountsDLByCustomer(int aInt) {
        Connection c = OracleConnection.getJDBCConnection();
        return AccountDLMapper.getAllAccountsDLByCustomer(c, aInt);
    }

    /**
     *
     * @param acc
     * @return
     */
    public static int insertDLAccount(AccountWithDebitLimit acc) {

        Connection c = OracleConnection.getJDBCConnection();
        return AccountDLMapper.insertDLAccount(c, acc);
    }

    /**
     *
     * @param acc
     * @return
     */
    public static int deleteCLAccount(AccountWithDebitLimit acc) {
        Connection c = OracleConnection.getJDBCConnection();
        return AccountDLMapper.deleteCLAccount(c, acc);
    }

    /**
     *
     * @param acc
     * @return
     */
    public static int updateCLAccount(AccountWithDebitLimit acc) {
        Connection c = OracleConnection.getJDBCConnection();
        return AccountDLMapper.updateCLAccount(c, acc);
    }

    public static Set<AccountWithCreditLimit> getAllAccountsCLByCustomer(int aInt) {
        Connection c = OracleConnection.getJDBCConnection();
        return AccountCLMapper.getAllAccountsCLByCustomer(c, aInt);
    }

    /**
     *
     * @param acc
     * @return
     */
    public static int insertCLAccount(AccountWithCreditLimit acc) {

        Connection c = OracleConnection.getJDBCConnection();
        return AccountCLMapper.insertCLAccount(c, acc);
    }

    /**
     *
     * @param acc
     * @return
     */
    public static int deleteCLAccount(AccountWithCreditLimit acc) {
        Connection c = OracleConnection.getJDBCConnection();
        return AccountCLMapper.deleteCLAccount(c, acc);
    }

    /**
     *
     * @param acc
     * @return
     */
    public static int updateCLAccount(AccountWithCreditLimit acc) {
        Connection c = OracleConnection.getJDBCConnection();
        return AccountCLMapper.updateCLAccount(c, acc);
    }
}
