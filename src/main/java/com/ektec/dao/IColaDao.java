package com.ektec.dao;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author SERRANO, Manuel
 * @author RIVAS, Ronel
 * @version 1, 2013-09-26
 * @since 1.0
 */
public interface IColaDao {
    // Permite guardar un objeto en la cola en BD
    Object encolar(Object obj) throws BDException;

    // Permite extraer un objeto de la cola en BD
    Object desencolar() throws BDException;

}
