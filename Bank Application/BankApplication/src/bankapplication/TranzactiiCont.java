/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Cristian Dima
 */
public class TranzactiiCont {
    
    static Stage stage = new Stage();

    public static void retragereMeniu() {
       
        Button back = new Button("Inapoi");
        back.setOnAction(e -> {
                MeniuPrincipal.meniu();
                stage.close();
         });
        
        Text cnpLabel = new Text("CNP Client");
        TextField cnpField = new TextField();
        
        Text idLabel = new Text("ID Client");
        TextField idField = new TextField();
        
        Text sumarLabel = new Text("Suma");
        TextField sumarField = new TextField();
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        Button retragere = new Button("Retragere numerar");
        retragere.setOnAction(e -> {
            if(!cnpField.getText().matches("(\\d{13})")){
                alert.setContentText("Campul pentru CNP nu este corect completat");
                alert.showAndWait();
                cnpField.clear();
                return;
            }
            
            if(!idField.getText().matches("[0-9]*")){
                alert.setContentText("Campul pentru id nu este corect completat");
                alert.showAndWait();
                idField.clear();
                return;
            }
        
            if(!sumarField.getText().matches("[0-9]*")){
                alert.setContentText("Campul pentru suma nu este corect completat");
                alert.showAndWait();
                sumarField.clear();
                return;
            }
            if(alert.getContentText().length() == 0){
                if(verificareCont(cnpField.getText(), idField.getText())){ 
                    retragere(cnpField.getText(), idField.getText(), Integer.parseInt(sumarField.getText()));
                    cnpField.clear();
                    idField.clear();
                    sumarField.clear();
                }
                else{
                    Alert alertw = new Alert(Alert.AlertType.WARNING);
                    alertw.setContentText("CNP-ul sau id-ul introdus nu este valid");
                    alertw.showAndWait();
                    cnpField.clear();
                    idField.clear();
                    sumarField.clear();
                    }
            }
        });
        
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800, 800);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(cnpLabel, 0, 1);
        gridPane.add(cnpField, 1, 1);
        gridPane.add(idLabel, 0, 2);
        gridPane.add(idField, 1, 2);
        gridPane.add(sumarLabel, 0, 3);
        gridPane.add(sumarField, 1, 3);
        gridPane.add(retragere, 1, 4);
        gridPane.add(back, 2 ,4);
        gridPane.setStyle("-fx-background-color: #556B2F;");
        
        
        Scene scene = new Scene(gridPane, 800, 550);
        stage.setScene(scene);
        stage.show();
    }

    public static void depunereMeniu() {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        Button back = new Button("Inapoi");
        back.setOnAction(e -> {
                MeniuPrincipal.meniu();
                stage.close();
         });
        Text sumadLabel = new Text("Suma");
        TextField sumadField = new TextField();
        
        Text idLabel = new Text("ID Client");
        TextField idField = new TextField();
        
        Text contLabel = new Text("CNP Client");
        TextField contField = new TextField();
 
        Button depunere = new Button("Depunere numerar");
        depunere.setOnAction(e -> {
            
            if(!contField.getText().matches("(\\d{13})")){
            alert.setContentText("Campul pentru CNP nu este corect completat");
            alert.showAndWait();
            contField.clear();
            sumadField.clear();
            return;
            }
            
            if(!idField.getText().matches("[0-9]*")){
                alert.setContentText("Campul pentru id nu este corect completat");
                alert.showAndWait();
                idField.clear();
                return;
            }
        
            if(!sumadField.getText().matches("[0-9]*")){
            alert.setContentText("Campul pentru suma nu este corect completat");
            alert.showAndWait();
            contField.clear();
            sumadField.clear();
            return;
            }
            
            if(alert.getContentText().length() == 0){
            
                if(verificareCont(contField.getText(), idField.getText())){ 
                    depunere(contField.getText(), idField.getText(), Double.parseDouble(sumadField.getText()));
                    contField.clear();
                    sumadField.clear();
                }
                else{
                    Alert alertw = new Alert(Alert.AlertType.WARNING);
                    alertw.setContentText("CNP-ul sau id-ul introdus nu este valid");
                    alertw.showAndWait();
                    contField.clear();
                    sumadField.clear();
                    }
            }
        });
        
        
        
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800, 800);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(contLabel, 0, 1);
        gridPane.add(contField, 1, 1);
        gridPane.add(idLabel, 0, 2);
        gridPane.add(idField, 1, 2);
        gridPane.add(sumadLabel, 0, 3);
        gridPane.add(sumadField, 1, 3);
        gridPane.add(depunere, 1, 4);
        gridPane.add(back, 2 ,4);
        gridPane.setStyle("-fx-background-color: #556B2F;");
        Scene scene = new Scene(gridPane, 800, 550);
        stage.setScene(scene);
        stage.show();
        
         }

    public static void transferMeniu() {
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        Button back = new Button("Inapoi");
        back.setOnAction(e -> {
                MeniuPrincipal.meniu();
                stage.close();
         });          
        
        Text contLabel = new Text("De la");
        TextField contField = new TextField();
        
        Text idLabel = new Text("ID Cont");
        TextField idField = new TextField();
        
        Text sumaLabel = new Text("Suma");
        TextField sumaField = new TextField();
        
        Text cont1Label = new Text("Catre");
        TextField cont1Field = new TextField();;
        
        Text id1Label = new Text("ID Cont");
        TextField id1Field = new TextField();
        
        Button transfer = new Button("Transfer numerar");
        transfer.setOnAction(e -> {
            
            if(!contField.getText().matches("(\\d{13})")){
            alert.setContentText("Campul pentru CNP nu este corect completat");
            alert.showAndWait();
            contField.clear();
            return;
            }
            
            if(!cont1Field.getText().matches("(\\d{13})")){
            alert.setContentText("Campul pentru CNP nu este corect completat");
            alert.showAndWait();
            cont1Field.clear();
            return;
            }
            
            if(!idField.getText().matches("[0-9]*")){
            alert.setContentText("Campul pentru id nu este corect completat");
            alert.showAndWait();
            idField.clear();
            return;
            }
            
            if(!id1Field.getText().matches("[0-9]*")){
            alert.setContentText("Campul pentru id nu este corect completat");
            alert.showAndWait();
            id1Field.clear();
            return;
            }
        
            if(!sumaField.getText().matches("[0-9]*")){
            alert.setContentText("Campul pentru suma nu este corect completat");
            alert.showAndWait();
            sumaField.clear();
            return;
            }
            
            if(alert.getContentText().length() == 0){
            
                if(verificareCont(contField.getText(), idField.getText())&& verificareCont(cont1Field.getText(), id1Field.getText())){
                    transfer(contField.getText(),cont1Field.getText(), idField.getText(), id1Field.getText(), Integer.parseInt(sumaField.getText()));
                    contField.clear();
                    cont1Field.clear();
                    idField.clear();
                    id1Field.clear();
                    sumaField.clear();
                }
                else{
                    Alert alertw = new Alert(Alert.AlertType.WARNING);
                    alertw.setContentText("CNP-ul sau id-ul introdus nu este valid");
                    alertw.showAndWait();
                    contField.clear();
                    cont1Field.clear();
                    sumaField.clear();
                }
            }
         });
        
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800, 800);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(contLabel, 0, 1);
        gridPane.add(contField, 1, 1);
        gridPane.add(cont1Label, 0, 3);
        gridPane.add(cont1Field, 1, 3);
        gridPane.add(idLabel, 0, 2);
        gridPane.add(idField, 1, 2);
        gridPane.add(id1Label, 0, 4);
        gridPane.add(id1Field, 1, 4);
        gridPane.add(sumaLabel, 0, 5);
        gridPane.add(sumaField, 1, 5);
        gridPane.add(transfer, 1, 6);  
        gridPane.add(back, 2 ,6);
        gridPane.setStyle("-fx-background-color: #556B2F;");
       
        Scene scene = new Scene(gridPane, 800, 550);
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void retragere(String cnp, String id, double soldRetras){
        
	double soldCurent = 0;
	try{
		Connection conn = DataBaseLogin.connector();
		
		PreparedStatement ps=conn.prepareStatement("select sold from client where cnp=? and id = ?");
		ps.setString(1,cnp);
                ps.setString(2, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			soldCurent = rs.getDouble("sold");
		}
		double soldNou =  (soldRetras + (0.5*soldRetras)/100);
		if(soldCurent > soldNou){
		PreparedStatement ps2=conn.prepareStatement("update client set sold=? where cnp=? and id = ?");
		ps2.setDouble(1,soldCurent - soldNou);
		ps2.setString(2,cnp);
                ps2.setString(3,id);
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
    
    public static void depunere(String cnp, String id, double soldAdaugat){
        
	double soldCurent = 0;
	try{
		Connection conn = DataBaseLogin.connector();
		
		PreparedStatement ps=conn.prepareStatement("select sold from client where cnp=? and id = ?");
		ps.setString(1,cnp);
                ps.setString(2,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			soldCurent = rs.getDouble("sold");
		}
		PreparedStatement ps2=conn.prepareStatement("update client set sold=? where cnp=? and id = ?");
		ps2.setDouble(1,soldCurent + soldAdaugat);
		ps2.setString(2,cnp);
                ps2.setString(3,id);
		ps2.executeUpdate();
                Alert alertSucces = new Alert(Alert.AlertType.INFORMATION);
                alertSucces.setContentText("Operatiunea a fost realizata");
                alertSucces.showAndWait();
		
		conn.close();
	}catch(Exception e){System.out.println(e);}
        
    }
    
    public static void transfer(String cnp1, String cnp2, String id1, String id2, double soldRetras){
        
	double soldCurent = 0;
        double soldCurent2 = 0;
	try{
		Connection conn = DataBaseLogin.connector();
		
		PreparedStatement ps=conn.prepareStatement("select sold from client where cnp=? and id = ?");
                PreparedStatement ps1=conn.prepareStatement("select sold from client where cnp=? and id = ?");
		ps.setString(1,cnp1);
                ps.setString(2,id1);
                ps1.setString(1,cnp2);
                ps1.setString(2,id2);
		ResultSet rs=ps.executeQuery();
                ResultSet rs1=ps1.executeQuery();
		if(rs.next() && rs1.next()){
			soldCurent = rs.getDouble("sold");
                        soldCurent2 = rs1.getDouble("sold");
		}
		double soldNou = (soldRetras + (0.2*soldRetras)/100);
		if(soldCurent > soldNou){
		PreparedStatement ps2=conn.prepareStatement("update client set sold=? where cnp=? and id = ?");
                PreparedStatement ps3=conn.prepareStatement("update client set sold=? where cnp=? and id = ?");
		ps2.setDouble(1,soldCurent - soldNou);
		ps2.setString(2,cnp1);
                ps2.setString(3,id1);
                ps3.setDouble(1,soldCurent2 + soldRetras);
                ps3.setString(2,cnp2);
                ps3.setString(3,id2);
		ps2.executeUpdate();
                ps3.executeUpdate();
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
    
    public static boolean verificareCont(String cnp, String id){   
        boolean status=false;
	try{
            Connection conn = DataBaseLogin.connector();
            PreparedStatement ps=conn.prepareStatement("select * from client where cnp=? and id = ?");
            ps.setString(1,cnp);
            ps.setString(2,id);
	    ResultSet rs=ps.executeQuery();
            status=rs.next();
            conn.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
    
}
