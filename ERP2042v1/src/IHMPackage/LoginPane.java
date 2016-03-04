/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHMPackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Kim
 */
public class LoginPane extends StackPane{
    VBox topLayout;
    Button loginButton;
    Label userLabel;
    Label vide;
    TextField userField;
    
    
    public LoginPane (final Stage primaryStage) {
        this.topLayout = new VBox();
        this.loginButton = new Button("Connexion");
        this.userField = new TextField("test1_j");
        this.vide = new Label(" ");
        this.userLabel = new Label("Utilisateur (test1_j):");
        topLayout.getChildren().add(userLabel);
        topLayout.getChildren().add(vide);
        topLayout.getChildren().add(userField);
        topLayout.getChildren().add(loginButton);
        topLayout.setMaxWidth(150);
        topLayout.setAlignment(Pos.CENTER);
        getChildren().add(topLayout);
        //this.loginButton.setOnAction(e -> primaryStage.setScene(MainScene.getInstance()));
        this.loginButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World! test");
                primaryStage.setScene(MainScene.getInstance());
            }
        });
        
    }
}
