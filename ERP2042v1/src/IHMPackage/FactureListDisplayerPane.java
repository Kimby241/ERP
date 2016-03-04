/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHMPackage;

import ModelePackage.Modele;
import DataPackage.Processus;
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
public class FactureListDisplayerPane extends StackPane{
    Button newFactureButton;
    Label factureListLabel;
    Label sortLabel;
    ComboBox sortOptions;
    TableView facturesList;
    TableColumn factureID;
    TableColumn factureName;
    TableColumn devisName;
    TableColumn clientName;
    TableColumn note;
    TableColumn action;
    TableColumn state;
    VBox allContent;
    HBox sortContent;
    HBox hb;
    VBox vb;
    private final ObservableList<Processus> data;
    
    public FactureListDisplayerPane () {
        this.data = FXCollections.observableArrayList(Modele.getInstance().getFacturesList());
        System.out.println("LISTE FACTURE "+ data.toString());
        
        this.factureListLabel = new Label("Liste des factures");
        this.facturesList = new TableView();
        this.sortLabel = new Label("Trier par :");
        this.sortOptions = new ComboBox();
        this.newFactureButton = new Button("Créer nouvelle facture");
        
        this.hb = new HBox();
        this.vb = new VBox();
        this.allContent = new VBox();
        this.sortContent = new HBox();
        this.sortOptions.getItems().addAll("Tous", "Créée", "Envoyée", "Validée", "Payée");
        this.sortOptions.setValue("Tous");
        
        factureID = new TableColumn("Numero");
        factureID.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        factureName = new TableColumn("Facture");
        factureName.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        devisName = new TableColumn("Devis");
        devisName.setCellValueFactory(new PropertyValueFactory<>("idParent"));
        state = new TableColumn("Etat");
        
        clientName = new TableColumn("Client");
        clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        
        note = new TableColumn("Remarque");
        action =new TableColumn("Modifier");
        
        this.facturesList.setItems(data);
        facturesList.getColumns().addAll(factureID, factureName, devisName, clientName, state, action);
        
        this.hb.getChildren().addAll(sortLabel, sortOptions);
        this.hb.setAlignment(Pos.TOP_RIGHT);
        this.hb.setSpacing(10);

        this.vb.getChildren().addAll(newFactureButton, factureListLabel);
        this.vb.setAlignment(Pos.TOP_LEFT);
        this.vb.setSpacing(10);
        
        this.sortContent.getChildren().addAll(vb, hb);
        this.sortContent.setSpacing(10);
        allContent.setPadding(new Insets(15, 12, 15, 12));
        this.allContent.getChildren().addAll(sortContent, facturesList);
        this.getChildren().addAll(allContent);
    }
}
