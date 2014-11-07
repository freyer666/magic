/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.industrialisation.serie4b.datamapper;

import ch.hearc.ig.industrialisation.serie4b.business.Account;
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
public class AccountMapper {

    /**
     *
     * @param c
     * @param aInt
     * @return
     */
    public static Set<Account> getAllAccountsByCustomer(Connection c , int aInt) {
        Set<Account> ac = new LinkedHashSet<Account>();
        try {
            
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM COMPTE WHERE CLIENT_NUMERO = " + aInt + " AND NUMERO NOT IN (SELECT COMPTE_NUMERO FROM COMPTE_A_CREDIT_PLAFONNE) AND NUMERO NOT IN (SELECT COMPTE_NUMERO FROM COMPTE_A_DEBIT_PLAFONNE)");
            
            while (rs.next()) {
                Account newA = new Account();
                newA.setNumber(rs.getInt(1));
                newA.setLabel(rs.getString(2));
                newA.setBalance(rs.getFloat(3));
                newA.setRate(rs.getFloat(4));
                ac.add(newA);
            }
           
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ac;
    }

    /**
     *
     * @param c
     * @param acc
     * @return
     */
    public static Integer insertAccount(Connection c,Account acc) {
        
            Integer generatedId = null;
        try {
            
            String generatedColumns[] = {"NUMERO"}; // va nous permettre de récupérer la valeur de la colonne NUMERO générée dans la bd
            PreparedStatement ps = c.prepareStatement("INSERT INTO COMPTE(LIBELLE, SOLDE, TAUX, CLIENT_NUMERO) VALUES (?, ?, ?, ?)", generatedColumns);
            ps.setString(1, acc.getLabel());
            ps.setFloat(2, acc.getBalance());
            ps.setFloat(3, acc.getRate());
            ps.setInt(4, acc.getIdCustomer());
            ps.executeUpdate();
            // récupération de l'id généré par oracle
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedId = (int) rs.getLong(1);
            }
            rs.close();
            ps.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generatedId;
    }

    /**
     *
     * @param c
     * @param acc
     * @return 
     */
    public static int deleteAccount(Connection c ,Account acc) {
        
            
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM COMPTE WHERE NUMERO = ?");
            ps.setInt(1, acc.getNumber());
            ps.executeUpdate();
            ps.close();
            c.commit();
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(AccountMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    /**
     *
     * @param c
     * @param acc
     * @return
     */
    public static int updateAccount(Connection c,Account acc) {
        try {
            
            PreparedStatement ps = c.prepareStatement("UPDATE COMPTE SET LIBELLE = ?, SOLDE = ?, TAUX = ? WHERE NUMERO = ?");
            ps.setString(1, acc.getLabel());
            ps.setFloat(2, acc.getBalance());
            ps.setFloat(3, acc.getRate());
            ps.setInt(4, acc.getNumber());
            ps.executeUpdate();
            ps.close();
            c.commit();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountMapper.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println();
        }

        return 1;
    }

}
