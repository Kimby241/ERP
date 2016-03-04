/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHMPackage;

import DataPackage.ProspectProcessus;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Kim
 */
public class EdditProspectPane {
    Button saveButton;
    Button creerButton;
    Button validerButton;
    Button confirmerButton;
    Button envoyerButton;
    HBox statesBox;
    VBox allContent;
    Label nomProspect;
    Label nomProjet;
    Label nomClient;
    ProspectProcessus item;
    
    public EdditProspectPane(final ProspectProcessus prospect) {
        this.item = prospect;
    }
    
    public void saveChanges() {
        System.out.println("Modification Prospect OK");
        //Stage st = (Stage) this.getScene().getWindow();
        MainScene.getInstance().getROot().prospectTab.refresh();
        //st.close();
    }
}
