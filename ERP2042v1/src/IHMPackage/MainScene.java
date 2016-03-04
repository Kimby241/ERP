/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHMPackage;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Kim
 */
public class MainScene extends Scene{
    private static MainScene INSTANCE = null;
    MainScreenPane root;
    
    private MainScene() {
        //root = MainScreenPane getInstance();
        super(MainScreenPane.getInstance(), 650, 600);
        root = MainScreenPane.getInstance();
        
    }
    
    public static synchronized MainScene getInstance()
    {			
        if(INSTANCE == null)
        { 
            INSTANCE = new MainScene();	
        }
        return INSTANCE;
    }

    public MainScreenPane getROot() {
        return root;
    }
}