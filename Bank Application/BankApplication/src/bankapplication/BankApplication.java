/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Cristian Dima
 */
public class BankApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        Alert alertBOX = new Alert(Alert.AlertType.ERROR);
        
        Button administrator, client, trimite, back;
        
        Stage window = primaryStage;
        window.setTitle("Banca Dima");

        Stage window1 = new Stage();
        window1.setTitle("Logare");
        
        Stage window2 = new Stage();
        window2.setTitle("Logare");
        
  
        // Setare etichete pentru nume
        Text numeLabel = new Text("Nume");
        numeLabel.setStyle("-fx-font: normal bold 17px 'serif' ");
        TextField numeField = new TextField();

        // Setare etichete pentru parola
        Text parolaLabel = new Text("Parola");
        parolaLabel.setStyle("-fx-font: normal bold 17px 'serif' ");
        PasswordField parolaField = new PasswordField();
        
        Text cnpLabel = new Text("CNP");
        cnpLabel.setStyle("-fx-font: normal bold 17px 'serif' ");
        TextField cnpField = new TextField();
        
        Text idLabel = new Text("ID");
        idLabel.setStyle("-fx-font: normal bold 17px 'serif' ");
        TextField idField = new TextField();
       
        Text parola1Label = new Text("Parola");
        parola1Label.setStyle("-fx-font: normal bold 17px 'serif' ");
        PasswordField parola1Field = new PasswordField();
        
        // Setare butoane pentru trimitere si inapoi
        trimite = new Button("Trimiteti");
        back = new Button("Inapoi");
        back.setStyle("-fx-background-color: #000000; -fx-text-fill: white;");
        trimite.setStyle("-fx-background-color: #000000; -fx-text-fill: white;");
        trimite.setOnAction(e -> {
            if (DataBaseLogin.administratorLogin(numeField.getText(), parolaField.getText())) {
                MeniuPrincipal.meniu();
                numeField.clear();
                parolaField.clear();
            } else {
                alertBOX.setContentText("Numele sau parola au fost introduse gresit");
                alertBOX.showAndWait();
            }
        });
        
        Button trimite1 = new Button("Trimiteti");
        Button back1 = new Button("Inapoi");
        back1.setStyle("-fx-background-color: #000000; -fx-text-fill: white;");
        trimite1.setStyle("-fx-background-color: #000000; -fx-text-fill: white;");
        trimite1.setOnAction(e -> {
            if (DataBaseLogin.clientLogin(cnpField.getText(), idField.getText(), parola1Field.getText())) {
                OperatiuniClient.bancomat();
                cnpField.clear();
                idField.clear();
                parola1Field.clear();
            } else {
                alertBOX.setContentText("ID-ul, CNP-ul sau parola au fost introduse gresit");
                alertBOX.showAndWait();
            }
            
        });
        

        // Setare panel
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #C0C0C0;");

        gridPane.add(numeLabel, 0, 0);
        gridPane.add(numeField, 1, 0);
        gridPane.add(parolaLabel, 0, 1);
        gridPane.add(parolaField, 1, 1);
        gridPane.add(trimite, 1, 2);
        gridPane.add(back, 2, 2);
        
           
        GridPane gridPane1 = new GridPane();
        gridPane1.setMinSize(400, 200);
        gridPane1.setPadding(new Insets(10, 10, 10, 10));
        gridPane1.setVgap(5);
        gridPane1.setHgap(5);
        gridPane1.setAlignment(Pos.CENTER);
        gridPane1.setStyle("-fx-background-color: #C0C0C0;");

        gridPane1.add(cnpLabel, 0, 0);
        gridPane1.add(cnpField, 1, 0);
        gridPane1.add(idLabel, 0, 1);
        gridPane1.add(idField, 1, 1);
        gridPane1.add(parola1Label, 0, 2);
        gridPane1.add(parola1Field, 1, 2);
        gridPane1.add(trimite1, 1, 3);
        gridPane1.add(back1, 2, 3);

        // Setare scene
        Scene scene1 = new Scene(gridPane);
        Scene scene2 = new Scene(gridPane1);
        
        // Setare butoane pentru logare administrator si bibliotecar
        administrator = new Button("Logare Administrator");
        administrator.setMaxWidth(130);
        administrator.setStyle("-fx-background-color: #008000; -fx-text-fill: white;");
        administrator.setOnAction(e -> window.setScene(scene1));

        client = new Button("Logare Client");
        client.setMaxWidth(130);
        client.setStyle("-fx-background-color: #008000; -fx-text-fill: white;");
        client.setOnAction(e -> window.setScene(scene2));


        // Setare aspect
        VBox layout = new VBox(15);
        layout.getChildren().addAll(administrator, client);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #C0C0C0;");

        Scene scene = new Scene(layout, 400, 400);
        back.setOnAction(e -> window.setScene(scene));
        back1.setOnAction(e -> window.setScene(scene));
        window.setScene(scene);
        window.show();
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

