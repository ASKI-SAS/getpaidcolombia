package com.ektec.utilidades;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/*
 * Copyright @2017. ASKI, S.A.S. Todos los derechos reservados.
 *
 * @author RIVAS, Ronel
 * @version 1, 2017-03-04
 * @since 1.0
 */
public class Utilidades {
    private static Logger LOGGER = Logger.getLogger(Utilidades.class.getName());

    private static Properties properties = init("config.properties");

    // Cargar archivo de configuración externo al .JAR
    private static Properties init(String rutaArchivo) {
        Properties lproperties = new Properties();
        try (InputStream in = new FileInputStream(new File("").getAbsolutePath() + File.separator + rutaArchivo)) {
            lproperties.load(in);

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return lproperties;
    }

    // Obtener una propiedad de configuración
    public static String getPropiedadConfig(String ppropiedad) {
        String valor = null;
        try {
            if (properties != null)
                valor = properties.getProperty(ppropiedad);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return valor;
    }

}
