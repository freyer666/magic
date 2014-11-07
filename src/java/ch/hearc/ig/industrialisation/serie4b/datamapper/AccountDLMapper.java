/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.industrialisation.serie4b.datamapper;

import ch.hearc.ig.industrialisation.serie4b.services.*;
import ch.hearc.ig.industrialisation.serie4b.business.AccountWithDebitLimit;
import ch.hearc.ig.industrialisation.serie4b.connexion.OracleConnection;
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
public class AccountDLMapper {

    /**
     *
     * @param c
     * @param aInt
     * @return
     */
    public static Set<AccountWithDebitLimit> getAllAccountsDLByCustomer(Connection c, int aInt) {
        Set<AccountWithDebitLimit> ac = new LinkedHashSet<AccountWithDebitLimit>();

        try {
            c = DriverManager.getConnection("jdbc:oracle:thin:pt11_limido/pt11_limido@ne-ege-leto.ig.he-arc.ch:1521:ENS2");
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM COMPTE_A_DEBIT_PLAFONNE, COMPTE WHERE COMPTE_A_DEBIT_PLAFONNE.COMPTE_NUMERO = COMPTE.NUMERO AND COMPTE.CLIENT_NUMERO = " + aInt);

            while (rs.next()) {
                AccountWithDebitLimit newA = new AccountWithDebitLimit();
                newA.setNumber(rs.getInt(1));
                newA.setLabel(rs.getString(6));
                newA.setBalance(rs.getFloat(7));
                newA.setRate(rs.getFloat(8));
                newA.setDebitLimit(rs.getFloat(2));
                newA.setDebitAccumulation(rs.getFloat(3));
                ac.add(newA);
            }
            c.close();

        } catch (SQLException ex) {
            Logger.getLogger(AccountDLServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ac;
    }

    /**
     *
     * @param c
     * @param acc
     * @return
     */
    public static int insertDLAccount(Connection c,AccountWithDebitLimit acc) {

        Integer id = AccountServices.insertAccount(acc);
        try {

            
            PreparedStatement ps = c.prepareStatement("INSERT INTO COMPTE_A_DEBIT_PLAFONNE(LIMITE_DEBIT, CUMUL_DEBIT, COMPTE_NUMERO) VALUES (?,?,?)");
            ps.setFloat(1, acc.getDebitLimit());
            ps.setFloat(2, 0f);
            ps.setInt(3, id);

            ps.executeUpdate();
            c.commit();
            c.close();

        } catch (SQLException ex) {
            Logger.getLogger(AccountCLServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    /**
     *
     * @param c
     * @param acc
     * @return
     */
    public static int deleteCLAccount(Connection c,AccountWithDebitLimit acc) {
        try {
          
            Statement s = c.createStatement();

            // recherche du numéro du compte parent
            ResultSet rs = s.executeQuery("SELECT COMPTE_NUMERO FROM COMPTE_A_DEBIT_PLAFONNE WHERE NUMERO = " + acc.getNumber());
            if (rs.next()) {
                Integer parentAccountId = rs.getInt(1);
                // c'est bon, on a le num du parent on peut supprimer l'enfant
                PreparedStatement ps = c.prepareStatement("DELETE FROM COMPTE_A_DEBIT_PLAFONNE WHERE NUMERO = ?");
                ps.setInt(1, acc.getNumber());
                ps.executeUpdate();
                ps.close();
                // on oublie pas le parent
                // astuce:  on doit passer un type Account mais on utilisera que l'attribut number
                //          donc on va modifier le numéro du compte actuel pour le faire passer pour son parent
                acc.setNumber(parentAccountId);
                AccountServices.deleteAccount(acc);
            }
            rs.close();
            s.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountCLServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    /**
     *
     * @param c
     * @param acc
     * @return
     */
    public static int updateCLAccount(Connection c,AccountWithDebitLimit acc) {
        try {
            Statement s = c.createStatement();
            // recherche du numéro du compte parent
            ResultSet rs = s.executeQuery("SELECT COMPTE_NUMERO FROM COMPTE_A_DEBIT_PLAFONNE WHERE NUMERO = " + acc.getNumber());
            if (rs.next()) {
                Integer parentAccountId = rs.getInt(1); // parent trouvé
                PreparedStatement ps = c.prepareStatement("UPDATE COMPTE_A_DEBIT_PLAFONNE SET LIMITE_DEBIT = ? WHERE NUMERO = ?");
                ps.setFloat(1, acc.getDebitLimit());

                ps.setInt(2, acc.getNumber());
                ps.executeUpdate();
                ps.close();
                // on oublie pas le parent, même astuce que pour le delete, on modifie le numéro du compte
                // pour le faire passer pour le parent.
                acc.setNumber(parentAccountId);
                AccountServices.updateAccount(acc);
            }
            rs.close();
            s.close();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountCLServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 1;
    }
}
