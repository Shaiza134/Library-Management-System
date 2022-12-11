/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package lms;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AdminController implements Initializable {

    @FXML
    private Button MemberB;
    @FXML
    private Button bookB;
    @FXML
    private Button logOutB;
    @FXML
    private Button IssueB;
    @FXML
    private Button ReturnB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleMemberB(ActionEvent event){
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("Member.fxml"));
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void HandleBookB(ActionEvent event)  {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("book.fxml"));
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void handleLogOutB(ActionEvent event) {
        try {
            Parent root2 = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void HandleIssueAction(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("IssueBook.fxml"));
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
    }

    @FXML
    private void HandleReturnAction(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("ReturnBook.fxml"));
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
    }
    
}
