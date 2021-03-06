/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.rtaf.agendatelefonica.view;

import com.github.rtaf.agendatelefonica.controller.CarteDeTelefonController;
import com.github.rtaf.agendatelefonica.model.Abonat;
import com.github.rtaf.agendatelefonica.model.ModelTabelAbonat;
import com.github.rtaf.agendatelefonica.model.NumarFix;
import com.github.rtaf.agendatelefonica.model.NumarMobil;
import com.github.rtaf.agendatelefonica.model.NumarTelefon;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author rtafuni
 */
public class AgendaUI extends javax.swing.JFrame {

//    private ModelTabelAbonat modelTabelAbonati;
    Timer timerReclame;
    Timer timerSavetoFile;
    TimerTask taskSavetoFile;

    //path to the pictures directory; used for slide show
    Path path = Paths.get("pictures");
    Path absolutePath = path.toAbsolutePath();

    // File representing the folder with the pictures 
    final File dir = new File(absolutePath.toString());

    // File to save the abonati list
    File file;

    // array of supported extensions 
    static final String[] EXTENSIONS = new String[]{
        "jpg" // and other formats you need
    };

    //list with the icons for the JLabel (the pictures in this case)
    List<ImageIcon> iconList = new ArrayList();
    //index and randomGenerator to pick one picture with the timer
    int index;
    private final Random randomGenerator;

    private boolean isAppFull = false;

    private final TableRowSorter<TableModel> rowSorter;

