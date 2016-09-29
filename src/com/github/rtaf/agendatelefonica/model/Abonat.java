/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.rtaf.agendatelefonica.model;

/**
 *
 * @author rtafuni
 */
public class Abonat {

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

}
