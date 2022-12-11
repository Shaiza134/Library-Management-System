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
public class IssueBookUserController implements Initializable {

    @FXML
    private TextField TFName;
    @FXML
    private TextField TFBook;
    @FXML
    private DatePicker TFDate;
    @FXML
    private DatePicker TFReturn;
    @FXML
    private Button AddB;
    @FXML
    private Button CancelB;
    @FXML
    private Button BackB;
    static ObservableList<Books> oblist;
    @FXML
    private TableColumn<Books, String> Col_Name;
    @FXML
    private TableColumn<Books, String> Col_Author;
    @FXML
    private TableColumn<Books, String> Col_Edition;
    @FXML
    private TableColumn<Books, String> Col_Category;
    @FXML
    private TableView<Books> TableView;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showTable();
        } catch (SQLException ex) {
            Logger.getLogger(IssueBookUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void HandleAddAction(ActionEvent event) {
        if(TFName.getText().equals("") || TFBook.getText().equals("") || TFDate.getValue().equals("") || TFReturn.getValue().equals("")){
            Alert alt = new Alert(Alert.AlertType.ERROR);
            alt.setTitle("Invalid Fields");
            alt.setContentText("Incorect data in Fields");
        alt.show();
        TFName.setText("");
        TFBook.setText("");
        TFDate.getEditor().setText("");
        TFReturn.getEditor().setText("");}
        else
        {Add();
        TFName.setText("");
        TFBook.setText("");
        TFDate.getEditor().setText("");
        TFReturn.getEditor().setText("");}
        
    }

    @FXML
    private void HandleCancelAction(ActionEvent event) {
        TFName.setText("");
        TFBook.setText("");
        TFDate.getEditor().setText("");
        TFReturn.getEditor().setText("");
    }

    @FXML
    private void HandleBachAction(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("User.fxml"));
            Stage stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene1 = new Scene(root2 );
            stage1.setScene(scene1);
            stage1.show();
    }
    
    private void Add()  {
        String querey = "INSERT INTO `lms`.`issue` (`Name`, `Book`, `Date`, `Return Date`) VALUES ('"+TFName.getText()+"', '"+TFBook.getText()+"', '"+TFDate.getValue().toString()+"', '"+TFReturn.getValue().toString()+"');";
        executeQuerey(querey);
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
    private ObservableList<Books> getList() throws SQLException{
            ObservableList<Books> oblist = FXCollections.observableArrayList();
            Connection con = getConnection();
            String querey = "SELECT * FROM lms.books WHERE Category = 'Issuable';";
            Statement ps;
            ResultSet rs;
            ps = con.createStatement();
            rs = ps.executeQuery(querey);
            Books mc ;
            while(rs.next()){
               
                    mc = new Books(rs.getString("Name"),rs.getString("Author"), rs.getString("Category"),rs.getString("Edition"));
                    oblist.add(mc);
                } 
            return oblist;
        }
    private void showTable() throws SQLException{
        ObservableList<Books> oblist = getList();
        Col_Name.setCellValueFactory(new PropertyValueFactory<> ("Name"));
        Col_Author.setCellValueFactory(new PropertyValueFactory<> ("Author"));
        Col_Category.setCellValueFactory(new PropertyValueFactory<> ("Category"));
        Col_Edition.setCellValueFactory(new PropertyValueFactory<> ("Edition"));
        TableView.setItems(oblist);
    }
}
