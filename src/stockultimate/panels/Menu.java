/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockultimate.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Marc-Antoine
 */
public class Menu extends JPanel{
    
    
    JLabel textmenu;
    JButton accueil;
    JButton recherche;
    JButton listeProduits;
    JButton logout;
    Rectangle bordure;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200,600); //To change body of generated methods, choose Tools | Templates.
    }


    public Menu() {
        
        
        this.setBackground(Color.white);
        //bordure = new Rectangle(this.getX()+this.getMaximumSize().width,this.getY(),5,this.getMaximumSize().height,Color.BLACK);
        textmenu = new JLabel("MENU");
        
        accueil = new JButton("Accueil");
        accueil.setBorderPainted(true);
        accueil.setFocusPainted(false);
        accueil.setContentAreaFilled(false);
        
        recherche = new JButton("Rechercher un Produit");
        recherche.setBorderPainted(true);
        recherche.setFocusPainted(false);
        recherche.setContentAreaFilled(false);
        
        listeProduits = new JButton("Liste des Produits");
        listeProduits.setBorderPainted(true);
        listeProduits.setFocusPainted(false);
        listeProduits.setContentAreaFilled(false);
        
        logout = new JButton("Se Déconnecter");
        logout.setBorderPainted(true);
        logout.setFocusPainted(false);
        logout.setContentAreaFilled(false);
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        
         // Panel Menu
        
        
        cont.gridx = 0;
        cont.gridy = 0;
        this.add(textmenu,cont);
        cont.gridx = 0;
        cont.gridy = 1;
        this.add(accueil,cont);
        cont.gridx = 0;
        cont.gridy = 2;
        this.add(recherche,cont);
        cont.gridx = 0;
        cont.gridy = 3;
        this.add(listeProduits,cont);
        cont.gridx = 0;
        cont.gridy = 4;
        this.add(logout,cont);
    }
    
}
