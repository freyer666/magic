/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.industrialisation.serie4b.services;

import ch.hearc.ig.industrialisation.serie4b.business.Customer;
import ch.hearc.ig.industrialisation.serie4b.connexion.OracleConnection;
import ch.hearc.ig.industrialisation.serie4b.datamapper.CustomerMapper;
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
public class CustomerServices {

    
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Set<Customer> findAllCustomer() throws SQLException, ClassNotFoundException
    {       
            Connection c = OracleConnection.getJDBCConnection();
            return CustomerMapper.findAllCustommers(c);
            
        
    }
    
    /**
     *
     * @param aInt
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Set<Customer> getAllCustomersByBankNumber(int aInt) throws ClassNotFoundException, SQLException {
        Connection c  =OracleConnection.getJDBCConnection();
        return CustomerMapper.getCustomerByBankNumber(c, aInt);
    }

    /**
     *
     * @param aInt
     * @return
     */
    public static Customer getCustomersByNumber(int aInt) 
    {
          Connection c = OracleConnection.getJDBCConnection();
            
          return CustomerMapper.getCustomerByNumber(c,aInt);  
    }

    /**
     *
     * @param cus
     * @return
     */
    public static int insert(Customer cus)
    {
      
         Connection c = OracleConnection.getJDBCConnection();
            
          return CustomerMapper.insert(c,cus); 
    }
    
    /**
     *
     * @param cus
     * @return 
     */
    public static int delete(Customer cus) {
         Connection c = OracleConnection.getJDBCConnection();
            
          return CustomerMapper.delete(c, cus);
    }

    /**
     * Méthode permettant de modifier les valeurs d'un client.
     *
     * @param cus le client à modifier
     * @return 
     */
    public static int update(Customer cus) {
        Connection c = OracleConnection.getJDBCConnection();
            
          return CustomerMapper.update(c, cus);
    }
}
