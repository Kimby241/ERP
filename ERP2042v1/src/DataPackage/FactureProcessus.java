/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPackage;

import StatePackage.StateFacture;
import StatePackage.StateFactureCree;
import StatePackage.StateFactureEnvoye;
import StatePackage.StateFacturePaye;
import StatePackage.StateFactureValide;

/**
 *
 * @author Kim
 */
public class FactureProcessus extends Processus implements IProcessus{
    private StateFacture state;
    
    public FactureProcessus(String n, Client c, String p) {
        super(n, c, p);
        this.state = new StateFactureCree();
        status = state.displayState();
        System.out.println("Constructeur FACTURE - ETAT " + status);
    }
    
    @Override
    public String displayState() {
        this.status = this.state.displayState();
        return this.state.displayState();
    }
    
    public void setState(StateFacture st) {
        this.state=st;
    }
 
    public StateFacture getState() {
        return this.state;
    }
    
    @Override
    public void goNextState() {
        System.out.println("Changement Etat :");
        String st = this.displayState();
        switch(st)
        {
            case "CREE":this.setState(new StateFactureEnvoye());break;
            case "ENVOYE":this.setState(new StateFactureValide());break;
            case "VALIDE":this.setState(new StateFacturePaye());break;
            case "PAYE":this.setState(state);break;
        }
        this.status = this.state.displayState();
    }
    
    @Override
    public void add(Processus processus) {
        //Pour l'intant rien
    }
    
    @Override
    public void remove(Processus processus) {
        //Pour l'intant rien
    }
    
    @Override
    public Processus getComposant(String i) {
        return null; ///Pour l'intant rien
    }

}
