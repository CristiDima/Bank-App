/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import static bankapplication.AdaugareClient.stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
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
public class OperatiuniClient {
    
    
    public static void bancomat(){
     
    Stage window = new Stage();
        
    Button retragere = new Button("Retragere Numerar");
    retragere.setOnAction(e -> {
        window.close();
        retragereMeniu();
    });
    
    Button depunere = new Button("Depunere Numerar");
    depunere.setOnAction(e -> {
        window.close();
        depunereMeniu();
    });
    
    Button vizualizareCont = new Button("Vizualizare Cont");
    vizualizareCont.setOnAction(e -> {
        window.close();
        infoMeniu();
    });
    
    
    Button schimbaParola = new Button("Schimbare Parola");
    schimbaParola.setOnAction(e -> {
        window.close();
        schimbaParolaMeniu();
    });
    
    
    retragere.setMaxWidth(200);
    retragere.setMinHeight(50);
    
    depunere.setMaxWidth(200);
    depunere.setMinHeight(50);
    
    vizualizareCont.setMaxWidth(200);
    vizualizareCont.setMinHeight(50);
    
    schimbaParola.setMaxWidth(200);
    schimbaParola.setMinHeight(50);
    
    
    VBox layout = new VBox(15);;
    layout.getChildren().addAll(retragere, depunere, schimbaParola, vizualizareCont);
    layout.setStyle("-fx-background-color: #1a1100;");
    layout.setAlignment(Pos.CENTER);
    
    Scene scene = new Scene(layout, 800, 550);
    window.setScene(scene);
    window.show();
    }

