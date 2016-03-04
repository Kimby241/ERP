/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPackage;

import StatePackage.IState;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Kim
 */
public abstract class Processus implements IProcessus, IState{
    String id;
    String idParent;
    String nom;
    String clientName;
    Map<String, Processus> composants;
    String status;
    
    public Processus (String n, Client c, String parent) {
        this.id = UUID.randomUUID().toString();
        this.nom = n;
        this.idParent = parent;
        this.clientName = c.nom + " - " + c.prenom;
        this.composants = new HashMap<>(0);
    }
    
    @Override
    public List<Processus> getAllComposants() {
        List<Processus> liste = new ArrayList<>();
        for (String mapKey : this.composants.keySet()) {
            System.out.println(this.composants.get(mapKey).getNom());
            liste.add(this.composants.get(mapKey).getComposant(mapKey));
        }
        return liste;
    }
    
    @Override
    public String getID() {
        return this.id;
    }

    public String getId() {
        return id;
    }

    public String getIdParent() {
        return idParent;
    }

    public String getClientName() {
        return clientName;
    }

    public Map<String, Processus> getComposants() {
        return composants;
    }
    
    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public String toString() {
        return "Processus{" + "id=" + id + ", idParent=" + idParent + ", nom=" + nom + ", status=" + status + "}";
    }
    
    public String getStatus() {
        return status;
    }
    
    public void goNextState() {
    }
    
}
