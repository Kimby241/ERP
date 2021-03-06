/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHMPackage;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Kim
 */
public class MainScreenPane extends BorderPane{
    private static MainScreenPane INSTANCE = null;
    HeaderPane header;
    TabPane root;
    ProspectTab prospectTab;
    DevisTab devisTab;
    FacturesTab factureTab;
    
    private MainScreenPane() {
        this.root = new TabPane();
        this.header = new HeaderPane();
        prospectTab = new ProspectTab();
        devisTab = new DevisTab();
        factureTab = new FacturesTab();
        root.getTabs().addAll(prospectTab, devisTab, factureTab);
        this.setCenter(this.root);
        this.setTop(this.header);
    }
    
    public static synchronized MainScreenPane getInstance()
    {			
        if(INSTANCE == null)
        { 
            INSTANCE = new MainScreenPane();	
        }
        return INSTANCE;
    }
}
