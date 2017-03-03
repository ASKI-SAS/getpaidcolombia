package com.ektec.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by mserrano on 30/05/16.
 */
public class Utilidades {

    public static String getPropiedadConfig(String ppropiedad) {
        Properties prop = new Properties();
        InputStream input = null;
        String propiedad = null;
        try {

            input = new FileInputStream(new File("").getAbsolutePath() + "/config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            propiedad = prop.getProperty(ppropiedad);


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return propiedad;
    }


}
