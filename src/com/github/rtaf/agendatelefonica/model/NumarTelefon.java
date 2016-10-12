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
public abstract class NumarTelefon implements Serializable{

    private String numarTelefon;

    public NumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    @Override
    public String toString() {
        return numarTelefon;
    }

}
