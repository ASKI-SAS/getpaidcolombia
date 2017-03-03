package com.ektec.negocio;

import com.ektec.db.oraclecomundao;
import com.ektec.od.*;
import com.ektec.utilidades.ConsumerClient;
import com.ektec.utilidades.PublicKeyReader;
import com.ektec.utilidades.Utilidades;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.security.PublicKey;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Created by mserrano on 28/04/2016.
 */
public class GetPaid extends oraclecomundao {
    private static Logger LOGGER = Logger.getLogger(GetPaid.class.getName());

    public GetPaid() {
    }

/*Metodo que desencola*/

    public static String encrypt(String text, PublicKey key) {

        byte[] cipherText = null;

        StringBuilder sb = new StringBuilder();

        BASE64Encoder encoder = new BASE64Encoder();

        try {

            final Cipher cipher = Cipher.getInstance("RSA");

            cipher.init(Cipher.ENCRYPT_MODE, key);

            cipherText = cipher.doFinal(text.getBytes());

        } catch (Exception e) {

            e.printStackTrace();

        }

        return encoder.encode(cipherText).replaceAll("\n", "");

    }

    /*Arma el objeto de la cola*/

    public GetPaidResponseOd getPaid() throws Exception {
        final String origen = "GetPaid.getPaid";
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet result = null;
        GetPaidResponseOd GetPaidResponseOd = null;
        String idServicio = null;
        GetPaidRequestOd getPaidRequestOd = null;

        try {
            if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen);

            long time = System.currentTimeMillis();

            connection = getConnection();

            if (connection != null) {
                statement = connection.prepareCall("{call pkg_ws_quepay.sp_ws_dequeue(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");


                statement.registerOutParameter(1, Types.VARCHAR);
                statement.registerOutParameter(2, Types.VARCHAR);
                statement.registerOutParameter(3, Types.DATE);
                statement.registerOutParameter(4, Types.NUMERIC);
                statement.registerOutParameter(5, Types.VARCHAR);
                statement.registerOutParameter(6, Types.VARCHAR);
                statement.registerOutParameter(7, Types.VARCHAR);
                statement.registerOutParameter(8, Types.VARCHAR);
                statement.registerOutParameter(9, Types.VARCHAR);
                statement.registerOutParameter(10, Types.VARCHAR);
                statement.registerOutParameter(11, Types.VARCHAR);
                statement.registerOutParameter(12, Types.VARCHAR);
                statement.registerOutParameter(13, Types.VARCHAR);
                statement.registerOutParameter(14, Types.NUMERIC);
                statement.registerOutParameter(15, Types.NUMERIC);
                statement.registerOutParameter(16, Types.NUMERIC);

                result = statement.executeQuery();

                GetPaidResponseOd = new GetPaidResponseOd();
                GetPaidResponseOd.setEstado(statement.getString(16));

                idServicio = statement.getString(1);


                if (!GetPaidResponseOd.getEstado().equalsIgnoreCase("0")) {
                    if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                        LOGGER.info("____________________________________________________________________________________");
                    throw (new Exception("Mensaje de la Base de datos: " + GetPaidResponseOd.getEstado(), null));
                } else {
                    if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                        LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | 0 respuesta de bd exitosa");
                    if (!idServicio.equalsIgnoreCase("X")) {
                        getPaidRequestOd = this.GetPaidObject(statement);
                        /*Validacion del estado*/
                        GetPaidResponseOd = this.getServiceExterno(getPaidRequestOd);
                        GetPaidResponseOd.setFolioTransaccion(getPaidRequestOd.getPeticion().getFolioTransaccion());
                        GetPaidResponseOd.setFechaHoraSolicitud(getPaidRequestOd.getSeguridad().getFechaHora());
                        GetPaidResponseOd = this.setResponse(GetPaidResponseOd);
                        if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                            LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | ID de sevicio procesado: " + getPaidRequestOd.getPeticion().getIdServicio());
                    } else {
                        if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                            LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | No hay solicitudes en la cola");
                    }

                    if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                        LOGGER.info("____________________________________________________________________________________");
                }

                if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                    LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | 0 respuesta de bd exitosa");

            } else {
                LOGGER.severe(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | No hay conexion con la Base de datos");
            }


            time = System.currentTimeMillis() - time;
            if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | " + time);

        } catch (Exception ex) {
            LOGGER.severe(ResourceBundle.getBundle("log").getString("log.error") + ex.getMessage());
        } finally {
            closeJdbcObjects(connection, statement, result);
        }

        return (GetPaidResponseOd);
    }