    private final CarteDeTelefonController controllerCarteDeTelefon;

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
     *
     * @param carteDeTelefonController
     */
    public AgendaUI(CarteDeTelefonController carteDeTelefonController) {

        initComponents();
        controllerCarteDeTelefon = carteDeTelefonController;
        jMenuItemOpen.setEnabled(isAppFull);
        jMenuItemSave.setEnabled(isAppFull);
        disableTextFieldsUI();
        initializareModelTabelAbonati();
        listenToTableSelection();

        randomGenerator = new Random();
        if (dir.isDirectory()) { // make sure it's a directory
            for (final File f : dir.listFiles(IMAGE_FILTER)) {
                iconList.add(new ImageIcon(f.getAbsolutePath()));

            }
        }

        //set a timer to change pictures in JLabelReclame
        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                index = randomGenerator.nextInt(iconList.size());
                jLabelReclame.setIcon(iconList.get(index));
            }

        };
        t.schedule(task, 0, 5000);

        //set a timer to save the phonebook to a selected file at every 5 min
        timerSavetoFile = new Timer();

        //table filtering functionality
        this.rowSorter = new TableRowSorter<>(jTableAbonati.getModel());
        jTableAbonati.setRowSorter(rowSorter);
        jTextFilter.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jTextFilter.getText();

                if (text.trim().length() == 0) {
                    jLabelFiltru.setText("Filtru Tabel Inactiv");
                    jLabelFiltru.setBackground(Color.green);
                    rowSorter.setRowFilter(null);
                } else {
                    jLabelFiltru.setText("Filtru Tabel Activ");
                    jLabelFiltru.setBackground(Color.red);
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jTextFilter.getText();

                if (text.trim().length() == 0) {
                    jLabelFiltru.setText("Filtru Tabel Inactiv");
                    jLabelFiltru.setBackground(Color.green);
                    rowSorter.setRowFilter(null);
                } else {
                    jLabelFiltru.setText("Filtru Tabel Activ");
                    jLabelFiltru.setBackground(Color.red);
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
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
    private void disableTextFieldsUI() {
        textNume.setEnabled(false);
        textPrenume.setEnabled(false);
        textCNP.setEnabled(false);
        textNrTel.setEnabled(false);
    }

    private void initializareModelTabelAbonati() {
        jTableAbonati.setModel(controllerCarteDeTelefon.getModelTabelAbonat());
        jTableAbonati.setAutoCreateRowSorter(true);
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
        butonModificare = new javax.swing.JButton();
        butonAnulare = new javax.swing.JButton();
        jLabelReclame = new javax.swing.JLabel();
        jTextFilter = new javax.swing.JTextField();
        jLabelFiltru = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemIesire = new javax.swing.JMenuItem();
        jMenuAbonati = new javax.swing.JMenu();
        jMenuItemAdauga = new javax.swing.JMenuItem();
        jMenuItemStergere = new javax.swing.JMenuItem();
        jMenuItemModificare = new javax.swing.JMenuItem();
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

        butonModificare.setText("Modificare");
        butonModificare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonModificareActionPerformed(evt);
            }
        });

        butonAnulare.setText("Anulare");
        butonAnulare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonAnulareActionPerformed(evt);
            }
        });

        jLabelFiltru.setBackground(java.awt.Color.green);
        jLabelFiltru.setText("Filtru tabel inactiv");

        jMenuFile.setText("File");

        jMenuItemOpen.setText("Open");
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemOpen);

        jMenuItemSave.setText("Save");
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemSave);
        jMenuFile.add(jSeparator1);

        jMenuItemIesire.setText("Iesire");
        jMenuItemIesire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemIesireActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemIesire);

        jMenuBar1.add(jMenuFile);

        jMenuAbonati.setText("Abonati");

        jMenuItemAdauga.setText("Adauga");
        jMenuItemAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdaugaActionPerformed(evt);
            }
        });
        jMenuAbonati.add(jMenuItemAdauga);

        jMenuItemStergere.setText("Stergere");
        jMenuItemStergere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemStergereActionPerformed(evt);
            }
        });
        jMenuAbonati.add(jMenuItemStergere);

        jMenuItemModificare.setText("Modificare");
        jMenuItemModificare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificareActionPerformed(evt);
            }
        });
        jMenuAbonati.add(jMenuItemModificare);

        jMenuBar1.add(jMenuAbonati);

        jMenuHelp.setText("Help");

        jMenuItemInregistrare.setText("Inregistrare");
        jMenuItemInregistrare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInregistrareActionPerformed(evt);
            }
        });
        jMenuHelp.add(jMenuItemInregistrare);
        jMenuHelp.add(jSeparator2);

        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butonAdauga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butonSalavare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butonStergere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butonModificare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butonAnulare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(262, 262, 262))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelReclame, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelFiltru)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFilter)
                                .addGap(262, 262, 262)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFiltru))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butonAdauga)
                    .addComponent(butonSalavare)
                    .addComponent(butonStergere)
                    .addComponent(butonModificare)
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

        if (nume.length() == 0 || prenume.length() == 0) {
            JOptionPane.showMessageDialog(null, "Nume si prenume lipsa");
            throw new RuntimeException("Nume si prenume lipsa");
        }

        if (cnp.length() != 13) {
            JOptionPane.showMessageDialog(null, "CNP Invalid");
            throw new RuntimeException("CNP Invalid");
        }

        NumarTelefon numarTelefon = getNumarTelefonFromString(telefon);

        Abonat abonatSalvat = new Abonat(nume, prenume, cnp, numarTelefon);

        controllerCarteDeTelefon.adaugaAbonat(abonatSalvat);

    }//GEN-LAST:event_butonSalavareActionPerformed

    private void butonStergereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonStergereActionPerformed
        int selectedRow = jTableAbonati.getSelectedRow();
        if (selectedRow != -1) {
            controllerCarteDeTelefon.stergeAbonatSelectat(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Selectie goala");
        }
    }//GEN-LAST:event_butonStergereActionPerformed

    private void jMenuItemInregistrareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInregistrareActionPerformed
        String input = JOptionPane.showInputDialog(null, "Introduceti codul:", "Activare aplicatie",
                JOptionPane.WARNING_MESSAGE);
        if (input.equals("activ123")) {
            isAppFull = true;
            jMenuItemInregistrare.setEnabled(!isAppFull);
            jMenuItemOpen.setEnabled(isAppFull);
            jMenuItemSave.setEnabled(isAppFull);
            JOptionPane.showMessageDialog(null, "Aplicatie inregistrata.");
        } else {
            JOptionPane.showMessageDialog(null, "Cod incorect.");
        }
    }//GEN-LAST:event_jMenuItemInregistrareActionPerformed

    private void jMenuItemIesireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemIesireActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Confirmati iesirea?", "Iesire aplicatie", JOptionPane.YES_NO_OPTION);
        if (result == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItemIesireActionPerformed

    private void butonModificareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonModificareActionPerformed
        int selectedRow = jTableAbonati.getSelectedRow();
        Abonat abonatVechi = controllerCarteDeTelefon.getAbonatAtPosition(selectedRow);
        if (selectedRow != -1) {
            controllerCarteDeTelefon.modificaAbonatSelectat(abonatVechi);
        } else {
            JOptionPane.showMessageDialog(null, "Selectie goala");
        }
    }//GEN-LAST:event_butonModificareActionPerformed

    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(null);

        //check if there is an already running timertask
        if (taskSavetoFile != null) {
            timerSavetoFile.cancel();
            timerSavetoFile.purge();
        }

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            controllerCarteDeTelefon.saveToFile(file);
            //create and assign a new TimerTask to timer
            taskSavetoFile = new TimerTask() {
                @Override
                public void run() {
                    controllerCarteDeTelefon.saveToFile(file);
                    System.out.println("CarteDeTelefon salvata in fisier");
                }

            };
            timerSavetoFile.schedule(taskSavetoFile, 0, 50000);
        }


    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            List<Abonat> loadDatabaseFromFile = controllerCarteDeTelefon.loadDatabaseFromFile(file);

            controllerCarteDeTelefon.setModelInputDataFrom(loadDatabaseFromFile);
            //This is where a real application would open the file.
        }
    }//GEN-LAST:event_jMenuItemOpenActionPerformed

    private void butonAnulareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonAnulareActionPerformed
        // TODO add your handling code here:
        cleanFieldsAfterAdd();
    }//GEN-LAST:event_butonAnulareActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
        // TODO add your handling code here:
        JDialog dlg = new JDialog();
        JTextArea textAreal = new JTextArea("Aplicatie: AgendaTelefonica\nCod Activare: activ123\nAutor: Tafuni Radu\nemail: rtafuni20@yahoo.com", 5, 10);
        textAreal.setColumns(30);
        textAreal.setLineWrap(true);
        textAreal.setPreferredSize(new Dimension(100, 100));
        dlg.add(textAreal);
        dlg.setSize(300, 100);
        dlg.setVisible(true);

    }//GEN-LAST:event_jMenuItemAboutActionPerformed

    private void jMenuItemAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdaugaActionPerformed
        // TODO add your handling code here:
        EnableTextFieldsUI();
    }//GEN-LAST:event_jMenuItemAdaugaActionPerformed

    private void jMenuItemStergereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStergereActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTableAbonati.getSelectedRow();
        if (selectedRow != -1) {
            controllerCarteDeTelefon.stergeAbonatSelectat(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Selectie goala");
        }
    }//GEN-LAST:event_jMenuItemStergereActionPerformed

    private void jMenuItemModificareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificareActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTableAbonati.getSelectedRow();
        Abonat abonatVechi = controllerCarteDeTelefon.getAbonatAtPosition(selectedRow);
        if (selectedRow != -1) {
            controllerCarteDeTelefon.modificaAbonatSelectat(abonatVechi);
        } else {
            JOptionPane.showMessageDialog(null, "Selectie goala");
        }
    }//GEN-LAST:event_jMenuItemModificareActionPerformed

    public void cleanFieldsAfterAdd() {
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
    private javax.swing.JButton butonAdauga;
    private javax.swing.JButton butonAnulare;
    private javax.swing.JButton butonModificare;
    private javax.swing.JButton butonSalavare;
    private javax.swing.JButton butonStergere;
    private javax.swing.JLabel jLabelCNP;
    private javax.swing.JLabel jLabelFiltru;
    private javax.swing.JLabel jLabelNrTel;
    private javax.swing.JLabel jLabelNume;
    private javax.swing.JLabel jLabelPrenume;
    private javax.swing.JLabel jLabelReclame;
    private javax.swing.JMenu jMenuAbonati;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemAdauga;
    private javax.swing.JMenuItem jMenuItemIesire;
    private javax.swing.JMenuItem jMenuItemInregistrare;
    private javax.swing.JMenuItem jMenuItemModificare;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JMenuItem jMenuItemStergere;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable jTableAbonati;
    private javax.swing.JTextField jTextFilter;
    private javax.swing.JTextField textCNP;
    private javax.swing.JTextField textNrTel;
    private javax.swing.JTextField textNume;
    private javax.swing.JTextField textPrenume;
    // End of variables declaration//GEN-END:variables

    private void listenToTableSelection() {
        ListSelectionModel cellSelectionModel = jTableAbonati.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                int selectedRow = jTableAbonati.getSelectedRow();
                if (selectedRow != -1) {
                    Abonat abonatSelectat = controllerCarteDeTelefon.getAbonatAtPosition(selectedRow);
                    EnableTextFieldsUI();
                    textNume.setText(abonatSelectat.getNume());
                    textPrenume.setText(abonatSelectat.getPrenume());
                    textCNP.setText(abonatSelectat.getCnp());
                    textNrTel.setText(abonatSelectat.getTelefon().toString());

                }
            }
        });

    }

    public Abonat getAbonatFromFields() {
        String nume = textNume.getText();
        String prenume = textPrenume.getText();
        String cnp = textCNP.getText();
        String telefon = textNrTel.getText();

        Abonat abonatNou = new Abonat(nume, prenume, cnp, getNumarTelefonFromString(telefon));
        return abonatNou;
    }

    private NumarTelefon getNumarTelefonFromString(String telefon) {
        NumarTelefon numarTelefon = null;

        if (telefon.length() == 10 && (telefon.startsWith("07"))) {
            numarTelefon = new NumarMobil(telefon);
        } else if (telefon.length() == 10 && (telefon.startsWith("02"))) {
            numarTelefon = new NumarFix(telefon);
        } else {
            JOptionPane.showMessageDialog(null, "Numar telefon invalid");
            throw new RuntimeException("Numar telefon invalid");
        }
        return numarTelefon;
    }

}
