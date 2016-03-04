/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHMPackage;

import ModelePackage.Modele;
import DataPackage.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
/**
 *
 * @author Kim
 */
public class DevisListDisplayerPane extends StackPane{
    Button newDevisButton;
    Label devisListLabel;
    Label sortLabel;
    ComboBox sortOptions;
    private final TableView<Processus> devisList;
    TableColumn devisID;
    TableColumn devisName;
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
    private final ObservableList<Processus> data;
    
    public DevisListDisplayerPane() {
        this.data = FXCollections.observableArrayList(Modele.getInstance().getDevisList());
        System.out.println("LISTE DEV "+ data.toString());
        
        this.devisListLabel = new Label("Liste des devis");
        this.devisList = new TableView();
        this.sortLabel = new Label("Trier par :");
        this.sortOptions = new ComboBox();
        this.newDevisButton = new Button("Créer nouveau devis");
        this.hb = new HBox();
        this.vb = new VBox();
        this.allContent = new VBox();
        this.sortContent = new HBox();
        this.sortOptions.getItems().addAll("Tous", "Créé", "Envoyé", "Retourné", "Vérifié", "Transféré");
        this.sortOptions.setValue("Tous");
        //this.sortOptions.setVisibleRowCount(3);
        
        devisID = new TableColumn("Numero");
        devisID.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        devisName = new TableColumn("Projet");
        devisID.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        prospectName = new TableColumn("Prospect");
        prospectName.setCellValueFactory(new PropertyValueFactory<>("idParent"));
        
        clientName = new TableColumn("Client");
        clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        
        creationDate = new TableColumn("Date de création");
        state = new TableColumn("Etat");
        
        note = new TableColumn("Remarque");
        action =new TableColumn("Modifier");
        
        this.devisList.setItems(data);
        devisList.getColumns().addAll(devisID, devisName, prospectName, clientName, state, note, action);
        
        this.hb.getChildren().addAll(sortLabel, sortOptions);
        this.hb.setAlignment(Pos.TOP_RIGHT);
        this.hb.setSpacing(10);

        this.vb.getChildren().addAll(newDevisButton, devisListLabel);
        this.vb.setAlignment(Pos.TOP_LEFT);
        this.vb.setSpacing(10);
        
        this.sortContent.getChildren().addAll(vb, hb);
        this.sortContent.setSpacing(10);
        allContent.setPadding(new Insets(15, 12, 15, 12));
        this.allContent.getChildren().addAll(sortContent, devisList);
        this.getChildren().addAll(allContent);
    }
}
