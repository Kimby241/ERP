/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPackage;

import java.util.ArrayList;
import java.util.UUID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Kim
 */
public class Project implements IProcessus{
    String id;
    String nom;
    Map<String, Processus> prospects;
    
    public Project(String n) {
        this.nom = n;
        this.id = UUID.randomUUID().toString();
        this.prospects = new HashMap<>();
        System.out.println("Constructeur project");
    }
    
    @Override
    public void add(Processus prospect) {
        prospects.put(prospect.id, prospect);
    }
    
    @Override
    public void remove(Processus prospect) {
        this.prospects.remove(prospect.id);
    }
    
    @Override
    public Processus getComposant(String id) {
        return prospects.get(id);
    }
    
    @Override
    public String getNom() {
        return this.nom;
    }
    
    @Override
    public String getID() {
        return this.id;
    }
    
    @Override
    public List<Processus> getAllComposants() {
        List<Processus> liste = new ArrayList<>();
       
        for (String mapKey : this.prospects.keySet()) {
            Processus p = this.prospects.get(mapKey);
            liste.add(p);
        }
        return liste;
    }

    public String getId() {
        return id;
    }

    public Map<String, Processus> getProspects() {
        return prospects;
    }
}
