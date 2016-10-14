/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.rtaf.agendatelefonica.view;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author rtafuni
 */
public class SplashScreen extends JFrame {

    File file = new File("pictures/splash.jpg");
    private final ImageIcon imagineSpashScreen = new ImageIcon(file.toString());
    private final JLabel labelImagineSpashScreen = new JLabel(imagineSpashScreen);
    private final JLabel labelAutor = new JLabel("Tafuni Radu");

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(null);
        labelImagineSpashScreen.setBounds(20, 20, 300, 187);
        labelAutor.setBounds(215, 300, 150, 20);
        add(labelImagineSpashScreen);
        add(labelAutor);

    }

}
