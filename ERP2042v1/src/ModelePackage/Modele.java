/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelePackage;

import DataPackage.Client;
import DataPackage.Processus;
import DataPackage.ProcessusFactory;
import DataPackage.Project;
import DataPackage.TypeProcessus;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author Kim
 */
public class Modele {
    private static Modele INSTANCE = null;
    final private ProcessusFactory fabrique;
    final private Map<String, Project> projets;
    final private Map<String, Client> clients;
    final private Map<String, String> utilisateurs;
    
    private Modele() {
        this.fabrique = new ProcessusFactory();
        this.clients = new HashMap<>();
        this.utilisateurs = new HashMap<>();
        this.projets = new HashMap<>();
        init();
    }
    
    public void init() {
        final Client client1 = new Client("Dupont", "Gautier");
        final Client client2 = new Client("Lola", "Marise");
        
        final Project p1 = new Project("projet 1");
        final Project p2 = new Project("projet 2");
        
        final Processus pro1 = fabrique.creerProcessus(TypeProcessus.PROSPECT, "prospect 1 - projet 1", client1, p1.getID());
        final Processus pro2 = fabrique.creerProcessus(TypeProcessus.PROSPECT, "prospect 2 - projet 1", client2, p1.getID());        
        final Processus pro3 = fabrique.creerProcessus(TypeProcessus.PROSPECT, "prospect 3 - projet 2", client1, p2.getID());
        final Processus pro4 = fabrique.creerProcessus(TypeProcessus.PROSPECT, "prospect 4 - projet 2", client2, p2.getID());
        
        pro3.goNextState();
        pro4.goNextState();
        pro4.goNextState();
        pro4.goNextState();
        
        Processus dev1 = fabrique.creerProcessus(TypeProcessus.DEVIS, "devis 1 - prospect 1 - projet 1", client1, pro1.getID());
        Processus dev2 = fabrique.creerProcessus(TypeProcessus.DEVIS, "devis 2 - prospect 1 - projet 1", client2, pro1.getID());
        Processus dev3 = fabrique.creerProcessus(TypeProcessus.DEVIS, "devis 3 - prospect 3 - projet 2", client2, pro3.getID());
        
        Processus fac1 = fabrique.creerProcessus(TypeProcessus.FACTURE, "facture 1", client1, dev1.getID());
        Processus fac2 = fabrique.creerProcessus(TypeProcessus.FACTURE, "facture 2", client1, dev3.getID());

        clients.put(client2.getId(), client2);
        clients.put(client1.getId(), client1);
        
        utilisateurs.put("u1", "user1");
        utilisateurs.put("u2", "user2");
        
        dev1.add(fac1); dev3.add(fac2);
        pro1.add(dev1); pro1.add(dev2); pro3.add(dev3);
        p1.add(pro1); p1.add(pro2); p2.add(pro3); p1.add(pro4);
        
        projets.put(p1.getID(), p1);
        projets.put(p2.getID(), p2);
    }
    
    public Map<String, Project> getProjectsMap() {
        return this.projets;
    }
    
    public List<Project> getProjectList() {
        List<Project> liste = new ArrayList<>(0);
        
        for (String mapKey : projets.keySet()) {
            liste.add(projets.get(mapKey));
        } 
        return liste;
    }
    
    public List<Client> getClientList() {
        List<Client> liste = new ArrayList<>(0);
        for (String mapKey : clients.keySet()) {
            liste.add(clients.get(mapKey));
        } 
        return liste;
    }
    
    public List<Processus> getProspectsList() {
        List<Processus> liste = new ArrayList<>(0);
        
        for (String mapKey : projets.keySet()) {
            liste.addAll(projets.get(mapKey).getAllComposants());
        } 
        return liste;
    }
    
    public List<Processus> getProspectsList(String pattern) {
        if (Objects.isNull(pattern)) return getProspectsList();
        List<Processus> liste = new ArrayList<>(0);
        List<Processus> liste2 = new ArrayList<>(0);
        for (String mapKey : projets.keySet()) {
            liste.addAll(projets.get(mapKey).getAllComposants());
        }
        for (Processus temp : liste) {
            if(temp.getStatus().equals(pattern)) {
                liste2.add(temp);
            }
	}
        return liste2;
    }
    
    public List<Processus> getDevisList() {
        List<Processus> prospects = getProspectsList();
        Map<String, Processus> devis = new HashMap<>(0);
        List<Processus> liste = new ArrayList<>(0);
        for (Processus prospect : prospects) {
            devis.putAll(prospect.getComposants());
        }
        for (String mapKey : devis.keySet()) {
            liste.add(devis.get(mapKey));
        } 
        System.out.println("DEVIS MODEL -- " + devis.toString());
        return liste;
    }
    
    public List<Processus> getFacturesList () {
        List<Processus> devis = getDevisList();
        Map<String, Processus> factures = new HashMap<>(0);
        List<Processus> liste = new ArrayList<>(0);
        for (Processus prospect : devis) {
            factures.putAll(prospect.getComposants());
        }
        for (String mapKey : factures.keySet()) {
            liste.add(factures.get(mapKey));
        } 
        System.out.println("FACTURE MODEL -- " + devis.toString());
        return liste;
    }
    
    public void addProspect(TypeProcessus type, String nomProspect, Client client, String idParent) {
        Processus pro1 = null;
        pro1 = fabrique.creerProcessus(type, nomProspect, client, idParent);
        projets.get(idParent).getProspects().put(pro1.getID(), pro1);
    }
    
    public static synchronized Modele getInstance()
    {			
        if(INSTANCE == null)
        { 
            INSTANCE = new Modele();	
        }
        return INSTANCE;
    }
}
