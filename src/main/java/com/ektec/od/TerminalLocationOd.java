package com.ektec.od;

import java.io.Serializable;

/**
 * Created by mserrano on 23/04/2016.
 */
public class TerminalLocationOd implements Serializable {
    private String terminalOwner;
    private String terminalCity;
    private String terminalState;
    private String terminalCountry;

    public String getTerminalOwner() {
        return terminalOwner;
    }

    public void setTerminalOwner(String terminalOwner) {
        this.terminalOwner = terminalOwner;
    }

    public String getTerminalCity() {
        return terminalCity;
    }

    public void setTerminalCity(String terminalCity) {
        this.terminalCity = terminalCity;
    }

    public String getTerminalState() {
        return terminalState;
    }

    public void setTerminalState(String terminalState) {
        this.terminalState = terminalState;
    }

    public String getTerminalCountry() {
        return terminalCountry;
    }

    public void setTerminalCountry(String terminalCountry) {
        this.terminalCountry = terminalCountry;
    }
}
