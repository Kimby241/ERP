/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePackage;

import StatePackage.IState;
import StatePackage.StateProspectEnum;
import StatePackage.StateProspect;

/**
 *
 * @author Kim
 */
public class StateProspectValide extends StateProspect implements IState{
    @Override
    public String displayState() {
        System.out.println("Prospect validé");
        return(StateProspectEnum.VALIDE.toString());
    }
}
