/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stockultimate.bdd.users;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Personne est la classe mère de Caissier et de Gestionnaire.
 *  Elle dispose des informations suivantes :
 *      - Un identifiant unique
 *      - Un nom
 *      - Un prénom
 *      - Un mot de passe crypté sous la forme SHA-1(SHA-1(mdp)+"42_1337_42")
 * 
 *  @see Caissier
 *  @see Gestionnaire
 *  
 * 
 * @author Marc-Antoine FERNANDES
 * @version 1.0
 */

public abstract class Personne {
    
    private static int last_num = 0;
    
    
    
    // Attributs propre à une instance
    
    private final int num_personne;
    private String nom;
    private String prenom;
    private String mdp;

    
    /**
     * Constructeur de Personne
     * Prend un prenom, un nom, et mot de passe qui est crypté avant d'être 
     *  enregistré.
     *
     * @param nom
     * @param prenom
     * @param mdp
     */
    public Personne(String nom, String prenom, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        last_num++;
        this.num_personne = last_num;
        this.setMdp(mdp);
    }
    
    
    /**
     *  Renvoie vrai ou faux en fonction de si tmp correspond au mot de passe
     * 
     * @param check_mdp Mot de passe à verifier
     * @return si la personne est identifié
     */
    public boolean login(String check_mdp){
        
        try {
            MessageDigest tmp = MessageDigest.getInstance("SHA-1");
            tmp.reset();
            tmp.update(check_mdp.getBytes("UTF-8"));
            if(Personne.byteToHex(tmp.digest()) == this.mdp)
                return true;
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    /**
     *  Retourne l'identifiant de la personne
     * 
     * @return le numero de la personne
     */
    public int getNum_personne() {
        return num_personne;
    }

    /**
     *  Retourne le nom de la personne
     * 
     * @return un String du nom de la personne
     */
    public String getNom() {
        return nom;
    }

    /**
     *  Retourne le prénom de la personne
     * 
     * @return un String du prénom de la personne
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Met à jour le nom de la personne
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Met à jour le prénom de la personne
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *  Met à jour le mot de passe de la personne
     * 
     * @param mdp Correspond au nouveau mot de passe non crypté
     */
    public void setMdp(String mdp) {
        
        try {
            MessageDigest tmp = MessageDigest.getInstance("SHA-1");
            tmp.reset();
            tmp.update(mdp.getBytes("UTF-8"));
            this.mdp = Personne.byteToHex(tmp.digest());
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    private static String byteToHex(final byte[] hash)
{
    Formatter formatter = new Formatter();
    for (byte b : hash)
    {
        formatter.format("%02x", b);
    }
    String result = formatter.toString();
    formatter.close();
    return result;
}
    
    
    
    
}
