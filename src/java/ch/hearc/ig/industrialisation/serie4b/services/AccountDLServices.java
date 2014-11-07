/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.industrialisation.serie4b.services;

import ch.hearc.ig.industrialisation.serie4b.business.AccountWithCreditLimit;
import ch.hearc.ig.industrialisation.serie4b.business.AccountWithDebitLimit;
import ch.hearc.ig.industrialisation.serie4b.connexion.OracleConnection;
import ch.hearc.ig.industrialisation.serie4b.datamapper.AccountDLMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Freyer
 */
public class AccountDLServices {

    /**
     *
     * @param aInt
     * @return
     */
    public static Set<AccountWithDebitLimit> getAllAccountsDLByCustomer(int aInt) {
    Connection c = OracleConnection.getJDBCConnection();
    return AccountDLMapper.getAllAccountsDLByCustomer(c,aInt);
    }

    /**
     *
     * @param acc
     * @return
     */
    public static int insertDLAccount(AccountWithDebitLimit acc)  {
        
        Connection c = OracleConnection.getJDBCConnection();
        return AccountDLMapper.insertDLAccount(c,acc);
    }

    /**
     *
     * @param acc
     * @return
     */
    public static int deleteCLAccount(AccountWithDebitLimit acc)  {
        Connection c = OracleConnection.getJDBCConnection();
        return AccountDLMapper.deleteCLAccount(c, acc);
    }

    /**
     *
     * @param acc
     * @return
     */
    public static int updateCLAccount(AccountWithDebitLimit acc)  {
        Connection c = OracleConnection.getJDBCConnection();
        return AccountDLMapper.updateCLAccount(c, acc);
    }
}