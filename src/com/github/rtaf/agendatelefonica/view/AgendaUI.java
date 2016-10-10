/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.rtaf.agendatelefonica.view;

import com.github.rtaf.agendatelefonica.model.Abonat;
import com.github.rtaf.agendatelefonica.model.ModelTabelAbonat;
import com.github.rtaf.agendatelefonica.model.NumarMobil;
import com.github.rtaf.agendatelefonica.model.NumarTelefon;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author rtafuni
 */
public class AgendaUI extends javax.swing.JFrame {

    ModelTabelAbonat modelTabelAbonati;
    Timer timerReclame;

    //path to the pictures directory; used for slide show
    Path path = Paths.get("pictures");
    Path absolutePath = path.toAbsolutePath();

    // File representing the folder with the pictures 
    final File dir = new File(absolutePath.toString());

    // array of supported extensions 
    static final String[] EXTENSIONS = new String[]{
        "jpg" // and other formats you need
    };

    //list with the icons for the JLabel (the pictures in this case)
    List<ImageIcon> iconList = new ArrayList();
    //index and randomGenerator to pick one picture with the timer
    int index;
    private final Random randomGenerator;

    // filter to identify images based on their extensions
    static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {

        @Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };

    /**
     * Creates new form AgendaUI
     */
    public AgendaUI() throws InterruptedException {
        initComponents();
        DisableTextFieldsUI();
        adaugareInTabelAbonati();

        randomGenerator = new Random();
        if (dir.isDirectory()) { // make sure it's a directory
            for (final File f : dir.listFiles(IMAGE_FILTER)) {
                System.out.println(f.getAbsolutePath());
                iconList.add(new ImageIcon(f.getAbsolutePath()));

            }
        }

        //set a timer to change pictures in JLabelReclame
        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                index = randomGenerator.nextInt(iconList.size());
                System.out.println(index);
                jLabelReclame.setIcon(iconList.get(index));
            }

        };
        t.schedule(task, 0, 5000);
    }

    /**
     * enables text fields from UI
     */
    void EnableTextFieldsUI() {
        textNume.setEnabled(true);
        textPrenume.setEnabled(true);
        textCNP.setEnabled(true);
        textNrTel.setEnabled(true);
        textNume.requestFocus();
    }

    /**
     * disables text fields from UI
     */
    void DisableTextFieldsUI() {
        textNume.setEnabled(false);
        textPrenume.setEnabled(false);
        textCNP.setEnabled(false);
        textNrTel.setEnabled(false);
    }

    void adaugareInTabelAbonati() {
        String[] numeColoane = {"ID", "Nume", "Prenume", "CNP", "NrTel"};
        NumarTelefon tel = new NumarMobil("0755775775");

        Abonat a1 = new Abonat("Ion", "Popescu", "1778845878787", tel);
        List<Abonat> listaAbonati = new ArrayList<>();
        listaAbonati.add(a1);
        modelTabelAbonati = new ModelTabelAbonat(listaAbonati);
        jTableAbonati.setModel(modelTabelAbonati);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelNume = new javax.swing.JLabel();
        jLabelPrenume = new javax.swing.JLabel();
        jLabelCNP = new javax.swing.JLabel();
        textNume = new javax.swing.JTextField();
        textPrenume = new javax.swing.JTextField();
        jLabelNrTel = new javax.swing.JLabel();
        textCNP = new javax.swing.JTextField();
        textNrTel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAbonati = new javax.swing.JTable();
        butonAdauga = new javax.swing.JButton();
        butonSalavare = new javax.swing.JButton();
        butonStergere = new javax.swing.JButton();
        butonActualizare = new javax.swing.JButton();
        butonAnulare = new javax.swing.JButton();
        jLabelReclame = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemIesire = new javax.swing.JMenuItem();
        jMenuAbonati = new javax.swing.JMenu();
        jMenuItemAdauga = new javax.swing.JMenuItem();
        jMenuItemStergere = new javax.swing.JMenuItem();
        jMenuItemActualizare = new javax.swing.JMenuItem();
        jMenuItemCauta = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuItemInregistrare = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date Abonat:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), java.awt.Color.blue)); // NOI18N

        jLabelNume.setText("Nume");

        jLabelPrenume.setText("Prenume");

        jLabelCNP.setText("CNP");

        jLabelNrTel.setText("NrTel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelPrenume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCNP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNrTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNume)
                    .addComponent(textPrenume)
                    .addComponent(textNrTel, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(textCNP))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textNume)
                    .addComponent(jLabelNume, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPrenume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textCNP)
                    .addComponent(jLabelCNP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textNrTel)
                    .addComponent(jLabelNrTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableAbonati.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableAbonati);

        butonAdauga.setText("Adauga");
        butonAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAdaugaActionPerformed(evt);
            }
        });

        butonSalavare.setText("Salvare");
        butonSalavare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonSalavareActionPerformed(evt);
            }
        });

        butonStergere.setText("Stergere");
        butonStergere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonStergereActionPerformed(evt);
            }
        });

        butonActualizare.setText("Actualizare");

        butonAnulare.setText("Anulare");

        jMenuFile.setText("File");

        jMenuItemOpen.setText("Open");
        jMenuFile.add(jMenuItemOpen);

        jMenuItemSave.setText("Save");
        jMenuFile.add(jMenuItemSave);
        jMenuFile.add(jSeparator1);

        jMenuItemIesire.setText("Iesire");
        jMenuFile.add(jMenuItemIesire);

        jMenuBar1.add(jMenuFile);

        jMenuAbonati.setText("Abonati");

        jMenuItemAdauga.setText("Adauga");
        jMenuAbonati.add(jMenuItemAdauga);

        jMenuItemStergere.setText("Stergere");
        jMenuAbonati.add(jMenuItemStergere);

        jMenuItemActualizare.setText("Actualizare");
        jMenuAbonati.add(jMenuItemActualizare);

        jMenuItemCauta.setText("Cauta");
        jMenuAbonati.add(jMenuItemCauta);

        jMenuBar1.add(jMenuAbonati);

        jMenuHelp.setText("Help");

        jMenuItemInregistrare.setText("Inregistrare");
        jMenuHelp.add(jMenuItemInregistrare);
        jMenuHelp.add(jSeparator2);

        jMenuItemAbout.setText("About");
        jMenuHelp.add(jMenuItemAbout);

        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelReclame, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butonAdauga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butonSalavare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butonStergere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butonActualizare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butonAnulare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(262, 262, 262))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butonAdauga)
                    .addComponent(butonSalavare)
                    .addComponent(butonStergere)
                    .addComponent(butonActualizare)
                    .addComponent(butonAnulare))
                .addGap(18, 18, 18)
                .addComponent(jLabelReclame, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butonAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAdaugaActionPerformed
        // TODO add your handling code here:
        EnableTextFieldsUI();
    }//GEN-LAST:event_butonAdaugaActionPerformed

    private void butonSalavareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonSalavareActionPerformed
        // TODO add your handling code here:
        String nume = textNume.getText();
        String prenume = textPrenume.getText();
        String cnp = textCNP.getText();
        String telefon = textNrTel.getText();

        NumarTelefon numarTelefon = new NumarMobil(telefon);
        Abonat abonatSalvat = new Abonat(nume, prenume, cnp, numarTelefon);

        modelTabelAbonati.addAbonat(abonatSalvat);
        jTableAbonati.setModel(modelTabelAbonati);

        cleanFieldsAfterAdd();

        saveToDatabase();


    }//GEN-LAST:event_butonSalavareActionPerformed

    private void butonStergereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonStergereActionPerformed
        Object source = evt.getSource();

        int selectedRow = jTableAbonati.getSelectedRow();
        if (selectedRow != -1) {
            ModelTabelAbonat model = (ModelTabelAbonat) jTableAbonati.getModel();
            model.removeAbonat(model.getAbonat(selectedRow));
        } else {
            JOptionPane.showMessageDialog(null, "Selectie goala");
        }
    }//GEN-LAST:event_butonStergereActionPerformed

    private void cleanFieldsAfterAdd() {
        textNume.setText("");
        textPrenume.setText("");
        textCNP.setText("");
        textNrTel.setText("");

        textNume.setEnabled(false);
        textPrenume.setEnabled(false);
        textCNP.setEnabled(false);
        textNrTel.setEnabled(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butonActualizare;
    private javax.swing.JButton butonAdauga;
    private javax.swing.JButton butonAnulare;
    private javax.swing.JButton butonSalavare;
    private javax.swing.JButton butonStergere;
    private javax.swing.JLabel jLabelCNP;
    private javax.swing.JLabel jLabelNrTel;
    private javax.swing.JLabel jLabelNume;
    private javax.swing.JLabel jLabelPrenume;
    private javax.swing.JLabel jLabelReclame;
    private javax.swing.JMenu jMenuAbonati;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemActualizare;
    private javax.swing.JMenuItem jMenuItemAdauga;
    private javax.swing.JMenuItem jMenuItemCauta;
    private javax.swing.JMenuItem jMenuItemIesire;
    private javax.swing.JMenuItem jMenuItemInregistrare;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenuItem jMenuItemStergere;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable jTableAbonati;
    private javax.swing.JTextField textCNP;
    private javax.swing.JTextField textNrTel;
    private javax.swing.JTextField textNume;
    private javax.swing.JTextField textPrenume;
    // End of variables declaration//GEN-END:variables

    private void saveToDatabase() {
        ModelTabelAbonat model = (ModelTabelAbonat) jTableAbonati.getModel();
        List<Abonat> abonati = model.getAbonati();
        System.out.println(abonati);

    }

}
