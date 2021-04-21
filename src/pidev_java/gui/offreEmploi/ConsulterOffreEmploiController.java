/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev_java.gui.offreEmploi;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import pidev_java.entities.offreEmploi;
import pidev_java.services.emploiService;

/**
 * FXML Controller class
 *
 * @author Ghassen Riahi
 */
public class ConsulterOffreEmploiController implements Initializable {

    @FXML
    private Button btnA;
    @FXML
    private ScrollPane scrolEmploi;
    @FXML
    private GridPane gridEmploi;
    @FXML
    private ScrollPane scrolStage1;
    @FXML
    private GridPane gridStage1;
    emploiService ss=new emploiService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          scrolEmploi.setVisible(true);
         gridEmploi.getChildren().clear();
         int columnMesForm = 0;
        int rowMesForm = 1;
         try {
            
           List<offreEmploi> MesOffre=ss.getAll();
            for (int i = 0; i < MesOffre.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/pidev_java/gui/offreEmploi/itemEmp.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemEmpController itemEmpController = fxmlLoader.getController();
               
                itemEmpController.setData(MesOffre.get(i),this);

                 if (columnMesForm == 2) {
                    columnMesForm = 0;
                    rowMesForm++;
                }

                gridEmploi.add(anchorPane, columnMesForm, rowMesForm++); //(child,column,row)
                //set grid width
                gridEmploi.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridEmploi.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridEmploi.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridEmploi.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridEmploi.setPrefHeight(Region.USE_COMPUTED_SIZE);
               gridEmploi.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (Exception e) {
                        System.out.println(e.getMessage());

           }
        // TODO
    }    

    @FXML
    private void AjouterOffre(MouseEvent event) {
        try {
                 FXMLLoader loader1 = new FXMLLoader ();
                 loader1.setLocation(getClass().getResource("/pidev_java/gui/offreEmploi/AjoutoffreEmploi.fxml"));
                
                 Parent  parent = (Parent)loader1.load();
                  Stage stage = new Stage();
                 stage.setScene(new Scene(parent));
                  stage.show();
                   
                  AjoutoffreEmploiController afc=loader1.getController();
                 afc.init(this);
                
             } catch (IOException ex) {
                 System.out.println("erreur");
             }
    }
    
    public void updateList(){
        
         gridEmploi.getChildren().clear();
         int columnMesForm = 0;
        int rowMesForm = 1;
         
        
         try {
            
           List<offreEmploi> MesOffre=ss.getAll();
            for (int i = 0; i < MesOffre.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/pidev_java/gui/offreEmploi/itemEmp.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemEmpController itemController = fxmlLoader.getController();
               
                itemController.setData(MesOffre.get(i),this);

                 if (columnMesForm == 2) {
                    columnMesForm = 0;
                    rowMesForm++;
                }

                gridEmploi.add(anchorPane, columnMesForm, rowMesForm++); //(child,column,row)
                //set grid width
                gridEmploi.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridEmploi.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridEmploi.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                gridEmploi.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridEmploi.setPrefHeight(Region.USE_COMPUTED_SIZE);
               gridEmploi.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (Exception e) {
                        System.out.println(e.getMessage());

           }
    }
    
    
    
}
