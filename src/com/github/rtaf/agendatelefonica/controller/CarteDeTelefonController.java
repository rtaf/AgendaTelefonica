/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.rtaf.agendatelefonica.controller;

import com.github.rtaf.agendatelefonica.model.Abonat;
import com.github.rtaf.agendatelefonica.model.CarteDeTelefon;
import com.github.rtaf.agendatelefonica.model.ModelTabelAbonat;
import com.github.rtaf.agendatelefonica.view.AgendaUI;

/**
 *
 * @author rtafuni
 */
public class CarteDeTelefonController {

    private final CarteDeTelefon modelCarteDeTelefon;
    private final AgendaUI agenda;

    public CarteDeTelefonController(CarteDeTelefon modelCarteDeTelefon) {
        this.modelCarteDeTelefon = modelCarteDeTelefon;
        agenda = new AgendaUI(this);
    }

    public void adaugaAbonat(Abonat abonatDeAgaugat) {
        modelCarteDeTelefon.adaugaAbonat(abonatDeAgaugat);
        agenda.cleanFieldsAfterAdd();
    }

    public ModelTabelAbonat getModelTabelAbonat() {
        return modelCarteDeTelefon.getModelTabelAbonat();
    }

    public void init() {
        agenda.setVisible(true);
    }

    public void stergeAbonatSelectat(int numarAbonat) {
        modelCarteDeTelefon.stergeAbonatSelectat(numarAbonat);

    }

}
