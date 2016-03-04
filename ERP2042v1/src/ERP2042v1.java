/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import IHMPackage.LoginPane;
//import IHMPackage.MainScreenPane;
import IHMPackage.*;
import DataPackage.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kim
 */
public class ERP2042v1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        LoginPane startpage = new LoginPane(primaryStage);
        Scene logScene = new Scene(startpage, 650, 600);
        primaryStage.setTitle("ERP 2042");
        primaryStage.setScene(logScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
