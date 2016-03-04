/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPackage;

/**
 *
 * @author Kim
 */
public class ProcessusFactory {
    public ProcessusFactory () {
        //rien
    }
    
    public Processus creerProcessus(TypeProcessus type, String n, Client c, String p)
    {
        Processus process = null;
        switch(type)
        {
            case PROSPECT:process = new ProspectProcessus(n, c, p);break;
            case DEVIS:process = new DevisProcessus(n, c, p);break;
            case FACTURE:process = new FactureProcessus(n, c, p);break;
        }
        return process;
    }    
}