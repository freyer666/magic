/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.industrialisation.serie4b.services;

import ch.hearc.ig.industrialisation.serie4b.business.Bank;
import ch.hearc.ig.industrialisation.serie4b.connexion.OracleConnection;
import ch.hearc.ig.industrialisation.serie4b.datamapper.BankMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Freyer
 */
public class BankServices {

    /**
     *
     * @param aInt
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Bank getBankByNumber(int aInt) throws ClassNotFoundException, SQLException
    {
    
        Connection c =OracleConnection.getJDBCConnection();
        return BankMapper.getBankByNumber(c,aInt);
    }
   
    
    
}
