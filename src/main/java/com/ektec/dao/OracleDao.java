package com.ektec.dao;

import com.ektec.utilidades.Utilidades;
import oracle.jdbc.pool.OracleDataSource;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author SERRANO, Manuel
 * @author RIVAS, Ronel
 * @version 1, 2013-09-26
 * @since 1.0
 */
@Transactional
public class OracleDao implements IBaseDao {
    private static Logger LOGGER = Logger.getLogger(OracleDao.class.toString());
    protected Connection connection;
    protected Statement statement;
    protected PreparedStatement preparedStatement;
    protected CallableStatement callableStatement;
    protected ResultSet resultSet;
    private OracleDataSource dataSource;

    public OracleDao() throws BDException {
        this.connect();
    }

    /**
     * Obtiene una conexión a la base de datos
     *
     * @return La conexión a la base de datos
     * @throws Exception
     */
    @Override
    public void connect() throws BDException {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL(Utilidades.getPropiedadConfig("ORACLE_DB_URL"));
            dataSource.setUser(Utilidades.getPropiedadConfig("ORACLE_DB_USERNAME"));
            dataSource.setPassword(Utilidades.getPropiedadConfig("ORACLE_DB_PASSWORD"));

            connection = dataSource.getConnection();

        } catch (SQLException e) {
            LOGGER.fatal(e.getMessage(), e);
            throw new BDException(e.getMessage());
        }
    }

    @Override
    public void close() throws BDException {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new BDException(e.getMessage());
        }
    }
}
