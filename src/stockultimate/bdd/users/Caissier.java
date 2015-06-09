/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stockultimate.bdd.users;

/**
 *  Caissier est la classe fille de Personne
 *  Elle ne dispose pas d'information en plus que sa mère
 *      
 * 
 *  @see Personne
 *  
 * 
 * @author Marc-Antoine FERNANDES
 * @version 1.0
 */
public class Caissier extends Personne{
    
    
    public Caissier(String nom, String prenom, String mdp) {
        super(nom,prenom,mdp);
        
    }
}
