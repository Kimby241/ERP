/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePackage;

/**
 *
 * @author Kim
 */
public class StateDevisEnvoye extends StateDevis implements IState{
    @Override
    public String displayState() {
        System.out.println("Devis envoyé");
        return(StateDevisEnum.ENVOYE.toString());
    }
}
