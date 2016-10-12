/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.rtaf.agendatelefonica.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rtafuni
 */
public class CarteDeTelefon {

    List<Abonat> listaAbonati;
    ModelTabelAbonat modelTabelAbonat;

    public CarteDeTelefon() {
        listaAbonati = new ArrayList<>();
        modelTabelAbonat = new ModelTabelAbonat(listaAbonati);
    }

    public List<Abonat> getListaAbonati() {
        return listaAbonati;
    }

    public void setListaAbonati(List<Abonat> listaAbonati) {
        this.listaAbonati = listaAbonati;
    }

    public ModelTabelAbonat getModelTabelAbonat() {
        return modelTabelAbonat;
    }

    public void setModelTabelAbonat(ModelTabelAbonat modelTabelAbonat) {
        this.modelTabelAbonat = modelTabelAbonat;
    }

    public int getNumarAbonati() {
        return modelTabelAbonat.getRowCount();
    }

    public void adaugaAbonat(Abonat abonatDeAdaugat) {
        listaAbonati.add(abonatDeAdaugat);
        modelTabelAbonat.notificareDateSchimbateInModel();

    }

    public void stergeAbonatSelectat(int numarAbonat) {
        listaAbonati.remove(numarAbonat);
        modelTabelAbonat.notificareDateSchimbateInModel();
    }

    public void modificaAbonatSelectat(int numarAbonat) {
        modelTabelAbonat.notificareDateSchimbateInModel();
    }

    public void modificaAbonatSelectat(Abonat abonatSelectat, Abonat abonatFromFields) {
        int positionOfAbonat = listaAbonati.indexOf(abonatSelectat);
        listaAbonati.set(positionOfAbonat, abonatFromFields);
        modelTabelAbonat.notificareDateSchimbateInModel();
    }

}
