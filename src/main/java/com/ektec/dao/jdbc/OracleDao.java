package com.ektec.dao.jdbc;

import com.ektec.dao.IBaseDao;
import com.ektec.exception.BDException;
import com.ektec.utilidades.Utilidades;
import oracle.jdbc.pool.OracleDataSource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author SERRANO, Manuel
 * @author RIVAS, Ronel
 * @version 1, 2013-09-26
 * @since 1.0
 */
@Repository("oracleDao")
public class OracleDao implements IBaseDao {
    private static Logger LOGGER = Logger.getLogger(OracleDao.class.toString());

    protected Connection connection;
    protected CallableStatement callableStatement;
    protected ResultSet resultSet;

    public OracleDao() {
        super();
    }

    /**
     * Obtiene una conexión a la base de datos
     *
     * @throws BDException en caso de error abriendo la conexión
     */
    @Override
    public void connect() throws BDException {
        try {
            OracleDataSource dataSource = new OracleDataSource();
            dataSource.setURL(Utilidades.getPropiedadConfig("ORACLE_DB_URL"));
            dataSource.setUser(Utilidades.getPropiedadConfig("ORACLE_DB_USERNAME"));
            dataSource.setPassword(Utilidades.getPropiedadConfig("ORACLE_DB_PASSWORD"));

            this.connection = dataSource.getConnection();

        } catch (SQLException e) {
            LOGGER.fatal(e.getMessage(), e);
            throw new BDException(e.getMessage());
        }
    }

    /**
     * Cierra una conexión a la base de datos y libera los recursos
     *
     * @throws BDException en caso de error cerrando la conexión
     */
    @Override
    public void close() throws BDException {
        try {
            if (this.resultSet != null) this.resultSet.close();
            if (this.connection != null) this.connection.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new BDException(e.getMessage());
        }
    }

}
