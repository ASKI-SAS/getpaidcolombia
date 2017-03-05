package com.ektec;

import com.ektec.negocio.GetPaid;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author SERRANO, Manuel
 * @author RIVAS, Ronel
 * @version 1, 2017-03-04
 * @since 1.0
 */
public class Main implements Serializable {
    private static Logger LOGGER = Logger.getLogger(GetPaid.class.getName());

    private GetPaid pasarela;

    public Main() {
        // Obtener la instancia del ConsumidorWS
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        pasarela = (GetPaid) context.getBean("getPaid");

        // Informar estado de los LOGS
        if (LOGGER.isDebugEnabled() || LOGGER.isInfoEnabled() || LOGGER.isTraceEnabled())
            LOGGER.debug("LOGS HABILITADOS");
        else
            LOGGER.debug("LOGS INHABILITADOS: sólo se verán los ERROR o SEVERE");
    }

    // Programa principal
    public static void main(String[] args) {
        try {
            if (LOGGER.isDebugEnabled())
                LOGGER.debug("**** Proceso: INICIADO...");

            // Invocar el consumo del WS
            Main aplicacion = new Main();
            while (true)
                aplicacion.pasarela.getPaid();

        } catch (Exception e) {
            LOGGER.fatal(e.getMessage(), e);

            if (LOGGER.isDebugEnabled())
                LOGGER.debug("**** Proceso: FINALIZADO...");

            System.exit(0);
        }
    }

}
