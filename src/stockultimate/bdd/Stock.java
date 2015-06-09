/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockultimate.bdd;

import java.util.ArrayList;

/**
 *  Stock est la classe qui contient la liste des Produits
 *  Elle dispose d'un attribut, la liste des produits existant
 *      
 * 
 *  @see Categorie
 *  @see Produit
 *  
 * 
 * @author Marc-Antoine FERNANDES
 * @version 1.0
 */

public class Stock {

    private ArrayList<Produit> listProduit;

    /**
     * Constructeur de Stock
     * 
     * Ne prend pas de paramètre et initialise une nouvelle liste de produits.
     */
    public Stock() {
        listProduit = new ArrayList<>();
    }

    /**
     * Permet de rajouter une quantité d'unité à un produit
     *
     * @param p le produit
     * @param quantite le nombre d'unité à ajouter
     */
    public void addStock(Produit p, int quantite) {

        int val = listProduit.indexOf(p);

        if (val == -1 || quantite <= 0) {
            return;
        }

        listProduit.get(val).add(quantite);
    }

    /**
     * Permet d'enlever une quantité d'unité à un produit
     *
     * @param p le produit
     * @param quantite le nombre d'unité à enlever
     */
    public void removeStock(Produit p, int quantite) {
        int val = listProduit.indexOf(p);

        if (val == -1 || quantite <= 0) {
            return;
        }

        listProduit.get(val).remove(quantite);
    }

    /**
     * Ajoute un nouveau produit au stok
     *
     * @param p Nouveau produit
     */
    public void addProduit(Produit p) {

        listProduit.add(p);
    }

    /**
     * Enleve un produit du stock
     *
     * @param p le produit à enlever
     */
    public void removeProduit(Produit p) {
        
        listProduit.remove(p);
    }

    /**
     * Retourne la liste des produits qui sont en alerte niveau bas de stock
     *
     * @return une liste de produit
     */
    public ArrayList<Produit> getLowStock() {

        ArrayList<Produit> tmp = new ArrayList<>();

        for (Produit listProduit1 : listProduit) {
            if (listProduit1.isLow()) {
                tmp.add(listProduit1);
            }
        }

        return tmp;
    }
}
