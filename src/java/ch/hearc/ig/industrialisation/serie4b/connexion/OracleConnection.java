package ch.hearc.ig.industrialisation.serie4b.connexion;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Limido
 */
public class OracleConnection {

     private static OracleDataSource ods = null;

    /**
     *
     * @return
     */
    public static Connection getJDBCConnection() {
        try {
            if (ods == null) {
                ods = new OracleDataSource();
                ods.setDriverType("thin");
                ods.setServerName("ne-ege-leto.ig.he-arc.ch");
                ods.setPortNumber(1521);
                ods.setDatabaseName("ens2");
                ods.setUser("pt11_limido");
                ods.setPassword("pt11_limido");
                ods.getConnection().setAutoCommit(false);
            }
            return ods.getConnection();
        } catch (SQLException ex) {
            System.err.println("OracleConnection > " + ex);
        }
        return null;
    }
}
