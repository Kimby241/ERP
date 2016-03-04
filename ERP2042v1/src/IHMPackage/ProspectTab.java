package IHMPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author Kim
 */
public class ProspectTab extends Tab{
    ProspectListDisplayerPane centerDisplayer;
    Button newProspectButton;
    Label prospectListLabel;
    Label sortLabel;
    ComboBox sortOptions;
    TableView prospectsList;
    TableColumn prospectID;
    TableColumn projectName;
    TableColumn prospectName;
    TableColumn clientName;
    TableColumn creationDate;
    TableColumn note;
    TableColumn action;
    TableColumn state;
    VBox allContent;
    HBox sortContent;
    HBox hb;
    VBox vb;
    Stage newProspectStage;
    AddProspectPane newProspectPane;
    Scene scene1;
    
    public ProspectTab() {
        this.setText("Prospects");
        this.setClosable(false);
        loadDisplayer();
        this.setContent(centerDisplayer);

    }
    
    public void refresh() {
        centerDisplayer.refresh();
    }
    
    public void loadDisplayer() {
        this.centerDisplayer = new ProspectListDisplayerPane();
    }
    
    public void loadAddForm() {
        
    }
    
    public void loadEditForm() {
        
    }
    
    public void ButtonClicked(ActionEvent e)
    {
        if (e.getSource()==newProspectButton)
            newProspectStage.showAndWait();
        else
            newProspectStage.close();
    }
}
