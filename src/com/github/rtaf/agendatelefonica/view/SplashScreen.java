/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.rtaf.agendatelefonica.view;

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

    private final Path path = Paths.get("pictures/splash.jpg");
    private final Path absolutePath = path.toAbsolutePath();
    private final ImageIcon imagineSpashScreen = new ImageIcon(absolutePath.toString());
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
        System.out.println(absolutePath);
        add(labelImagineSpashScreen);
        add(labelAutor);
        labelAutor.setBounds(215, 210, 150, 20);
    }

}
