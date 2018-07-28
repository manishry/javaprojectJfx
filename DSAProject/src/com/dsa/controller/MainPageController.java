
package com.dsa.controller;


import com.dsa.dao.AddCountyrDAO;
import com.dsa.dao.CountryListDAO;

import com.dsa.entities.CountryList;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 *
 * @author Manish Rmc
 */
public class MainPageController implements Initializable{
    
    @FXML
    private TableView<CountryList> table;
    @FXML private TableColumn<CountryList, Integer> cid;
     @FXML private TableColumn<CountryList, String> name;
     @FXML private TableColumn<CountryList, String> region;
    @FXML private TableColumn<CountryList, Integer> temperature;
    
    @FXML
    private TextField txtCountryName, txtRegion, txtTemperature,TextFieldTemp;
     @FXML
     private Label cidLbl,lblNormal,lblHotCold,DegreeF;
    @FXML
    private Button btnAdd, btnDelete, btnUpdate, btnSort,btnCalculate;
    
   
    
    // convert into °C to °F
    public void CalculateEvent(ActionEvent ae)  throws SQLException, IOException{
      
      double celsius ;

      String celsiusString =  TextFieldTemp.getText();
       celsius = Double.parseDouble(celsiusString);
        celsius = (9*celsius/5) + 32;
          DegreeF.setText (Double.toString(celsius));
    
     //  DegreeF.setText("hello"+celsiusString);
        //celsius =  (9*celsius/5) + 32;
        System.out.println(celsius);
       
        
        if(celsius>35){
            lblHotCold.setText("Temperature is very hot");
        }
        else if (celsius<10) {   
            lblHotCold.setText("Temperature is very cold");
        }
         else if (celsius>=10&&celsius<=35) {   
            lblHotCold.setText("Temperature is normal");
        }
         else{
           System.out.println("please enter correct number");
         }
        
         Parent root = 
                 FXMLLoader.load(getClass().getResource("../fxml/ProjectFxml.fxml"));
         Scene scene = new Scene(root);
         Stage stage = (Stage) DegreeF.getScene().getWindow();
         stage.setScene(scene);
      
}
    
    
     public ObservableList<CountryList> list = 
            FXCollections.observableArrayList();
 //   private Object DialogOptions;
     
     public void selector(MouseEvent e){
        TablePosition pos = table.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        CountryList item = table.getItems().get(row);
        int cid = Integer.valueOf(item.getCid());
        String cname = item.getCname().toString();
        String region = item.getRegion().toString();
          int temperature = Integer.valueOf(item.getTemperature());
         System.out.println(cid + cname + region + temperature);
        
        cidLbl.setText(cid+"");
        txtCountryName.setText(cname);
        txtRegion.setText(region);
        txtTemperature.setText(temperature+"");
        
          //desable the add button
       
         btnAdd.setDisable(true);
         
        }
     // update operation
      public void UpdateEvent(ActionEvent ae ) throws SQLException, IOException{
         Integer cid = Integer.valueOf(cidLbl.getText());
         String cname = txtCountryName.getText();
         String region = txtRegion.getText();
         Integer temperature = Integer.valueOf(txtTemperature.getText());
         
         CountryList cl = new CountryList(cid,cname,region,temperature);
         new CountryListDAO().updateCountryList(cl);
         
          Alert alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("Update operation");
          alert.setHeaderText("Update Successfully");
          alert.setContentText("");
          alert.showAndWait();
         // update UI refresh UI
         
         Parent root = 
                 FXMLLoader.load(getClass().getResource("../fxml/ProjectFxml.fxml"));
         Scene scene = new Scene(root);
         Stage stage = (Stage) cidLbl.getScene().getWindow();
         stage.setScene(scene);
         
         
          //enable the add button 
         btnAdd.setDisable(false);
     }
      // delete operation
      public void DeleteEvent(ActionEvent ae ) throws SQLException, IOException{
         
         Integer cid = Integer.valueOf(cidLbl.getText());
         String cname = txtCountryName.getText();
         String region = txtRegion.getText();
         Integer temperature = Integer.valueOf(txtTemperature.getText());
         
         //Stage stage = (Stage)deleteButton.getScene().getWindow();
       Alert alert = new Alert(AlertType.WARNING);
          alert.setTitle("Delete operation");
          alert.setHeaderText("Are you sure you want to delete!...");
          alert.setContentText("");
          alert.showAndWait();//.ifPresent(rs ->
          {
         // if (rs == ButtonType.OK) {
      //  System.out.println("Pressed OK.");
    }
//});
         
         CountryList cl = new CountryList(cid,cname,region,temperature);
          
         /*
                 */
         new CountryListDAO().deleteCountryList(cl);
         // update UI refresh UI
         
         Parent root = 
                 FXMLLoader.load(getClass().getResource("../fxml/ProjectFxml.fxml"));
         Scene scene = new Scene(root);
         Stage stage = (Stage) cidLbl.getScene().getWindow();
         
         
         stage.setScene(scene);
        
         
         
         
     }
      // sorting event 
      public void SortEvent(ActionEvent ae) throws SQLException, IOException {
         Integer cid = Integer.valueOf(cidLbl.getText());
         String cname = txtCountryName.getText();
         String region = txtRegion.getText();
         Integer temperature = Integer.valueOf(txtTemperature.getText());
         
           CountryList cl = new CountryList(cid,cname,region,temperature);
              new CountryListDAO().sortCountryByAsc(cl);
        Parent root = 
                 FXMLLoader.load(getClass().getResource("../fxml/ProjectFxml.fxml"));
         Scene scene = new Scene(root);
         Stage stage = (Stage) btnSort.getScene().getWindow();
         
         
         stage.setScene(scene);
        }
      
      // input data
    public void AddEvent(ActionEvent e) throws SQLException, IOException{
        String cname = txtCountryName.getText();
       // System.out.println(cname);
        
         String region = txtRegion.getText();
       // System.out.println(region);
        
       int temperature= Integer.valueOf(txtTemperature.getText());
     //  System.out.println(temperature);
       
         txtCountryName.setText("");
         txtRegion.setText("");
         txtTemperature.setText("");
         
         new AddCountyrDAO().getCountryType(cname, region,temperature);
          Parent root = 
                 FXMLLoader.load(getClass().getResource("../fxml/ProjectFxml.fxml"));
         Scene scene = new Scene(root);
         Stage stage = (Stage) btnAdd.getScene().getWindow();
         
          Alert alert = new Alert(AlertType.INFORMATION);
          alert.setTitle("Insert");
          alert.setHeaderText("Add Successfully");
          alert.setContentText("");
          alert.showAndWait();
         stage.setScene(scene);
         
    
    }
     @Override
    public void initialize(URL location, ResourceBundle rb) {
        ObservableList<CountryList> alist = null;
        try{
           alist = new CountryListDAO().getCountryList();
            for(CountryList var:alist){
            // System.out.println(var.getCname());
         }
        } catch(SQLException ex){
            System.out.println(ex);
        }
        
        // disply in table format
        
         cid.setCellValueFactory(new PropertyValueFactory<CountryList,Integer>("cid"));
         name.setCellValueFactory(new PropertyValueFactory<CountryList,String>("cname"));
         region.setCellValueFactory(new PropertyValueFactory<CountryList,String>("region"));
         temperature.setCellValueFactory(new PropertyValueFactory<CountryList,Integer>("temperature"));
         
           
          table.setItems(alist);
         
        
           }  
    }
    

