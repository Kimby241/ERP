/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHMPackage;

import StatePackage.StateProspectEnum;
import ModelePackage.Modele;
import DataPackage.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
/**
 *
 * @author Kim
 */
public class ProspectListDisplayerPane extends StackPane{
    Button newProspectButton;
    Button filterButton;
    Button displayAllButton;
    Label prospectListLabel;
    Label sortLabel;
    ComboBox<StateProspectEnum> sortOptions;
    private final TableView<Processus> prospectsList;
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
    final Stage newProspectStage;
    final AddProspectPane newProspectPane;
    Scene scene1;
    ObservableList<Processus> data;
    
    public ProspectListDisplayerPane() {
        newProspectStage = new Stage();
        newProspectPane = new AddProspectPane();
        scene1 = new Scene(newProspectPane, 300, 200);
        this.hb = new HBox();
        this.vb = new VBox();
        this.allContent = new VBox();
        this.sortContent = new HBox();
        prospectID = new TableColumn("Numéro");
        this.prospectListLabel = new Label("Liste des prospects");
        this.prospectsList = new TableView();
        this.sortLabel = new Label("Trier par :");        
        this.sortOptions = new ComboBox<>();
        this.sortOptions.setEditable(true);
        
        projectName = new TableColumn("Projet");
        prospectName = new TableColumn("Prospect");
        clientName = new TableColumn("Client");
        creationDate = new TableColumn("Date de création");
        state = new TableColumn("Etat");
        action =new TableColumn("Modifier");
        this.newProspectButton = new Button("Créer nouveau prospect");
        this.filterButton = new Button("Filter");
        this.displayAllButton = new Button("Tout Afficher");
        this.data = FXCollections.observableArrayList(Modele.getInstance().getProspectsList());
        loadContent();
    }
    
    public void loadContent() {
        newProspectStage.initModality(Modality.APPLICATION_MODAL);
        newProspectStage.setTitle("Créer nouveau prospect");
        System.out.println("PROSPECTS " +data.toString());
        this.prospectsList.setEditable(true);
        newProspectButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Ajouter nouveau prospect");
                newProspectStage.setScene(scene1);
                newProspectStage.showAndWait();
            }
        });
        
        filterButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Filter sur " + sortOptions.valueProperty().getValue().toString());
                filter(sortOptions.valueProperty().getValue().toString());
            }
        });
        
        displayAllButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Tout afficher");
                refresh();
            }
        });
        this.sortOptions.getItems().addAll(StateProspectEnum.values());
        //this.sortOptions.setValue("Tous");
        prospectID.setCellValueFactory(new PropertyValueFactory<>("id"));        
        projectName.setCellValueFactory(new PropertyValueFactory<>("idParent"));
        prospectName.setCellValueFactory(new PropertyValueFactory<>("nom"));
        clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        state.setCellValueFactory(new PropertyValueFactory<>("status"));
        this.prospectsList.setItems(data);
        prospectsList.getColumns().addAll(prospectID, prospectName, clientName, projectName, state/*, creationDate, note, action*/);        
        this.hb.getChildren().addAll(sortLabel, sortOptions, filterButton);
        this.hb.setAlignment(Pos.TOP_RIGHT);
        this.hb.setSpacing(10);       
        this.vb.getChildren().addAll(newProspectButton, prospectListLabel);
        this.vb.setAlignment(Pos.TOP_LEFT);
        this.vb.setSpacing(10);
        this.sortContent.getChildren().addAll(vb, hb);
        this.sortContent.setSpacing(10);
        allContent.setPadding(new Insets(15, 12, 15, 12));
        this.allContent.getChildren().addAll(sortContent, prospectsList);
        this.getChildren().addAll(allContent);
    }
    
    public void refresh() {
        prospectsList.getItems().clear();
        data = FXCollections.observableArrayList(Modele.getInstance().getProspectsList());
        prospectsList.getItems().addAll(data);
    }
    
    public void filter(String pattern) {
        prospectsList.getItems().clear();
        data = FXCollections.observableArrayList(Modele.getInstance().getProspectsList(pattern));
        prospectsList.getItems().addAll(data);
    }
}
