package com.ektec.db;

import com.ektec.utilidades.Utilidades;
import oracle.jdbc.pool.OracleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: mserrano
 * Date: 26/09/13
 * Time: 9:00
 * To change this template use File | Settings | File Templates.
 */
public class oraclecomundao {
    private static Logger LOGGER = Logger.getLogger(oraclecomundao.class.toString());

    /** La fuente de datos que apunta al repositorio de base de datos */
    private OracleDataSource dataSource;

    /** El constructor de la clase
     */
    public oraclecomundao() {
    }

    /** Obtiene la fuente de datos
     * @return La fuente de datos que apunta al repositorio de base de datos
     */
    public DataSource getDataSource () {
        return dataSource;
    }

    /** Asigna la fuente de datos
     * @param dataSource La fuente de datos que apunta al repositorio de base de datos
     */
    public void setDataSource (OracleDataSource dataSource) {
        this.dataSource = dataSource;
    }

    /** Obtiene una conexi�n a la base de datos
     * @return La conexi�n a la base de datos
     * @throws SQLException
     */
    protected Connection getConnection () throws Exception {
        Connection connection = null;

        try {
            dataSource = new OracleDataSource();
            dataSource.setURL(Utilidades.getPropiedadConfig("ORACLE_DB_URL"));
            dataSource.setUser(Utilidades.getPropiedadConfig("ORACLE_DB_USERNAME"));
            dataSource.setPassword(Utilidades.getPropiedadConfig("ORACLE_DB_PASSWORD"));
            connection = dataSource.getConnection ();
        }
        catch (SQLException e) {
            LOGGER.severe(e.getMessage());
        }

        return connection;
    }

    /** Metodo que cierra los objetos de base de datos
     * @param connection La conexion de base de datos
     * @param statement El objeto statement
     * @param resultado
     */
    protected void closeJdbcObjects(Connection connection, Statement statement, int resultado) throws Exception {
        closeJdbcObjects (connection, statement, null);
    }

    /** Metodo que cierra los objetos de base de datos
     * @param connection La conexion de base de datos
     * @param statement El objeto statement
     * @param result El objeto result
     */
    protected void closeJdbcObjects (Connection connection, Statement statement, ResultSet result) throws Exception {
        try {
            if (result != null) result.close ();
        } catch (SQLException e) {

        }

        try {
            if (statement != null) statement.close ();
        } catch (SQLException e) {

        }

        try {
            if (connection != null) connection.close ();
        } catch (SQLException e) {

        }
    }
}
