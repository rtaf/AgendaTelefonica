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
import javax.swing.table.TableModel;

/**
 *
 * @author rtafuni
 */
public class CarteDeTelefonController {

    private final CarteDeTelefon carteDeTelefonModel;
    private final AgendaUI agenda;

    public CarteDeTelefonController(CarteDeTelefon modelCarteDeTelefon) {
        this.carteDeTelefonModel = modelCarteDeTelefon;
        loadDatabaseAtStartup();
        agenda = new AgendaUI(this);
    }

    private void loadDatabaseAtStartup() {
        File file = new File("serialized/agenda1.txt");
        carteDeTelefonModel.setListaAbonati(loadDatabaseFromFile(file));
    }
    
    public void adaugaAbonat(Abonat abonatDeAgaugat) {
        carteDeTelefonModel.adaugaAbonat(abonatDeAgaugat);
        agenda.cleanFieldsAfterAdd();
    }

    public void init() throws InterruptedException {
        agenda.setVisible(true);
    }

    public void stergeAbonatSelectat(int numarAbonat) {
        carteDeTelefonModel.stergeAbonatSelectat(numarAbonat);

    }

    public void modificaAbonatSelectat(Abonat abonatSelectat) {
        Abonat abonatFromFields = agenda.getAbonatFromFields();
        carteDeTelefonModel.modificaAbonatSelectat(abonatSelectat, abonatFromFields);

    }

    public void saveToFile(File fileToSave) {
        try (FileOutputStream fos = new FileOutputStream(fileToSave); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(carteDeTelefonModel.getListaAbonati());
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

    public void setModelInputDataFrom(List<Abonat> loadDatabaseFromFile) {
        carteDeTelefonModel.setListaAbonati(loadDatabaseFromFile);
    }

    public Abonat getAbonatAtPosition(int selectedRow) {
        return carteDeTelefonModel.getListaAbonati().get(selectedRow);
    }

    public TableModel getModelTabelAbonat() {
        return carteDeTelefonModel.getModelTabelAbonat();
    }
}
