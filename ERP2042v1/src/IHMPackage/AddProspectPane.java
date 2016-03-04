/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHMPackage;

import ModelePackage.Modele;
import DataPackage.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
/**
 *
 * @author Kim
 */
public class AddProspectPane extends StackPane{
    ComboBox<Project> projectList;
    Button saveButton;
    Label projectListLabel;
    Label prospectNameLabel;
    Label clientLabel;
    Label noteLabel;
    ComboBox<Client> clientList;
    TextField prospectNameField;
    VBox allContent;
    
    public void saveProspect() {
        System.out.println("Enregistrement OK");
        System.out.println("PROSPECT : " + projectList.getValue().getNom());
        Modele.getInstance().addProspect(TypeProcessus.PROSPECT, prospectNameField.getText(), clientList.getValue(), projectList.getValue().getId());
        System.out.println("Liste Prospects -- " + Modele.getInstance().getProspectsList().toString());
        Stage st = (Stage) this.getScene().getWindow();
        MainScene.getInstance().getROot().prospectTab.refresh();
        st.close();
    }

    public AddProspectPane() {
        System.out.println("DEBUT Constructeur");
        projectListLabel  = new Label("Sélectionner project :");
        prospectNameLabel = new Label("Nom du prospect :");
        clientLabel = new Label("Sélectionner client :");
        noteLabel = new Label("Remarque :");
        prospectNameField = new TextField();    
        saveButton = new Button("Enregistrer");
        allContent = new VBox();
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveProspect();
            }
        });
        clientList  = new ComboBox<>();
        clientList.setEditable(true);
        clientList.setConverter(new StringConverter<Client>() {
            @Override
            public String toString(Client client) {
              if (client == null){
                return "";
              } else {
                return client.getNom() + " - " + client.getPrenom();
              }
            }
            
            @Override
            public Client fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        clientList.getItems().addAll(Modele.getInstance().getClientList());
        
        
        projectList = new ComboBox<>();
        projectList.setEditable(true);
        projectList.setConverter(new StringConverter<Project>() {
            @Override
            public String toString(Project projet) {
              if (projet == null){
                return "";
              } else {
                return projet.getNom();
              }
            }
            
            @Override
            public Project fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        projectList.getItems().addAll(Modele.getInstance().getProjectList());
        
        allContent.setPadding(new Insets(20, 20, 20, 20));
        allContent.setAlignment(Pos.CENTER);
        this.allContent.getChildren().addAll(prospectNameLabel, prospectNameField, projectListLabel, projectList, clientLabel, clientList, saveButton);
        this.getChildren().addAll(allContent);
        
        System.out.println("FIN Constructeur");
    }  
}
