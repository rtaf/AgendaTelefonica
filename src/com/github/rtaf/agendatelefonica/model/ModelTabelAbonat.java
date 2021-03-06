/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.rtaf.agendatelefonica.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rtafuni
 */
public class ModelTabelAbonat extends AbstractTableModel {

    private List<Abonat> listAbonati;
    private final String[] titluColoane = {"Nume", "Prenume", "CNP", "Telefon"};

    public ModelTabelAbonat(List<Abonat> abonati) {
        listAbonati = abonati;
    }

    public void notificareDateSchimbateInModel() {
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listAbonati.size();
    }

    @Override
    public int getColumnCount() {
        return titluColoane.length;
    }

    @Override
    public String getColumnName(int i) {
        return titluColoane[i];
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return getValueAt(0, i).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Abonat abonat = listAbonati.get(row);

        switch (col) {
            case 0:
                abonat.setNume(String.valueOf(value));
                break;
            case 1:
                abonat.setPrenume(String.valueOf(value));
                break;
            case 2:
                abonat.setCnp((String) value);
                break;
            case 3:
                abonat.setTelefon(new NumarMobil((String) value));
                break;
            default:

        }
        fireTableCellUpdated(row, col);
    }

    @Override
    public Object getValueAt(int row, int col) {
        Abonat abonat = listAbonati.get(row);
        switch (col) {
            case 0:
                return abonat.getNume();
            case 1:
                return abonat.getPrenume();
            case 2:
                return abonat.getCnp();
            case 3:
                return abonat.getTelefon();
            default:
                return null;
        }
    }

    void setListaAbonati(List<Abonat> listaAbonati) {
        this.listAbonati = listaAbonati;
        notificareDateSchimbateInModel();
    }

}
