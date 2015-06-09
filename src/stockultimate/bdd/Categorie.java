/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stockultimate.bdd;

/**
 *  categorie est la classe qui contient un nom de catégorie.
 *  Elle permet de classifier les produits afin de faciliter la recherche
 *      
 * 
 *  @see Produit
 *  @see Stock
 *  
 * @author Marc-Antoine FERNANDES
 * @version 1.0
 */

public class Categorie {

    /**
     * Constructeur de Catégorie
     * 
     * @param nom_cat
     */
    public Categorie(String nom_cat) {
        this.nom_cat = nom_cat;
    }
    
    
    private String nom_cat;

    /**
     * Renvoie le nom de la catégorie
     *
     * @return un String avec le nom de catégorie
     */
    public String getNom_cat() {
        return nom_cat;
    }

    /**
     * Met à jour le nom de la catégorie
     *
     * @param nom_cat nouveau nom de la catégorie
     */
    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

}
