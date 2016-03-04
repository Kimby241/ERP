package IHMPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

/**
 *
 * @author Kim
 */
public class HeaderPane extends StackPane{
    HBox header;
    VBox brand;
    Label projectName;
    Label userNameLabel;
    Button logoutButton;
    
    public HeaderPane() {
        this.setMinHeight(65);
        this.header = new HBox();
        this.header.setAlignment(Pos.CENTER_RIGHT);
        header.setSpacing(10);
        this.userNameLabel = new Label("Dupont Francis");
        this.logoutButton = new Button("Déconnexion");
        this.header.getChildren().addAll(userNameLabel, logoutButton);
        
        this.brand = new VBox();
        this.projectName = new Label("ERP 2042");
        this.projectName.setFont(new Font("Bauhaus 93", 20));
        this.brand.setAlignment(Pos.CENTER_LEFT);
        brand.setSpacing(10);
        this.brand.getChildren().addAll(projectName, new Label("04/03/2016"));
        
        this.getChildren().addAll(this.brand, this.header);
    }
}
