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
import javafx.scene.control.DatePicker;
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
public class ReturnBookController implements Initializable {

    @FXML
    private TextField TFName;
    @FXML
    private TextField TFBook;
    @FXML
    private DatePicker TFDate;
    @FXML
    private Button AddB;
    @FXML
    private Button CancelB;
    @FXML
    private TableView<ReturnBook> tableView6;
    @FXML
    private TableColumn<ReturnBook, String> Col_Name;
    @FXML
    private TableColumn<ReturnBook, String> Col_Book;
    @FXML
    private TableColumn<ReturnBook, String> Col_Date;
    @FXML
    private Button BackB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showTable();
        } catch (SQLException ex) {
            Logger.getLogger(ReturnBookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void HandleAddAction(ActionEvent event) {
        if(TFName.getText().equals("") || TFBook.getText().equals("") || TFDate.getValue().equals("")){
            Alert alt = new Alert(Alert.AlertType.ERROR);
            alt.setTitle("Invalid Fields");
            alt.setContentText("Incorect data in Fields");
        alt.show();
        TFName.setText("");
        TFBook.setText("");
        TFDate.setValue(null);}
        else{
            Add();
        TFName.setText("");
        TFBook.setText("");
        TFDate.setValue(null);}
    }

    @FXML
    private void HandleCancelAction(ActionEvent event) {
        TFName.setText("");
        TFBook.setText("");
        TFDate.setValue(null);
    }

    @FXML
    private void HandleBackAction(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("Admin.fxml"));
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
    }
    private void showTable() throws SQLException{
        ObservableList<ReturnBook> oblist = getList();
        Col_Name.setCellValueFactory(new PropertyValueFactory<> ("Name"));
        Col_Book.setCellValueFactory(new PropertyValueFactory<> ("Book"));
        Col_Date.setCellValueFactory(new PropertyValueFactory<> ("Date"));
        tableView6.setItems(oblist);
    }
    private ObservableList<ReturnBook> getList() throws SQLException{
            ObservableList<ReturnBook> oblist = FXCollections.observableArrayList();
            Connection con = getConnection();
            String querey = "SELECT * FROM lms.return;";
            Statement ps;
            ResultSet rs;
            ps = con.createStatement();
            rs = ps.executeQuery(querey);
            ReturnBook mc ;
            while(rs.next()){
               
                    mc = new ReturnBook(rs.getString("Name"),rs.getString("Book"), rs.getString("Date"));
                    oblist.add(mc);
                } 
            return oblist;
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
    private void Add()  {
        try {
            String querey = "INSERT INTO `lms`.`return` (`Name`, `Book`, `Date`) VALUES ('"+TFName.getText()+"', '"+TFBook.getText()+"', '"+TFDate.getValue()+"');";
            executeQuerey(querey);
            showTable();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
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
}
