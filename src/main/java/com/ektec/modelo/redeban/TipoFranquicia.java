
package com.ektec.modelo.redeban;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoFranquicia.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoFranquicia">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MasterCard"/>
 *     &lt;enumeration value="VISA"/>
 *     &lt;enumeration value="AmEx"/>
 *     &lt;enumeration value="DinersClub"/>
 *     &lt;enumeration value="UnionPay"/>
 *     &lt;enumeration value="CMRFalabella"/>
 *     &lt;enumeration value="JCB"/>
 *     &lt;enumeration value="Codensa"/>
 *     &lt;enumeration value="sociosbbva"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 *
 */
@XmlType(name = "TipoFranquicia")
@XmlEnum
public enum TipoFranquicia {

    @XmlEnumValue("MasterCard")
    MASTER_CARD("MasterCard"),
    VISA("VISA"),
    @XmlEnumValue("AmEx")
    AM_EX("AmEx"),
    @XmlEnumValue("DinersClub")
    DINERS_CLUB("DinersClub"),
    @XmlEnumValue("UnionPay")
    UNION_PAY("UnionPay"),
    @XmlEnumValue("CMRFalabella")
    CMR_FALABELLA("CMRFalabella"),
    JCB("JCB"),
    @XmlEnumValue("Codensa")
    CODENSA("Codensa"),
    @XmlEnumValue("sociosbbva")
    SOCIOSBBVA("sociosbbva");
    private final String value;

    TipoFranquicia(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoFranquicia fromValue(String v) {
        for (TipoFranquicia c: TipoFranquicia.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
