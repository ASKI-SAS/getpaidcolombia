package com.ektec.dao;

import com.ektec.exception.BDException;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author RIVAS, Ronel
 * @version 1, 2017-03-25
 * @since 1.0
 */
public interface IBaseDao {

    void connect() throws BDException;

    void close() throws BDException;

}
