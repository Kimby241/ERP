/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPackage;

import java.util.UUID;
/**
 *
 * @author Kim
 */
public class Client {
    String id;
    String nom;
    String prenom;
    
    public Client(String n, String p) {
        this.id = UUID.randomUUID().toString();
        this.nom = n;
        this.prenom = p;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
}
