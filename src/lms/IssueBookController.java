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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Zahra Maryam
 */
public class IssueBookController implements Initializable {

    @FXML
    private TableView<IssueBook> TableView3;
    
    @FXML
    private TableColumn<IssueBook, String> Col_Name;
    @FXML
    private TableColumn<IssueBook,String> Col_Book;
    @FXML
    private TableColumn<IssueBook, String> Col_Date;
    @FXML
    private TableColumn<IssueBook, String> Col_ReturnDate;
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
            Logger.getLogger(IssueBookController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void showTable() throws SQLException{
        ObservableList<IssueBook> oblist = getList();
        Col_Name.setCellValueFactory(new PropertyValueFactory<> ("Name"));
        Col_Book.setCellValueFactory(new PropertyValueFactory<> ("Book"));
        Col_Date.setCellValueFactory(new PropertyValueFactory<> ("Date"));
        Col_ReturnDate.setCellValueFactory(new PropertyValueFactory<> ("ReturnDate"));
        TableView3.setItems(oblist);
    }
    private ObservableList<IssueBook> getList() throws SQLException{
            ObservableList<IssueBook> oblist = FXCollections.observableArrayList();
            Connection con = getConnection();
            String querey = "SELECT * FROM lms.issue;";
            Statement ps;
            ResultSet rs;
            ps = con.createStatement();
            rs = ps.executeQuery(querey);
            IssueBook mc ;
            while(rs.next()){
               
                    mc = new IssueBook(rs.getString("Name"),rs.getString("Book"), rs.getString("Date"), rs.getString("Return Date"));
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
     
     
}
