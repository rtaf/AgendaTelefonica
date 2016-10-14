/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.rtaf.agendatelefonica.model;

import java.io.Serializable;

/**
 *
 * @author rtafuni
 */
public class Abonat implements Serializable {

    private String nume;
    private String prenume;
    private String cnp;
    private NumarTelefon telefon;

    public Abonat(String nume, String prenume, String cnp, NumarTelefon telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
        this.telefon = telefon;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public NumarTelefon getTelefon() {
        return telefon;
    }

    public void setTelefon(NumarTelefon telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Abonat{" + "nume=" + nume + ", prenume=" + prenume + ", cnp=" + cnp + ", telefon=" + telefon + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Abonat) {
            Abonat abonatDeComparat = (Abonat) o;
            if (!abonatDeComparat.nume.equals(this.nume)) {
                return false;
            }
            if (!abonatDeComparat.prenume.equals(this.prenume)) {
                return false;
            }
            if (!abonatDeComparat.cnp.equals(this.cnp)) {
                return false;
            }
            if (!abonatDeComparat.telefon.toString().equals(this.telefon.toString())) {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

}