    /*Llama al consumo del servicio del csa*/

    public GetPaidRequestOd GetPaidObject(CallableStatement statement) {
        final String origen = "GetPaid.GetPaidObject";
        GetPaidRequestOd getPaidRequestOd = null;
        try {

            if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen);
            long time = System.currentTimeMillis();

            getPaidRequestOd = new GetPaidRequestOd();
            getPaidRequestOd.setSeguridad(new SeguridadOd());
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            DateFormat dfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date today = Calendar.getInstance().getTime();
            String reportDate = df.format(today);
            getPaidRequestOd.getSeguridad().setFechaHora(reportDate);
            getPaidRequestOd.getSeguridad().setUsuario(Utilidades.getPropiedadConfig("seguridad.usuario"));
            String textencrypt = GetPaid.encrypt(getPaidRequestOd.getSeguridad().getUsuario() + "::" + Utilidades.getPropiedadConfig("seguridad.key") + "::" + getPaidRequestOd.getSeguridad().getFechaHora(), PublicKeyReader.get());
            getPaidRequestOd.getSeguridad().setKey(textencrypt);
            getPaidRequestOd.setPeticion(new PeticionOd());
            getPaidRequestOd.getPeticion().setIdServicio(statement.getString(1));
            getPaidRequestOd.getPeticion().setFolioTransaccion(statement.getString(2));
            Date datedb = dfd.parse(statement.getString(3));
            String reportDate2 = df.format(datedb);
            getPaidRequestOd.getPeticion().setFechaHora(reportDate2);
            getPaidRequestOd.getPeticion().setImporteTransaccion(statement.getDouble(4));
            getPaidRequestOd.getPeticion().setMerchantType(statement.getString(5));
            getPaidRequestOd.getPeticion().setTlv(statement.getString(6));
            getPaidRequestOd.getPeticion().setTrack(statement.getString(7));
            getPaidRequestOd.getPeticion().setKsn(statement.getString(8));
            getPaidRequestOd.getPeticion().setTerminalId(statement.getString(9));
            getPaidRequestOd.getPeticion().setTerminalLocation(new TerminalLocationOd());
            getPaidRequestOd.getPeticion().getTerminalLocation().setTerminalOwner(statement.getString(10));
            getPaidRequestOd.getPeticion().getTerminalLocation().setTerminalCity(statement.getString(11));
            getPaidRequestOd.getPeticion().getTerminalLocation().setTerminalState(statement.getString(12));
            getPaidRequestOd.getPeticion().getTerminalLocation().setTerminalCountry(statement.getString(13));
            getPaidRequestOd.getPeticion().setAdditionalData(new AdditionalDataOd());
            getPaidRequestOd.getPeticion().getAdditionalData().setRetailerId(statement.getLong(14));


            time = System.currentTimeMillis() - time;
            if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | " + time);

        } catch (Exception e) {
            LOGGER.severe(ResourceBundle.getBundle("log").getString("log.error") + e.getMessage());
        }

