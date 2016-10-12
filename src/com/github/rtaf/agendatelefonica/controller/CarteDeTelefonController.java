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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void modificaAbonatSelectat(Abonat abonatSelectat) {
        Abonat abonatFromFields = agenda.getAbonatFromFields();
        modelCarteDeTelefon.modificaAbonatSelectat(abonatSelectat, abonatFromFields);

    }

    public void saveToFile(File fileToSave) {
        try (FileOutputStream fos = new FileOutputStream(fileToSave); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(modelCarteDeTelefon.getListaAbonati());
        } catch (IOException ex) {
            Logger.getLogger(CarteDeTelefonController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Abonat> loadDatabaseFromFile(File fileToLoad) {
        List<Abonat> listaIncarcata = null;
        try (FileInputStream fis = new FileInputStream(fileToLoad); ObjectInputStream ois = new ObjectInputStream(fis)) {
            listaIncarcata = (List<Abonat>) ois.readObject();
        } catch (ClassNotFoundException | IOException ex) {
            Logger.getLogger(CarteDeTelefonController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaIncarcata;

    }
}
