/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPackage;

import StatePackage.StateProspectValide;
import StatePackage.StateProspectEnvoye;
import StatePackage.StateProspectCree;
import StatePackage.StateProspectConfirme;
import StatePackage.StateProspect;

/**
 *
 * @author Kim
 */
public class ProspectProcessus extends Processus implements IProcessus{
    Client client;
    private StateProspect state;
    
    public ProspectProcessus(String n, Client c, String p) {
        super(n, c, p);
        this.state = new StateProspectCree();
        status = state.displayState();
        this.client = c;
        System.out.println("Constructeur PROSPECT - ETAT " + status);
    }
    
    public void setState(StateProspect st) {
        this.state=st;
    }
 
    public StateProspect getState() {
        return this.state;
    }

    @Override
    public String displayState() {
        this.status = this.state.displayState();
        return this.state.displayState();
    }
    
    @Override
    public void goNextState() {
        System.out.println("Changement Etat :");
        String st = this.displayState();
        switch(st)
        {
            case "CREE":this.setState(new StateProspectValide());break;
            case "VALIDE":this.setState(new StateProspectConfirme());break;
            case "CONFIRME":this.setState(new StateProspectEnvoye());break;
            case "ENVOYE":this.setState(state);break;
        }
        this.status = this.state.displayState();
    }
    
    @Override
    public void add(Processus devis) {
        this.composants.put(devis.id, devis);
    }
    
    @Override
    public void remove(Processus devis) {
        this.composants.remove(devis.id);
    }
    
    @Override
    public Processus getComposant(String id) {
        return this.composants.get(id);
    }
}
