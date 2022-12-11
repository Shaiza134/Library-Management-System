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
public class BookController implements Initializable {

    @FXML
    private TextField TFName;
    @FXML
    private TextField TFAuthor;
    @FXML
    private TextField TFEdition;
    @FXML
    private TextField TFCategory;
    @FXML
    private Button AddB;
    @FXML
    private Button UpdateB;
    @FXML
    private Button SaveB;
    @FXML
    private Button RemoveB;
    @FXML
    private TableView<Books> tableView1;
    @FXML
    private TableColumn<Books, String> Col_Name;
    @FXML
    private TableColumn<Books, String> Col_Author;
    @FXML
    private TableColumn<Books, String> Col_Category;
    @FXML
    private TableColumn<Books, String> Col_Edition;
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
            System.out.println(ex);
        }
    }    

    @FXML
    private void HandleAddAction(ActionEvent event) {
        if(TFName.getText().equals("") || TFAuthor.getText().equals("") || TFCategory.getText().equals("") || TFEdition.getText().equals("")){
            Alert alt = new Alert(Alert.AlertType.ERROR);
            alt.setTitle("Invalid Fields");
            alt.setContentText("Incorect data in Fields");
        alt.show();
        TFName.setText("");
        TFAuthor.setText("");
        TFCategory.setText("");
        TFEdition.setText("");}
        else{
        Add();
        TFName.setText("");
        TFAuthor.setText("");
        TFCategory.setText("");
        TFEdition.setText("");}
    }

    @FXML
    private void HandleUpdateAction(ActionEvent event) {
        if(TFName.getText().equals("") || TFAuthor.getText().equals("") || TFCategory.getText().equals("") || TFEdition.getText().equals("")){
            Alert alt = new Alert(Alert.AlertType.ERROR);
            alt.setTitle("Invalid Fields");
            alt.setContentText("Incorect data in Fields");
        alt.show();
        TFName.setText("");
        TFAuthor.setText("");
        TFCategory.setText("");
        TFEdition.setText("");}
    else{
        updateRecord();
        TFName.setText("");
        TFAuthor.setText("");
        TFCategory.setText("");
        TFEdition.setText("");}
    }

   

    @FXML
    private void HandleRemoveAction(ActionEvent event) throws SQLException {
        if(TFName.getText().equals("") || TFAuthor.getText().equals("") || TFCategory.getText().equals("") || TFEdition.getText().equals("")){
            Alert alt = new Alert(Alert.AlertType.ERROR);
            alt.setTitle("Invalid Fields");
            alt.setContentText("ENter all data in Fields");
        alt.show();
        TFName.setText("");
        TFAuthor.setText("");
        TFCategory.setText("");
        TFEdition.setText("");}
        else{
        deleteButton();
        TFName.setText("");
        TFAuthor.setText("");
        TFCategory.setText("");
        TFEdition.setText("");}
    
    }
      private void updateRecord() {
        try {
            String querey = "UPDATE `lms`.`books` SET `Category` = '"+TFCategory.getText()+"' WHERE (`Name` = '"+TFName.getText()+"') and (`Author` = '"+TFAuthor.getText()+"') and (`Edition` = '"+TFEdition.getText()+"');"; 
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
    private void Add()  {
        try {
            String querey = "INSERT INTO `lms`.`books` (`Name`, `Author`, `Category`, `Edition`) VALUES ('"+TFName.getText()+"', '"+TFAuthor.getText()+"', '"+TFCategory.getText()+"', '"+TFEdition.getText()+"');";
            executeQuerey(querey);
            showTable();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private void deleteButton() throws SQLException {
            String querey = "DELETE FROM `lms`.`books` WHERE (`Name` = '"+TFName.getText()+"') and (`Author` = '"+TFAuthor.getText()+"') and (`Category` = '"+TFCategory.getText()+"') and (`Edition` = '"+TFEdition.getText()+"');";
            executeQuerey(querey);
            showTable();
        }
    
    private void showTable() throws SQLException{
        ObservableList<Books> oblist = getList();
        Col_Name.setCellValueFactory(new PropertyValueFactory<> ("Name"));
        Col_Author.setCellValueFactory(new PropertyValueFactory<> ("Author"));
        Col_Category.setCellValueFactory(new PropertyValueFactory<> ("Category"));
        Col_Edition.setCellValueFactory(new PropertyValueFactory<> ("Edition"));
        tableView1.setItems(oblist);
    }
    private ObservableList<Books> getList() throws SQLException{
            ObservableList<Books> oblist = FXCollections.observableArrayList();
            Connection con = getConnection();
            String querey = "SELECT * FROM lms.books;";
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

   