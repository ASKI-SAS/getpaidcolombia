
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoTipoBolsillo.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoTipoBolsillo">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Lealtad"/>
 *     &lt;enumeration value="CuotaMonetaria"/>
 *     &lt;enumeration value="CupoCredito"/>
 *     &lt;enumeration value="BonoEfectivo"/>
 *     &lt;enumeration value="CreditoRotativoBolsillo"/>
 *     &lt;enumeration value="BonoRegalo"/>
 *     &lt;enumeration value="BonoDescuento"/>
 *     &lt;enumeration value="BolsilloCredito"/>
 *     &lt;enumeration value="BolsilloDebito"/>
 *     &lt;enumeration value="Ahorros"/>
 *     &lt;enumeration value="Corriente"/>
 *     &lt;enumeration value="Credito"/>
 *     &lt;enumeration value="Desconocida"/>
 *     &lt;enumeration value="CreditoRotativo"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */

@XmlType(name = "TipoTipoBolsillo")
@XmlEnum
public enum TipoTipoBolsillo {

    @XmlEnumValue("Lealtad")
    LEALTAD("Lealtad"),
    @XmlEnumValue("CuotaMonetaria")
    CUOTA_MONETARIA("CuotaMonetaria"),
    @XmlEnumValue("CupoCredito")
    CUPO_CREDITO("CupoCredito"),
    @XmlEnumValue("BonoEfectivo")
    BONO_EFECTIVO("BonoEfectivo"),
    @XmlEnumValue("CreditoRotativoBolsillo")
    CREDITO_ROTATIVO_BOLSILLO("CreditoRotativoBolsillo"),
    @XmlEnumValue("BonoRegalo")
    BONO_REGALO("BonoRegalo"),
    @XmlEnumValue("BonoDescuento")
    BONO_DESCUENTO("BonoDescuento"),
    @XmlEnumValue("BolsilloCredito")
    BOLSILLO_CREDITO("BolsilloCredito"),
    @XmlEnumValue("BolsilloDebito")
    BOLSILLO_DEBITO("BolsilloDebito"),
    @XmlEnumValue("Ahorros")
    AHORROS("Ahorros"),
    @XmlEnumValue("Corriente")
    CORRIENTE("Corriente"),
    @XmlEnumValue("Credito")
    CREDITO("Credito"),
    @XmlEnumValue("Desconocida")
    DESCONOCIDA("Desconocida"),
    @XmlEnumValue("CreditoRotativo")
    CREDITO_ROTATIVO("CreditoRotativo");
    private final String value;

    TipoTipoBolsillo(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoTipoBolsillo fromValue(String v) {
        for (TipoTipoBolsillo c: TipoTipoBolsillo.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
