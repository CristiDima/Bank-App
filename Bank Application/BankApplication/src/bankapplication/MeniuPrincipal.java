/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Cristian Dima
 */
public class MeniuPrincipal {


    public static void meniu() {    
    
    Stage window = new Stage();

    Button addclient = new Button("Adaugare client");
    addclient.setOnAction(e -> {
        window.close();
        AdaugareClient.adaugareClientMeniu();
    });
    
    Button adaugarecont = new Button("Adaugare cont");
    adaugarecont.setOnAction(e -> {
        window.close();
        AdaugareClient.adaugareContMeniu();
    });
    
    Button vizualizareclienti = new Button("Lista clienti banca");
    vizualizareclienti.setOnAction(e -> {
        AdaugareClient.listaClienti();
        window.close();        
    });

    Button deleteclient = new Button("Inchidere Cont");
    deleteclient.setOnAction(e -> {
        window.close();
        AdaugareClient.inchidereContMeniu();
    });
    
    Button retragerebani = new Button("Retragere Numerar");
    retragerebani.setOnAction(e -> {
        window.close();
        TranzactiiCont.retragereMeniu();
    });
    
    Button depunerebani = new Button("Depunere Numerar");
    depunerebani.setOnAction(e -> {
        window.close();
        TranzactiiCont.depunereMeniu();
    });
    
    Button transferbani = new Button("Transfer");
    transferbani.setOnAction(e -> {
        window.close();
        TranzactiiCont.transferMeniu();
    });
    
    Button logout = new Button("Log Out");
    logout.setOnAction(e -> {
        window.close();
    });
    
    addclient.setMaxWidth(200);
    addclient.setMinHeight(50);
    
    adaugarecont.setMaxWidth(200);
    adaugarecont.setMinHeight(50);
   
    deleteclient.setMaxWidth(200);
    deleteclient.setMinHeight(50);
      
    depunerebani.setMaxWidth(200);
    depunerebani.setMinHeight(50);

    retragerebani.setMaxWidth(200);
    retragerebani.setMinHeight(50);
    
    transferbani.setMaxWidth(200);
    transferbani.setMinHeight(50);

    vizualizareclienti.setMaxWidth(200);
    vizualizareclienti.setMinHeight(50);
    
    logout.setMaxWidth(200);
    logout.setMinHeight(50);

    addclient.setStyle("-fx-background-color: #20603d; -fx-text-fill: white;");
    adaugarecont.setStyle("-fx-background-color: #20603d; -fx-text-fill: white;");
    vizualizareclienti.setStyle("-fx-background-color: #262626; -fx-text-fill: white;");
    deleteclient.setStyle("-fx-background-color: #990000; -fx-text-fill: white;");
    retragerebani.setStyle("-fx-background-color: #990000; -fx-text-fill: white;");
    depunerebani.setStyle("-fx-background-color: #20603d; -fx-text-fill: white;");
    transferbani.setStyle("-fx-background-color: #cccc00; -fx-text-fill: white;");

    VBox layout = new VBox(15);;
    layout.getChildren().addAll(addclient, adaugarecont, deleteclient, depunerebani, retragerebani, transferbani, vizualizareclienti, logout);
    layout.setStyle("-fx-background-color: #1a1100;");
    layout.setAlignment(Pos.CENTER);
    
    Scene scene = new Scene(layout, 800, 550);
    window.setScene(scene);
    window.show();
    
    }
 
}
