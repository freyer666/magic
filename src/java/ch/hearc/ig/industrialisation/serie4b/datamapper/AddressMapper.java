/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.industrialisation.serie4b.datamapper;

import ch.hearc.ig.industrialisation.serie4b.business.Address;
import java.sql.Connection;
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
public class AddressMapper {

    /**
     *
     * @param c
     * @param aInt
     * @return
     */
    public static Address getAddressByNumber(Connection c,int aInt)  {
       Address a = null;
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM ADRESSE WHERE NUMERO=" + aInt);
            
            while (rs.next()) {
                a = new Address(rs.getString(2),Integer.toString(rs.getInt(3)), rs.getString(4));
                a.setId(rs.getInt(1));
                
            }
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }

    /**
     *
     * @param c
     * @param address
     * @return
     */
    public static int getAddressByName(Connection c,String address)
    {
        int idAddress = 0;
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT NUMERO FROM ADRESSE WHERE RUE=" + address);
            
            while (rs.next()) {
                idAddress = Integer.valueOf(rs.getString(1));
                
                
            }
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idAddress;
    }
    
    /**
     *
     * @param c
     * @return
     */
    public static Set<Address> getAllAddress(Connection c)
    {
        Set<Address> adrs = new LinkedHashSet<Address>();
        try {
            Statement s = c.createStatement();
             ResultSet rs = s.executeQuery("SELECT * FROM ADRESSE");
              while(rs.next())
            {
                Address adr = new Address();
                adr.setId(rs.getInt(1));
                adr.setStreet(rs.getString(2));
                adr.setZipCode(rs.getString(3));
                adr.setCity(rs.getString(4));
                adrs.add(adr);
            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddressMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    return adrs;
    }

}
