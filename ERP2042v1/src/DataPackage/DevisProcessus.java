/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPackage;

import StatePackage.StateDevis;
import StatePackage.StateDevisCree;
import StatePackage.StateDevisEnvoye;
import StatePackage.StateDevisRetourne;
import StatePackage.StateDevisValide;
import StatePackage.StateDevisVerifie;

/**
 *
 * @author Kim
 */
public class DevisProcessus extends Processus implements IProcessus{
    private StateDevis state;
    
    
    public DevisProcessus(String n, Client c, String p) {
        super(n, c, p);
        this.state = new StateDevisCree();
        status = state.displayState();
        System.out.println("Constructeur DEVIS - ETAT " + status);
    }
    
    @Override
    public String displayState() {
        this.status = this.state.displayState();
        return this.state.displayState();
    }
    
    public void setState(StateDevis st) {
        this.state=st;
    }
 
    public StateDevis getState() {
        return this.state;
    }
    
    @Override
    public void goNextState() {
        System.out.println("Changement Etat :");
        String st = this.displayState();
        switch(st)
        {
            case "CREE":this.setState(new StateDevisEnvoye());break;
            case "ENVOYE":this.setState(new StateDevisRetourne());break;
            case "RETOURNE":this.setState(new StateDevisVerifie());break;
            case "VERIFIE":this.setState(new StateDevisValide());break;
            case "VALIDE":this.setState(state);break;
        }
        this.status = this.state.displayState();
    }
    
    @Override
    public void add(Processus facture) {
        this.composants.put(facture.id, facture);
    }
    
    @Override
    public void remove(Processus facture) {
        this.composants.remove(facture.id);
    }
    
    @Override
    public Processus getComposant(String id) {
        return this.composants.get(id);
    }

}
