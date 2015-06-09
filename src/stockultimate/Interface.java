/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockultimate;

import stockultimate.panels.Rectangle;
import stockultimate.panels.ImageCanvas;
import stockultimate.panels.Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

/**
 *
 * @author p1403886
 */
public class Interface extends JFrame implements ActionListener {

    // Liste des Panels
    JPanel panneau;
    JPanel login;
    Menu menu;
    JPanel mainPane;
    
    // Liste des attributs 
    JTextField pseudo;
    JTextField password;
    
    JButton connect;
    JComponent fond;
    

    public Interface() {

        this.setTitle("StockUltimate");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        initialisation();
        
        // Liste des Listeners
        
        //connect.addActionListener(this);
    }

    public void initialisation() {
        
        panneau = new JPanel(); // Affichage principal
                
        mainPane = new JPanel(); // Affichage du contenu
        
        mainPane.setLayout(new GridBagLayout());
        mainPane.setMaximumSize(new Dimension(800,500));
        
        menu = new Menu();
        
        login = new JPanel();
        
        GridBagConstraints cont = new GridBagConstraints();
        //cont.fill = GridBagConstraints.FIRST_LINE_START;
        
        
        cont.gridx = 0;
        cont.gridy = 0;
        cont.gridheight = 500;
        cont.gridwidth = 1;
        mainPane.add(menu,cont);
        
        fond = new ImageCanvas(1000, 700, "magasin03.jpg");
        Rectangle rect = new Rectangle(100, 100, 800, 500,  Color.white);
        
         //Panel panneau
        panneau.setLayout(new OverlayLayout(panneau));
        panneau.add(mainPane);
        panneau.add(rect);
        panneau.add(fond);
        
        panneau.setComponentZOrder(rect, 1);
        panneau.setComponentZOrder(mainPane, 0);
             
        
//        displayLogin();
       // displayMenu();

     
        this.setContentPane(panneau);
        this.pack();
    }

    public void displayLogin(){
        
        pseudo = new JTextField("pseudo");
        password = new JTextField("password");
        connect = new JButton("CONNECT");
        
        
        GridBagConstraints contr = new GridBagConstraints();
        contr.fill = GridBagConstraints.BOTH;
        
         // Panel login
        login.setLayout(new GridBagLayout());
        
        contr.gridx = 0;
        contr.gridy = 0;
        login.add(pseudo,contr);
        contr.gridx = 0;
        contr.gridy = 1;
        login.add(password,contr);
        contr.gridx = 0;
        contr.gridy = 2;
        login.add(connect,contr);
        
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
