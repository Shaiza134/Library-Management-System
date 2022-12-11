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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zahra Maryam
 */
public class UserController implements Initializable {

    @FXML
    private Button SearchB;
    @FXML
    private Button IssueBookB;
    @FXML
    private Button ReturnB;
    @FXML
    private Button LogOutB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleSearchAction(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("Search.fxml"));
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
    }

    @FXML
    private void HandleIssueAction(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("IssueBookUser.fxml"));
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
    }

    @FXML
    private void HandleReturnAction(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("RetrunUser.fxml"));
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
    }

    @FXML
    private void HandleLogOutAction(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
    }
    
}
