/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockultimate.bdd;

import java.util.Date;

/**
 *  Produit est la classe qui contient les informations d'un produits
 *  Elle dispose de plusieurs attributs :
 *      - Le numéro unique du produit
 *      - Le nom du produit
 *      - Le nombre d'unité de ce produit en stock
 *      - Le nombre d'unité où une alerte doit être lancé
 *      - La date du dernier ravitaillement
 *      - La catégorie du produit
 *      
 * 
 *  @see Categorie
 *  @see Stock
 *  
 * 
 * @author Marc-Antoine FERNANDES
 * @version 1.0
 */

public class Produit {

    private static int nb_produits = 0;

    private int num;
    private String nom;
    private int nbre_produit;
    private int low_alert;
    private Date last_in;

    private Categorie cat;

    /**
     * @param nom
     * @param cat
     * 
     * @see Produit#Produit(java.lang.String, int, int, stockultimate.bdd.Categorie) 
     */
    public Produit(String nom, Categorie cat) {
        this(nom, 0, 1, cat);
    }

    /**
     * @param nom
     * @param nbre_produit
     * @param cat
     * 
     * @see Produit#Produit(java.lang.String, int, int, stockultimate.bdd.Categorie) 
     */
    public Produit(String nom, int nbre_produit, Categorie cat) {
        this(nom, nbre_produit, 1, cat);
    }

    /**
     * Constructeur de la classe produit
     * Les autres constructeurs mettent des valeurs par défaut dans les champs 'nbre_produit'
     * et le niveau d'alerte 'low_alert'
     *
     * @param nom
     * @param nbre_produit
     * @param low_alert
     * @param cat
     */
    public Produit(String nom, int nbre_produit, int low_alert, Categorie cat) {
        nb_produits++;

        this.num = nb_produits;
        this.nom = nom;
        this.nbre_produit = nbre_produit;
        this.low_alert = low_alert;
        last_in = new Date();
        this.cat = cat;
    }

    /**
     *  Renvoie le Nom du produit
     * 
     * @return un String contenant le nom du produit
     */
    public String getNom() {
        return nom;
    }

    /**
     * Met à jour le nom du produit
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *  Renvoie le nombre d'unité de ce produit en stock
     * 
     * @return le nombre d'unité
     */
    public int getNbre_produit() {
        return nbre_produit;
    }

    /**
     * Permet de récupérer la valeur d'alerte de stock bas
     *
     * @return la valeur pour laquelle le logiciel produira une alerte
     */
    public int getLow_alert() {
        return low_alert;
    }

    /**
     * Règle le niveau d'alerte de bas niveau de stock
     *
     * @param low_alert le nombre d'unité minimum
     */
    public void setLow_alert(int low_alert) {
        this.low_alert = low_alert;
    }

    /**
     * Renvoie la catégorie du produit
     *
     * @return une Catégorie
     */
    public Categorie getCat() {
        return cat;
    }

    /**
     * Assigne/Met à jour une catégorie au produit
     *
     * @param cat une Categorie
     */
    public void setCat(Categorie cat) {
        this.cat = cat;
    }

    /**
     * Ajouter un certain nombre d'unité au stock
     *
     * @param quantite
     */
    public void add(int quantite) {
        quantite = Math.abs(quantite);

        nbre_produit += quantite;
    }

    /**
     * Enlever un certain nombre d'unité du stock
     * Ne peut pas descendre en-dessous de 0.
     *
     * @param quantite
     */
    public void remove(int quantite) {
        quantite = Math.abs(quantite);

        if (nbre_produit < quantite) {
            nbre_produit = 0;
        } else {
            nbre_produit -= quantite;
        }
    }

    /**
     * Renvoie si le produit est en "rupture de stock"
     *
     * @return vrai ou faux
     */
    public boolean isLow() {
        return nbre_produit <= low_alert;
    }

}
