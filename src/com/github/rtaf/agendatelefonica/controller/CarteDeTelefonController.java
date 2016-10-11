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
import com.github.rtaf.agendatelefonica.view.SplashScreen;

/**
 *
 * @author rtafuni
 */
public class CarteDeTelefonController {

    private final CarteDeTelefon modelCarteDeTelefon;
    private final AgendaUI agenda;
    private final SplashScreen splashScreen;

    public CarteDeTelefonController(CarteDeTelefon modelCarteDeTelefon) {
        this.modelCarteDeTelefon = modelCarteDeTelefon;
        agenda = new AgendaUI(this);
        splashScreen = new SplashScreen();
    }

    public void adaugaAbonat(Abonat abonatDeAgaugat) {
        modelCarteDeTelefon.adaugaAbonat(abonatDeAgaugat);
        agenda.cleanFieldsAfterAdd();
    }

    public ModelTabelAbonat getModelTabelAbonat() {
        return modelCarteDeTelefon.getModelTabelAbonat();
    }

    public void init() throws InterruptedException {
        splashScreen.setVisible(true);
        Thread.sleep(4000);
        splashScreen.dispose();
        agenda.setVisible(true);
    }

    public void stergeAbonatSelectat(int numarAbonat) {
        modelCarteDeTelefon.stergeAbonatSelectat(numarAbonat);

    }

}
