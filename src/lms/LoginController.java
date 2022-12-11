/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package lms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zahra Maryam
 */
public class LoginController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button loginB;
    @FXML
    private Button exitB;
    @FXML
    private Label invalidL;
    @FXML
    private TextField tf1;
    @FXML
    private PasswordField PasswordField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    String s = "Admin";
    @FXML
    public void HandleLoginButton(ActionEvent e) throws IOException{
        if(tf1.getText().equals("ADMIN") && PasswordField.getText().equals("123")){
            Parent root2 = FXMLLoader.load(getClass().getResource(s + ".fxml"));
            Stage stage1 = (Stage)((Node)e.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
        } 
        if(tf1.getText().equals("User")&& PasswordField.getText().equals("123")){
            Parent root2 = FXMLLoader.load(getClass().getResource("User.fxml"));
            Stage stage1 = (Stage)((Node)e.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
        }
                else {
            invalidL.setText("Invalid username or password!");
        }        
    }
    @FXML
    public void HandleExitButton(ActionEvent e){
        System.exit(0);
    }
    
}
