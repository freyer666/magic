/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.industrialisation.serie4b.services;

import ch.hearc.ig.industrialisation.serie4b.business.Address;
import ch.hearc.ig.industrialisation.serie4b.business.Bank;
import ch.hearc.ig.industrialisation.serie4b.connexion.OracleConnection;
import ch.hearc.ig.industrialisation.serie4b.datamapper.AddressMapper;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class AddressServices {

    /**
     *
     * @param aInt
     * @return
     */
    public static Address getAddressByNumber(int aInt)  {
       Connection c = OracleConnection.getJDBCConnection();
       return AddressMapper.getAddressByNumber(c,aInt);
    }

    /**
     *
     * @param address
     * @return
     */
    public static int getAddressByName(String address)
    {
        Connection c = OracleConnection.getJDBCConnection();
        return AddressMapper.getAddressByName(c,address);
    }
    
    /**
     *
     * @return
     */
    public static Set<Address> getAllAddress()
    {
        Connection c = OracleConnection.getJDBCConnection();
        return AddressMapper.getAllAddress(c);
    }

}
