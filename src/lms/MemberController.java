/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package lms;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Zahra Maryam
 */
public class MemberController implements Initializable {

    @FXML
    private TextField TFName;
    @FXML
    private TextField TFAddress;
    @FXML
    private TextField TFPhone;
    @FXML
    private Button AddButton;
    @FXML
    private Button UpdateB;
    @FXML
    private Button RemoveB;
    @FXML
    private TableView<member> tableView;
    @FXML
    private TableColumn<member, String> Col_Name;
    @FXML
    private TableColumn<member, String> Col_Address;
    @FXML
    private TableColumn<member, String> Col_Phone;
    @FXML
    private Button BackB;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            showTable();
        } catch (SQLException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    @FXML
    private void handleAddAction(ActionEvent event) {
        if(TFName.getText().equals("") || TFAddress.getText().equals("") || TFPhone.getText().equals("")){
            Alert alt = new Alert(Alert.AlertType.ERROR);
            alt.setTitle("Invalid Fields");
            alt.setContentText("Incorect data in Fields");
        alt.show();
        TFName.setText("");
        TFAddress.setText("");
        TFPhone.setText("");}
        else{
        Add();
        TFName.setText("");
        TFAddress.setText("");
        TFPhone.setText("");}
    }
    

    @FXML
    private void HandleUpdateAction(ActionEvent event) {
        if(TFName.getText().equals("") || TFAddress.getText().equals("") || TFPhone.getText().equals("")){
            Alert alt = new Alert(Alert.AlertType.ERROR);
            alt.setTitle("Invalid Fields");
            alt.setContentText("Incorect data in Fields");
        alt.show();
        TFName.setText("");
        TFAddress.setText("");
        TFPhone.setText("");}
        else{
        updateRecord();
        TFName.setText("");
        TFAddress.setText("");
        TFPhone.setText("");}
    }

    @FXML
    private void HandleRemoveAction(ActionEvent event) throws SQLException {
        if(TFName.getText().equals("") || TFAddress.getText().equals(TFAddress.getText()) || TFPhone.getText().equals(TFPhone.getText())){
            Alert alt = new Alert(Alert.AlertType.ERROR);
            alt.setTitle("Invalid Fields");
            alt.setContentText("Just Enter Name of Member");
        alt.show();
        TFName.setText("");
        TFAddress.setText("");
        TFPhone.setText("");}
        else{
        deleteButton();
        TFName.setText("");
        TFAddress.setText("");
        TFPhone.setText("");}
    }

          private void updateRecord() {
        try {
            String querey = "UPDATE `lms`.`member` SET `Phone` = '"+TFPhone.getText()+"' WHERE (`Name` = '"+TFName.getText()+"') and (`Address` = '"+TFAddress.getText()+"');";
            executeQuerey(querey);
            showTable();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
          
          private void deleteButton() throws SQLException {
            String querey = "DELETE FROM `lms`.`member` WHERE `Name` = '"+TFName.getText()+"';";
            executeQuerey(querey);
            showTable();
        }
          private void Add()  {
        try {
            String querey = "INSERT INTO `lms`.`member` (`Name`, `Address`, `Phone`) VALUES ('"+TFName.getText()+"', '"+TFAddress.getText()+"', '"+TFPhone.getText()+"');";
            executeQuerey(querey);
            showTable();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

          
    @FXML
    private void HandleBackAction(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
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
     
     private ObservableList<member> getList() throws SQLException{
            ObservableList<member> oblist = FXCollections.observableArrayList();
            Connection con = getConnection();
            String querey = "SELECT * FROM lms.member;";
            Statement ps;
            ResultSet rs;
            ps = con.createStatement();
            rs = ps.executeQuery(querey);
            member mc ;
            while(rs.next()){
               
                    mc = new member(rs.getString("Name"),rs.getString("Address"), rs.getString("Phone"));
                    oblist.add(mc);
                } 
            return oblist;
        }
     private void showTable() throws SQLException{
        ObservableList<member> oblist = getList();
        Col_Name.setCellValueFactory(new PropertyValueFactory<> ("Name"));
        Col_Address.setCellValueFactory(new PropertyValueFactory<> ("Address"));
        Col_Phone.setCellValueFactory(new PropertyValueFactory<> ("Phone"));
        tableView.setItems(oblist);
    }
      private void executeQuerey(String querey) {
       Connection conn = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(querey);
        }catch(SQLException ex){
        }
    }  
   
}