/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package lms;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zahra Maryam
 */
public class RetrunUserController implements Initializable {

    @FXML
    private TextField TFName;
    @FXML
    private TextField TFBook;
    @FXML
    private DatePicker TFDate;
    @FXML
    private Button SubmitB;
    @FXML
    private Button CancelB;
    @FXML
    private Button BackB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleSubmitAction(ActionEvent event) {
        if(TFName.getText().equals("") || TFBook.getText().equals("")){
            Alert alt = new Alert(Alert.AlertType.ERROR);
            alt.setTitle("Invalid Fields");
            alt.setContentText("Incorect data in Fields");
        alt.show();
        TFName.setText("");
        TFBook.setText("");
        TFDate.setValue(null);
        }
        else if(!TFDate.getValue().equals(null)){
        {Add();
        TFName.setText("");
        TFBook.setText("");
        TFDate.setValue(null);}
    }
    }

    @FXML
    private void HandleCancelAction(ActionEvent event) {
        TFName.setText("");
        TFBook.setText("");
        TFDate.setValue(null);
        
    }
    private void Add()  {
        String querey = "INSERT INTO `lms`.`return` (`Name`, `Book`, `Date`) VALUES ('"+TFName.getText()+"', '"+TFBook.getText()+"', '"+TFDate.getValue()+"');";
        executeQuerey(querey);
    }

    @FXML
    private void HandleBackAction(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("User.fxml"));
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
    }
    private void executeQuerey(String querey) {
       
       Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(querey);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }   
    
    private Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","Zahra@115");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
}
