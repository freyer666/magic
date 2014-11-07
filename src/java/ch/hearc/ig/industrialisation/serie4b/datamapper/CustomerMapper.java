/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.industrialisation.serie4b.datamapper;

import ch.hearc.ig.industrialisation.serie4b.business.Customer;
import ch.hearc.ig.industrialisation.serie4b.services.AddressServices;
import ch.hearc.ig.industrialisation.serie4b.services.CustomerServices;
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
public class CustomerMapper {
    
    /**
     *
     * @param c
     * @return
     */
    public static Set<Customer> findAllCustommers(Connection c) {
        Set<Customer> cu = new LinkedHashSet<Customer>();
        try {
            c = DriverManager.getConnection("jdbc:oracle:thin:pt11_limido/pt11_limido@ne-ege-leto.ig.he-arc.ch:1521:ENS2");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM CLIENT");
            
            while(rs.next())
            {
                Customer newC = new Customer();
                newC.setNumber(rs.getInt(1));
                newC.setFirstName(rs.getString(2));
                newC.setLastName(rs.getString(3));
                newC.setAddress(AddressServices.getAddressByNumber(rs.getInt(5)));
                cu.add(newC);
            }
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cu;
    }

    /**
     *
     * @param c
     * @param aInt
     * @return
     */
    public static Customer getCustomerByNumber(Connection c ,int aInt)
    {
        Customer newC = new Customer();
        try {
            c = DriverManager.getConnection("jdbc:oracle:thin:pt11_limido/pt11_limido@ne-ege-leto.ig.he-arc.ch:1521:ENS2");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM CLIENT WHERE NUMERO ="+aInt);
            
            while(rs.next())
            {
                
                newC.setNumber(rs.getInt(1));
                newC.setFirstName(rs.getString(2));
                newC.setLastName(rs.getString(3));
                newC.setAddress(AddressServices.getAddressByNumber(rs.getInt(5)));
               
                
            }
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newC;
    }

    /**
     *
     * @param c
     * @param cus
     * @return
     */
    public static int insert(Connection c,Customer cus)
    {
      
        try { 
            
           
            PreparedStatement ps = c.prepareStatement("INSERT INTO CLIENT(NOM, PRENOM, ADRESSE_NUMERO, BANQUE_NUMERO) VALUES (?,?,?,?)");
            ps.setString(1, cus.getLastName());
            ps.setString(2, cus.getFirstName());
            ps.setInt(3,cus.getAddress().getId());
            ps.setInt(4, cus.getBank().getId());
            ps.executeUpdate();
            
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerServices.class.getName()).log(Level.SEVERE, null, ex);
        }
      return 1;
    }
    
    /**
     *
     * @param c
     * @param cus
     * @return 
     */
    public static int delete(Connection c,Customer cus) {
        try {
            
            PreparedStatement ps = c.prepareStatement("DELETE FROM CLIENT WHERE NUMERO = ?");
            ps.setInt(1, cus.getNumber());
            ps.executeUpdate();
            ps.close();
            c.close();
            
        } catch (SQLException ex) {
            System.err.println("CustomerDAO > " + ex);
        }
        return 1;
    }

    /**
     * Méthode permettant de modifier les valeurs d'un client.
     *
     * @param c
     * @param cus le client à modifier
     * @return 
     */
    public static int update(Connection c,Customer cus) {
        try {
            
            PreparedStatement ps = c.prepareStatement("UPDATE CLIENT SET NOM = ?, PRENOM = ?, ADRESSE_NUMERO = ?WHERE NUMERO = ?");
            ps.setString(1, cus.getLastName());
            ps.setString(2, cus.getFirstName());
            ps.setInt(3, cus.getAddress().getId());
         
            ps.setInt(4, cus.getNumber());
            ps.executeUpdate();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            System.err.println("CustomerDAO > " + ex);
        }
        return 1;
    }

    /**
     *
     * @param c
     * @param aInt
     * @return
     */
    public static Set<Customer> getCustomerByBankNumber(Connection c, int aInt) {
        Set<Customer> cu = new LinkedHashSet<Customer>();
            
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM CLIENT WHERE BANQUE_NUMERO ="+aInt);
            
            while(rs.next())
            {
                Customer newC = new Customer();
                newC.setNumber(rs.getInt(1));
                newC.setFirstName(rs.getString(2));
                newC.setLastName(rs.getString(3));
                newC.setAddress(AddressServices.getAddressByNumber(rs.getInt(5)));
               
                cu.add(newC);
            }
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cu;
}
}
