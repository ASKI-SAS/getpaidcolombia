package com.ektec.od;

import java.io.Serializable;

/**
 * Created by mserrano on 23/04/2016.
 */
public class AdditionalDataOd implements Serializable {
    private Long retailerId;

    public Long getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(Long retailerId) {
        this.retailerId = retailerId;
    }
}
