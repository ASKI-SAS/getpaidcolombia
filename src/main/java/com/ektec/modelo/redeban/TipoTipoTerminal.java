
package com.ektec.modelo.redeban;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoTipoTerminal.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoTipoTerminal">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="WEB"/>
 *     &lt;enumeration value="OrdenTelefonico"/>
 *     &lt;enumeration value="POS"/>
 *     &lt;enumeration value="Movil"/>
 *     &lt;enumeration value="OrdenCorreo"/>
 *     &lt;enumeration value="GlobalPay"/>
 *     &lt;enumeration value="PEW"/>
 *     &lt;enumeration value="SmartPhone"/>
 *     &lt;enumeration value="Tablet"/>
 *     &lt;enumeration value="TVDigital"/>
 *     &lt;enumeration value="BilleteraImpresa"/>
 *     &lt;enumeration value="BilleteraPOS"/>
 *     &lt;enumeration value="BilleteraAPP"/>
 *     &lt;enumeration value="BilleteraEComm"/>
 *     &lt;enumeration value="BilleteraRBMovil"/>
 *     &lt;enumeration value="DatafonoWeb"/>
 *     &lt;enumeration value="APPRBM"/>
 *     &lt;enumeration value="APPBanco"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "TipoTipoTerminal", namespace = "http://www.rbm.com.co/esb/comercio/")
@XmlEnum
public enum TipoTipoTerminal {

    WEB("WEB"),
    @XmlEnumValue("OrdenTelefonico")
    ORDEN_TELEFONICO("OrdenTelefonico"),
    POS("POS"),
    @XmlEnumValue("Movil")
    MOVIL("Movil"),
    @XmlEnumValue("OrdenCorreo")
    ORDEN_CORREO("OrdenCorreo"),
    @XmlEnumValue("GlobalPay")
    GLOBAL_PAY("GlobalPay"),
    PEW("PEW"),
    @XmlEnumValue("SmartPhone")
    SMART_PHONE("SmartPhone"),
    @XmlEnumValue("Tablet")
    TABLET("Tablet"),
    @XmlEnumValue("TVDigital")
    TV_DIGITAL("TVDigital"),
    @XmlEnumValue("BilleteraImpresa")
    BILLETERA_IMPRESA("BilleteraImpresa"),
    @XmlEnumValue("BilleteraPOS")
    BILLETERA_POS("BilleteraPOS"),
    @XmlEnumValue("BilleteraAPP")
    BILLETERA_APP("BilleteraAPP"),
    @XmlEnumValue("BilleteraEComm")
    BILLETERA_E_COMM("BilleteraEComm"),
    @XmlEnumValue("BilleteraRBMovil")
    BILLETERA_RB_MOVIL("BilleteraRBMovil"),
    @XmlEnumValue("DatafonoWeb")
    DATAFONO_WEB("DatafonoWeb"),
    APPRBM("APPRBM"),
    @XmlEnumValue("APPBanco")
    APP_BANCO("APPBanco");
    private final String value;

    TipoTipoTerminal(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoTipoTerminal fromValue(String v) {
        for (TipoTipoTerminal c : TipoTipoTerminal.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
