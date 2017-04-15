
package com.ektec.modelo.redeban;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TipoModoCapturaPAN.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoModoCapturaPAN">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Manual"/>
 *     &lt;enumeration value="Banda"/>
 *     &lt;enumeration value="Barras"/>
 *     &lt;enumeration value="OCR"/>
 *     &lt;enumeration value="CHIP"/>
 *     &lt;enumeration value="ContactlessBanda"/>
 *     &lt;enumeration value="ContactlessChip"/>
 *     &lt;enumeration value="Fallback"/>
 *     &lt;enumeration value="E-commerce"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "TipoModoCapturaPAN", namespace = "http://www.rbm.com.co/esb/comercio/")
@XmlEnum
public enum TipoModoCapturaPAN {

    @XmlEnumValue("Manual")
    MANUAL("Manual"),
    @XmlEnumValue("Banda")
    BANDA("Banda"),
    @XmlEnumValue("Barras")
    BARRAS("Barras"),
    OCR("OCR"),
    CHIP("CHIP"),
    @XmlEnumValue("ContactlessBanda")
    CONTACTLESS_BANDA("ContactlessBanda"),
    @XmlEnumValue("ContactlessChip")
    CONTACTLESS_CHIP("ContactlessChip"),
    @XmlEnumValue("Fallback")
    FALLBACK("Fallback"),
    @XmlEnumValue("E-commerce")
    E_COMMERCE("E-commerce");
    private final String value;

    TipoModoCapturaPAN(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoModoCapturaPAN fromValue(String v) {
        for (TipoModoCapturaPAN c : TipoModoCapturaPAN.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
