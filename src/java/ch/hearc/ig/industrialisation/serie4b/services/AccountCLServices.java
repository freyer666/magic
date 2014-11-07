/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.industrialisation.serie4b.services;

import ch.hearc.ig.industrialisation.serie4b.business.AccountWithCreditLimit;
import ch.hearc.ig.industrialisation.serie4b.connexion.OracleConnection;
import ch.hearc.ig.industrialisation.serie4b.datamapper.AccountCLMapper;
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
public class AccountCLServices {

    /**
     *
     * @param aInt
     * @return
     */
    public static Set<AccountWithCreditLimit> getAllAccountsCLByCustomer(int aInt) {
        Connection c = OracleConnection.getJDBCConnection();
        return AccountCLMapper.getAllAccountsCLByCustomer(c,aInt);
    }

    /**
     *
     * @param acc
     * @return
     */
    public static int insertCLAccount(AccountWithCreditLimit acc)  {
        
        Connection c = OracleConnection.getJDBCConnection();
        return AccountCLMapper.insertCLAccount(c,acc);
    }

    /**
     *
     * @param acc
     * @return
     */
    public static int deleteCLAccount(AccountWithCreditLimit acc)  {
        Connection c = OracleConnection.getJDBCConnection();
        return AccountCLMapper.deleteCLAccount(c,acc);
    }

    /**
     *
     * @param acc
     * @return
     */
    public static int updateCLAccount(AccountWithCreditLimit acc)  {
        Connection c = OracleConnection.getJDBCConnection();
        return AccountCLMapper.updateCLAccount(c,acc);
    }
}