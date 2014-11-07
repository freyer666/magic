/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.industrialisation.serie4b.datamapper;

import ch.hearc.ig.industrialisation.serie4b.services.*;
import ch.hearc.ig.industrialisation.serie4b.business.Bank;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Freyer
 */
public class BankMapper {

    /**
     *
     * @param c
     * @param aInt
     * @return
     */
    public static Bank getBankByNumber(Connection c,int aInt) {
    
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM BANQUE WHERE NUMERO ="+ aInt);
            
            while(rs.next())
            {
                Bank b = new Bank();
                b.setName(rs.getString(2));
                b.setAdress(AddressServices.getAddressByNumber(rs.getInt(3)));
                b.setCustomers(CustomerServices.getAllCustomersByBankNumber(rs.getInt(1)));
                return b;
            }
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(BankMapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BankMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    
    
}