    public static void retragereMeniu(){
        
        Stage window1 = new Stage();
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        Text sumaLabel = new Text("Introduceti suma");
        TextField sumaField = new TextField();
        
        Text idLabel = new Text("ID");
        TextField idField = new TextField();
        
        
        Button retrage = new Button("Retragere numerar");
        Alert alertSucces = new Alert(Alert.AlertType.INFORMATION);
        
        retrage.setOnAction((ActionEvent e) -> {
            if(!sumaField.getText().matches("[0-9]*")){
                alert.setContentText("Campul pentru suma nu este corect completat");
                alert.showAndWait();
                return;
            }
            if(idField.getText().isEmpty()){
                alert.setContentText("Campul pentru id nu este corect completat");
                alert.showAndWait();
                return;
            }
            
            if(alert.getContentText().length() == 0){
                if(verificareID(idField.getText())){
                    retragere(idField.getText(), Integer.parseInt(sumaField.getText()));
                }  
                else{
                    Alert alertw = new Alert(Alert.AlertType.WARNING);
                    alertw.setContentText("CNP-ul introdus nu este valid");
                    alertw.showAndWait();
                    }
            }
        });
        
        Button back = new Button("Inapoi");
        
        back.setOnAction(e -> {
            bancomat();
            window1.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800, 800);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #556B2F;");

        gridPane.add(sumaLabel, 0, 1);
        gridPane.add(sumaField, 1, 1);
        gridPane.add(idLabel, 0, 0);
        gridPane.add(idField, 1, 0);
        gridPane.add(retrage, 1, 2);
        gridPane.add(back, 2, 2);
        
        Scene scene = new Scene(gridPane, 800, 550);
        window1.setScene(scene);
        window1.showAndWait();
    }
    
    public static void depunereMeniu(){
        
        Stage window1 = new Stage();
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        Text sumaLabel = new Text("Introduceti suma");
        TextField sumaField = new TextField();
        
        Text idLabel = new Text("ID");
        TextField idField = new TextField();
        
        
        Button depunere = new Button("Depunere numerar");
        Alert alertSucces = new Alert(Alert.AlertType.INFORMATION);
        
        depunere.setOnAction((ActionEvent e) -> {
            if(!sumaField.getText().matches("[0-9]*")){
                alert.setContentText("Campul pentru suma nu este corect completat");
                alert.showAndWait();
                return;
            }
            if(idField.getText().isEmpty()){
                alert.setContentText("Campul pentru id nu este corect completat");
                alert.showAndWait();
                return;
            }
            
            if(alert.getContentText().length() == 0){
                if(verificareID(idField.getText())){
                    depunere(idField.getText(), Integer.parseInt(sumaField.getText()));
                }  
                else{
                    Alert alertw = new Alert(Alert.AlertType.WARNING);
                    alertw.setContentText("CNP-ul introdus nu este valid");
                    alertw.showAndWait();
                    }
            }
        });
        
        Button back = new Button("Inapoi");
        
        back.setOnAction(e -> {
            bancomat();
            window1.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800, 800);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #556B2F;");

        gridPane.add(sumaLabel, 0, 1);
        gridPane.add(sumaField, 1, 1);
        gridPane.add(idLabel, 0, 0);
        gridPane.add(idField, 1, 0);
        gridPane.add(depunere, 1, 2);
        gridPane.add(back, 2, 2);
        
        Scene scene = new Scene(gridPane, 800, 550);
        window1.setScene(scene);
        window1.showAndWait();
    }
    
    public static void infoMeniu(){
        
        Stage window1 = new Stage();
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        Text idLabel = new Text("ID");
        TextField idField = new TextField();
        
        Button info = new Button("Info");
        Alert alertSucces = new Alert(Alert.AlertType.INFORMATION);
        
        info.setOnAction((ActionEvent e) -> {
             if(idField.getText().isEmpty()){
                alert.setContentText("Campul pentru id nu este corect completat");
                alert.showAndWait();
                return;
            }
            
            if(alert.getContentText().length() == 0){
                if(verificareID(idField.getText())){
                    informatiiCont(idField.getText());
                }  
                else{
                    Alert alertw = new Alert(Alert.AlertType.WARNING);
                    alertw.setContentText("ID-ul introdus nu este valid");
                    alertw.showAndWait();
                    }
            }
        });
        
        Button back = new Button("Inapoi");
        
        back.setOnAction(e -> {
            bancomat();
            window1.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800, 800);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #556B2F;");


        gridPane.add(idLabel, 0, 0);
        gridPane.add(idField, 1, 0);
        gridPane.add(info, 1, 2);
        gridPane.add(back, 2, 2);
        
        Scene scene = new Scene(gridPane, 800, 550);
        window1.setScene(scene);
        window1.showAndWait();
    }
    
    public static void schimbaParolaMeniu(){
        
        Stage window1 = new Stage();
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        Text idLabel = new Text("ID");
        TextField idField = new TextField();
        
        Text parolaLabel = new Text("Parola");
        TextField parolaField = new PasswordField();
        
        Button schimba = new Button("Schimpa parola");
        Alert alertSucces = new Alert(Alert.AlertType.INFORMATION);
        
        schimba.setOnAction(e -> {
            
            if(!parolaField.getText().matches("(\\d{4})")){
                alert.setContentText("Campul pentru parola nu este corect completat");
                alert.showAndWait();
                return;
            }
            
            if(idField.getText().isEmpty()){
                alert.setContentText("Campul pentru id nu este corect completat");
                alert.showAndWait();
                return;
            }
            
            if(alert.getContentText().length() == 0){
                if(verificareID(idField.getText())){
                    schimbaParola(parolaField.getText(), idField.getText());
                }  
                else{
                    Alert alertw = new Alert(Alert.AlertType.WARNING);
                    alertw.setContentText("ID-ul introdus nu este valid");
                    alertw.showAndWait();
                    } 
            }
        });
        
        Button back = new Button("Inapoi");
        
        back.setOnAction(e -> {
            bancomat();
            window1.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800, 800);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #556B2F;");

        gridPane.add(idLabel, 0, 0);
        gridPane.add(idField, 1, 0);
        gridPane.add(parolaLabel, 0, 1);
        gridPane.add(parolaField, 1, 1);
        gridPane.add(schimba, 1, 2);
        gridPane.add(back, 2, 2);
        
        Scene scene = new Scene(gridPane, 800, 550);
        window1.setScene(scene);
        window1.showAndWait();
    }
    
    public static void schimbaParola(String parola, String id){
        
        try{
		Connection conn = DataBaseLogin.connector();
		
		PreparedStatement ps2=conn.prepareStatement("update client set parola=? where id=?");
		ps2.setString(1,parola);
		ps2.setString(2,id);
		ps2.executeUpdate();
                Alert alertSucces = new Alert(Alert.AlertType.INFORMATION);
                alertSucces.setContentText("Parola a fost schimbata");
                alertSucces.showAndWait();
		
		conn.close();
	}catch(Exception e){System.out.println(e);}
    }
    
    public static void retragere(String id, int soldRetras){
        
	int soldCurent = 0;
	try{
		Connection conn = DataBaseLogin.connector();
		
		PreparedStatement ps=conn.prepareStatement("select sold from client where id=?");
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			soldCurent = rs.getInt("sold");
		}
		int soldNou = (int) (soldRetras + (0.2*soldRetras)/100);
		if(soldCurent > soldNou){
		PreparedStatement ps2=conn.prepareStatement("update client set sold=? where id=?");
		ps2.setInt(1,soldCurent - soldNou);
		ps2.setString(2,id);
		ps2.executeUpdate();
                Alert alertSucces = new Alert(Alert.AlertType.INFORMATION);
                alertSucces.setContentText("Operatiunea a fost realizata");
                alertSucces.showAndWait();
		}
                else{
                    Alert alertWarning = new Alert(Alert.AlertType.WARNING);
                    alertWarning.setContentText("Ne pare rau, nu aveti fonduri suficiente");
                    alertWarning.showAndWait();
                }
		conn.close();
	}catch(Exception e){System.out.println(e);}
    }
  
    public static void depunere(String id, int soldAdaugat){
        
	double soldCurent = 0;
	try{
		Connection conn = DataBaseLogin.connector();
		
		PreparedStatement ps=conn.prepareStatement("select sold from client where id = ?");
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			soldCurent = rs.getInt("sold");
		}
		PreparedStatement ps2=conn.prepareStatement("update client set sold=? where id = ?");
		ps2.setDouble(1,soldCurent + soldAdaugat);
		ps2.setString(2,id);
		ps2.executeUpdate();
                Alert alertSucces = new Alert(Alert.AlertType.INFORMATION);
                alertSucces.setContentText("Operatiunea a fost realizata");
                alertSucces.showAndWait();
		
		conn.close();
	}catch(Exception e){System.out.println(e);}
    }
    
    public static boolean verificareID(String id){   
        boolean status=false;
	try{
            Connection conn = DataBaseLogin.connector();
            PreparedStatement ps=conn.prepareStatement("select * from client where id=?");
            ps.setString(1,id);
	    ResultSet rs=ps.executeQuery();
            status=rs.next();
            conn.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
    
    public static void informatiiCont(String id)  {
        
        String nume = "", prenume = "";
        int sold = 0;
        
        Connection conn = DataBaseLogin.connector();
	try{	
	PreparedStatement ps=conn.prepareStatement("select sold, nume, prenume from client where id=?");
        ps.setString(1,id);
	ResultSet rs=ps.executeQuery();
	if(rs.next()){
            sold = rs.getInt("sold");
            nume = rs.getString("nume");
            prenume = rs.getString("prenume");
	}

                Alert alertSucces = new Alert(Alert.AlertType.INFORMATION);
                alertSucces.setContentText("Suma din contul dumneavoastra este de: " + sold + " RON");
                alertSucces.showAndWait();
		conn.close();
        }catch(Exception e){System.out.println(e);}
    }

}


