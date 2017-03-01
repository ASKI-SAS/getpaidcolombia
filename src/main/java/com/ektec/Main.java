package com.ektec;

import com.ektec.negocio.GetPaid;
import com.ektec.od.GetPaidResponseOd;
import com.ektec.utilidades.Utilidades;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Main implements Serializable{
    private static Logger LOGGER = Logger.getLogger(GetPaid.class.getName());
    private  GetPaid getPaid;

    public static void main(String[] args) {
        final String origen = "GetPaid.main";
        long time = 0;

        try {



            if(!Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                LOGGER.info("LOS LOG ESTAN DESACTIVADOS SOLO SE VERAN LOS ERROR O SEVERE");
            else
                LOGGER.info("LOS LOG ESTAN ACTIVADOS SOLO SE VERAN LOS ERROR O SEVERE");

            if(Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + "INICIANDO PROCESO");




            Main m=new Main();

            m.consumir();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void consumir (){
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
            setGetPaid((GetPaid) context.getBean("getPaid"));

            while(true) {
                GetPaidResponseOd getPaidResponseOd = getGetPaid().getPaid();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    public GetPaid getGetPaid() {
        return getPaid;
    }

    public void setGetPaid(GetPaid getPaid) {
        this.getPaid = getPaid;
    }
}