        return getPaidRequestOd;

    }

    private GetPaidResponseOd getServiceExterno(GetPaidRequestOd GetPaidRequestOd) {
        final String origen = "GetPaid.getServiceExterno";
        long time = 0;
        GetPaidResponseOd getPaidResponseOd = null;

        try {

            if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen);

            time = System.currentTimeMillis();
            ResponseEntity entity;

            if (GetPaidRequestOd.getPeticion().getTlv() != null) {
                getPaidResponseOd = (GetPaidResponseOd) ConsumerClient.consume(Utilidades.getPropiedadConfig("servicio.url.getpaidChip"), GetPaidRequestOd, GetPaidResponseOd.class);
                if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                    LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | " + " Servicio por CHIP - " + new Gson().toJson(getPaidResponseOd));
            } else {
                getPaidResponseOd = (GetPaidResponseOd) ConsumerClient.consume(Utilidades.getPropiedadConfig("servicio.url.getpaidBanda"), GetPaidRequestOd, GetPaidResponseOd.class);
                if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                    LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | " + " Servicio por BANDA - " + new Gson().toJson(getPaidResponseOd));
            }

            time = System.currentTimeMillis() - time;
            if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | " + time);

        } catch (Exception e) {
            LOGGER.severe(ResourceBundle.getBundle("log").getString("log.error") + e.getMessage());
        }

        return getPaidResponseOd;

    }

    public GetPaidResponseOd setResponse(GetPaidResponseOd getPaidResponseOd) throws Exception {
        final String origen = "GetPaid.setResponse";
        Connection connection = null;
        CallableStatement statement = null;
        ResultSet result = null;
        GetPaidResponseOd getPaidResponseOd1 = null;

        try {
            if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen);
            long time = System.currentTimeMillis();

            connection = getConnection();

            if (connection != null) {
                statement = connection.prepareCall("{call SP_WS_UPDENTRIES(?,?,?,?,?,?,?,?,?)}");


                if (getPaidResponseOd.getFolioTransaccion() != null)
                    statement.setString(1, getPaidResponseOd.getFolioTransaccion());
                else
                    statement.setNull(1, Types.NULL);

                if (getPaidResponseOd.getIdRespuesta() != null)
                    statement.setString(2, getPaidResponseOd.getIdRespuesta());
                else
                    statement.setNull(2, Types.NULL);

                if (getPaidResponseOd.getDescripcion() != null)
                    statement.setString(3, getPaidResponseOd.getDescripcion());
                else
                    statement.setNull(3, Types.NULL);

                if (getPaidResponseOd.getAuditNumber() != null)
                    statement.setString(4, getPaidResponseOd.getAuditNumber());
                else
                    statement.setNull(4, Types.NULL);

                if (getPaidResponseOd.getAuthorizationId() != null)
                    statement.setString(5, getPaidResponseOd.getAuthorizationId());
                else
                    statement.setNull(5, Types.NULL);

                if (getPaidResponseOd.getResponseCode() != null)
                    statement.setString(6, getPaidResponseOd.getResponseCode());
                else
                    statement.setNull(6, Types.NULL);

                if (getPaidResponseOd.getFechaHora() != null) {
                    statement.setString(7, getPaidResponseOd.getFechaHora());
                } else
                    statement.setNull(7, Types.NULL);


                if (getPaidResponseOd.getFechaHoraSolicitud() != null) {
                    statement.setString(8, getPaidResponseOd.getFechaHoraSolicitud());
                } else
                    statement.setNull(8, Types.NULL);

                statement.registerOutParameter(9, Types.NUMERIC);

                result = statement.executeQuery();

                getPaidResponseOd1 = new GetPaidResponseOd();
                getPaidResponseOd1.setEstado(statement.getString(9));


                if (!getPaidResponseOd1.getEstado().equalsIgnoreCase("0")) {
                    if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                        LOGGER.info("____________________________________________________________________________________");
                    throw (new Exception("Mensaje de la Base de datos: " + getPaidResponseOd1.getEstado(), null));
                } else {
                    if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                        LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | 0 respuesta de bd exitosa");
                    if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                        LOGGER.info("____________________________________________________________________________________");
                }

                if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                    LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | 0 respuesta de bd exitosa");

            } else {
                LOGGER.severe(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | No hay conexion con la Base de datos");
            }


            time = System.currentTimeMillis() - time;
            if (Utilidades.getPropiedadConfig("LOG_ENABLED").equalsIgnoreCase("true"))
                LOGGER.info(ResourceBundle.getBundle("log").getString("log.servicios") + GetPaid.class + " | " + origen + " | " + time);

        } catch (Exception ex) {
            LOGGER.severe(ResourceBundle.getBundle("log").getString("log.error") + ex.getMessage());
        } finally {
            closeJdbcObjects(connection, statement, result);
        }

        return (getPaidResponseOd1);
    }

}