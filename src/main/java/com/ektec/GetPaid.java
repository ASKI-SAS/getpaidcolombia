package com.ektec;

import com.ektec.negocio.impl.PasarelaService;
import com.ektec.utilidades.Utilidades;
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
public class GetPaid implements Serializable {
    private static Logger LOGGER = Logger.getLogger(PasarelaService.class.getName());

    private PasarelaService pasarelaService;

    private GetPaid() {
        // Levantar el contexto de Spring
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        pasarelaService = (PasarelaService) context.getBean("pasarelaService");

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
            GetPaid aplicacion = new GetPaid();
            boolean reversar = Utilidades.getPropiedadConfig("servicio.reverse.habilitado").equalsIgnoreCase("true");
            while (true) {
                // Cobrar servicio
                aplicacion.pasarelaService.getPaid();

                // Reversar Servicios Incompletos
                if (reversar)
                    aplicacion.pasarelaService.getReverse();
            }

        } catch (Exception e) {
            LOGGER.fatal(e.getMessage(), e);

            if (LOGGER.isDebugEnabled())
                LOGGER.debug("**** Proceso: FINALIZADO...");

            System.exit(0);
        }
    }

}
