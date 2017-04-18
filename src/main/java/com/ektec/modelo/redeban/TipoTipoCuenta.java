
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoTipoCuenta.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoTipoCuenta">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Ahorros"/>
 *     &lt;enumeration value="Corriente"/>
 *     &lt;enumeration value="CreditoRotativo"/>
 *     &lt;enumeration value="Credito"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */

@XmlType(name = "TipoTipoCuenta")
@XmlEnum
public enum TipoTipoCuenta {

    @XmlEnumValue("Ahorros")
    AHORROS("Ahorros"),
    @XmlEnumValue("Corriente")
    CORRIENTE("Corriente"),
    @XmlEnumValue("CreditoRotativo")
    CREDITO_ROTATIVO("CreditoRotativo"),
    @XmlEnumValue("Credito")
    CREDITO("Credito");
    private final String value;

    TipoTipoCuenta(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoTipoCuenta fromValue(String v) {
        for (TipoTipoCuenta c: TipoTipoCuenta.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
