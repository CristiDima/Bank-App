/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;





import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Cristian Dima
 */
public class AdaugareClient {
    
    static Stage stage = new Stage();
    
    
    
    static Text numeLabel = new Text("Nume");
    static TextField numeField = new TextField();
        
    static Text prenumeLabel = new Text("Prenume");
    static TextField prenumeField = new TextField();

    static Text cnpLabel = new Text("CNP");
    static TextField cnpField = new TextField();

    static Text localitateLabel = new Text("Localitate");
    static TextField localitateField = new TextField();

    static Text telefonLabel = new Text("Telefon");
    static TextField telefonField = new TextField();
        
    static Text sumaLabel = new Text("Suma depusa");
    static TextField sumaField = new TextField();
   
    public static void adaugareClientMeniu(){
        
        Button adaugaClient = new Button("Adauga Client Nou");
        adaugaClient.setOnAction(e -> {
            adaugareClient();
                });
         
        Button back = new Button("Inapoi");

        
        back.setOnAction(e -> {
            MeniuPrincipal.meniu();
            stage.close();
        });
         
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800, 800);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(numeLabel, 0, 0);
        gridPane.add(numeField, 1, 0);
        gridPane.add(prenumeLabel, 0, 1);
        gridPane.add(prenumeField, 1, 1);
        gridPane.add(cnpLabel,0, 2 );
        gridPane.add(cnpField, 1, 2);
        gridPane.add(localitateLabel, 0, 3);
        gridPane.add(localitateField, 1, 3);
        gridPane.add(telefonLabel, 0, 4);
        gridPane.add(telefonField, 1, 4);
        gridPane.add(sumaLabel,0, 5 );
        gridPane.add(sumaField, 1, 5);
        gridPane.add(adaugaClient, 1, 6);
        gridPane.add(back, 2,6);
        gridPane.setStyle("-fx-background-color: #556B2F;");
        
        
        Scene scene = new Scene(gridPane, 800, 550);
        stage.setScene(scene);
        stage.show();
   
        }
  
    public static void adaugareContMeniu(){
        
        Text cnpLabel = new Text("Introduceti CNP Client");
        TextField cnpField = new TextField();
        
        Text sumaLabel = new Text("Suma depusa");
        TextField sumaField = new TextField();
        
        Button adaugare = new Button("Adaugare Cont");
        Alert alertSucces = new Alert(Alert.AlertType.INFORMATION);
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        adaugare.setOnAction(e -> {
            
            if(!cnpField.getText().matches("(\\d{13})")){
            alert.setContentText("Campul pentru CNP nu este corect completat");
            alert.showAndWait();
            cnpField.clear();
            return;
            }
            
            if(!sumaField.getText().matches("[0-9]*")){
            alert.setContentText("Campul pentru suma nu este corect completat");
            alert.showAndWait();
            sumaField.clear();
            return;
            }
            if(alert.getContentText().length() == 0){
            
                if(verificareCNP(cnpField.getText())){ 
                    adaugaCont(cnpField.getText(), Double.parseDouble(sumaField.getText()));
                    cnpField.clear();
                    sumaField.clear();
                }
                else{
                    Alert alertw = new Alert(Alert.AlertType.WARNING);
                    alertw.setContentText("CNP-ul introdus nu este valid");
                    alertw.showAndWait();
                    cnpField.clear();
                    }
            }
            
            
        });
        
        Button back = new Button("Inapoi");
        
        back.setOnAction(e -> {
            MeniuPrincipal.meniu();
            stage.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800, 800);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #556B2F;");

        gridPane.add(cnpLabel, 0, 0);
        gridPane.add(cnpField, 1, 0);
        gridPane.add(sumaLabel, 0, 1);
        gridPane.add(sumaField, 1, 1);
        gridPane.add(adaugare, 1, 2);
        gridPane.add(back, 2, 2);
        
        Scene scene = new Scene(gridPane, 800, 550);
        stage.setScene(scene);
        stage.showAndWait();
    } 
    
    public static void inchidereContMeniu() {
        
        Text cnpLabel = new Text("Introduceti CNP Client");
        TextField cnpField = new TextField();
        
        Text idLabel = new Text("Introduceti ID-ul Clientului");
        TextField idField = new TextField();
        
        Button sterge = new Button("Inchide Cont");
        Alert alertSucces = new Alert(Alert.AlertType.INFORMATION);
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        
        sterge.setOnAction(e -> {
            
            if(!cnpField.getText().matches("(\\d{13})")){
            alert.setContentText("Campul pentru CNP nu este corect completat");
            alert.showAndWait();
            cnpField.clear();
            return;
            }
            
            if(idField.getText().isEmpty()){
            alert.setContentText("Campul pentru ID nu este corect completat");
            alert.showAndWait();
            idField.clear();
            return;
            }
            if(alert.getContentText().length() == 0){
            
                if(TranzactiiCont.verificareCont(cnpField.getText(), idField.getText())){ 
                    inchidereCont(cnpField.getText(), idField.getText());
                    cnpField.clear();
                    idField.clear();
                }
                else{
                    Alert alertw = new Alert(Alert.AlertType.WARNING);
                    alertw.setContentText("CNP-ul introdus nu este valid");
                    alertw.showAndWait();
                    cnpField.clear();
                    idField.clear();
                    }
            }
        });
        
        Button back = new Button("Inapoi");
        
        back.setOnAction(e -> {
            MeniuPrincipal.meniu();
            stage.close();
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(800, 800);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #556B2F;");

        gridPane.add(cnpLabel, 0, 0);
        gridPane.add(cnpField, 1, 0);
        gridPane.add(idLabel, 0, 1);
        gridPane.add(idField, 1, 1);
        gridPane.add(sterge, 1, 3);
        gridPane.add(back, 2, 3);
        
        Scene scene = new Scene(gridPane, 800, 550);
        stage.setScene(scene);
        stage.showAndWait();
    }
    
    public static void adaugareClient(){
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        String nume, prenume, cnp, localitate, telefon,  parola;
        double suma;
        parola = setareParola();
        if(numeField.getText().isEmpty()){
            alert.setContentText("Campul pentru nume nu este corect completat");
            alert.showAndWait();
            return;
        }
        else nume = numeField.getText();
        
        if(prenumeField.getText().isEmpty()){
            alert.setContentText("Campul pentru prenume nu este corect completat");
            alert.showAndWait();
            return;
        }
        else prenume = prenumeField.getText();
        
        if(!cnpField.getText().matches("(\\d{13})")){
    
            alert.setContentText("Campul pentru CNP nu este corect completat");
            alert.showAndWait();
             return;
        }
        else cnp = cnpField.getText();
        
        if(verificareCNP(cnpField.getText())){
    
            alert.setContentText(prenumeField.getText() + " " + numeField.getText() +  " este deja client al bancii");
            alert.showAndWait();
             return;
        }

        
        if(localitateField.getText().isEmpty()){
            alert.setContentText("Campul pentru localitate nu este corect completat");
            alert.showAndWait();
            return;
        }
        else localitate = localitateField.getText();
        
        if(!telefonField.getText().matches("(\\d{10})")){
            alert.setContentText("Campul pentru telefon nu este corect completat");
            alert.showAndWait();
            return;
        }
        else telefon = telefonField.getText();
        
        if(!sumaField.getText().matches("[0-9]*")){
            alert.setContentText("Campul pentru suma nu este corect completat");
            alert.showAndWait();
           return;
        }
        else suma = Double.parseDouble(sumaField.getText());

        if(alert.getContentText().length() == 0){
            Alert alertSucces = new Alert(Alert.AlertType.INFORMATION);
            alertSucces.setContentText("Contul clientului " + numeField.getText() + " " + prenumeField.getText() + " a fost creat");
            alertSucces.showAndWait();
            cnpField.clear();
            numeField.clear();
            prenumeField.clear();
            telefonField.clear();
            localitateField.clear();
            sumaField.clear();
            
                Connection conn = DataBaseLogin.connector();
                PreparedStatement psm;
            try {
                psm = conn.prepareStatement("INSERT INTO client VALUES (?,?,?,?,?,?,null,?)");
                
                psm.setString(1, cnp);
                psm.setString(2, nume);
                psm.setString(3, prenume);
                psm.setString(4, parola);
                psm.setString(5, localitate);
                psm.setString(6, telefon);
                psm.setDouble(7, suma);
                psm.executeUpdate();
            }catch (SQLException ex) {
                System.out.println("Error:" + ex);
            }
        }
    }  
 
    public static void adaugaCont(String cnp, double suma){
        
        String nume = "", prenume = "", localitate = "", telefon = "";
        String parola = setareParola();
        try{
		Connection conn = DataBaseLogin.connector();
		
		PreparedStatement ps=conn.prepareStatement("select nume, prenume, oras, telefon from client where cnp=?");
		ps.setString(1,cnp);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
		
                    nume = rs.getString("nume");
                    prenume = rs.getString("prenume");
                    localitate = rs.getString("oras");
                    telefon = rs.getString("telefon");
                    PreparedStatement psm = null;
                    psm = conn.prepareStatement("INSERT INTO client VALUES (?,?,?,?,?,?,null,?)");
                
                    psm.setString(1, cnp);
                    psm.setString(2, nume);
                    psm.setString(3, prenume);
                    psm.setString(4, parola);
                    psm.setString(5, localitate);
                    psm.setString(6, telefon);
                    psm.setDouble(7, suma);
                    psm.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Contul clientului " + nume + " " + prenume + " a fost deschis");
                    alert.showAndWait();
		}
		conn.close();
	}catch(Exception e){System.out.println(e);}
    }
    
    public static void inchidereCont(String cnp, String id) {
        
        double sold = 0;
        String sql = "DELETE FROM client WHERE CNP = ? and id = ?";
        String sql2 = "SELECT sold FROM client WHERE CNP = ? and id = ?";
        Connection conn = DataBaseLogin.connector();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps.setString(1, cnp);
            ps.setString(2, id);
            ps2.setString(1, cnp);
            ps2.setString(2, id);
            ResultSet rs=ps2.executeQuery();
            if(rs.next()){
                sold = rs.getDouble("sold");
            }
                if(sold < 50){
                ps.executeUpdate();
                ps.close();
                Alert alertSucces = new Alert(Alert.AlertType.INFORMATION);
                alertSucces.setContentText("Contul a fost inchis");
                alertSucces.showAndWait();
                }
                else{
                    Alert alertWarning = new Alert(Alert.AlertType.INFORMATION);
                    alertWarning.setContentText("Atentie, sold prea mare");
                    alertWarning.showAndWait();
                }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        
    }
    
    public static void listaClienti() {
        
        TableView <Client> tabel = new TableView();
        
        TableColumn coloanaCNP = new TableColumn("CNP");
        TableColumn coloanaNume = new TableColumn("Nume");
        TableColumn coloanaPrenume = new TableColumn("Prenume");
        TableColumn coloanaParola = new TableColumn("Parola");
        TableColumn coloanaOras = new TableColumn("Localitate");
        TableColumn coloanaTelefon = new TableColumn("Telefon");
        TableColumn coloanaID = new TableColumn("ID");
        TableColumn coloanaSold = new TableColumn("Sold");
        
        tabel.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POL‌​ICY);

        
        coloanaCNP.setCellValueFactory(new PropertyValueFactory<>("CNP"));
        coloanaNume.setCellValueFactory(new PropertyValueFactory<>("Nume"));
        coloanaPrenume.setCellValueFactory(new PropertyValueFactory<>("Prenume"));
        coloanaParola.setCellValueFactory(new PropertyValueFactory<>("Parola"));
        coloanaOras.setCellValueFactory(new PropertyValueFactory<>("Oras"));
        coloanaTelefon.setCellValueFactory(new PropertyValueFactory<>("Telefon"));
        coloanaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        coloanaSold.setCellValueFactory(new PropertyValueFactory<>("Sold"));
        
        ObservableList<Client> data;
            Connection conn = DataBaseLogin.connector();
            data = FXCollections.observableArrayList();
            try {
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM client");
                while (rs.next()) {
                    data.add(new Client(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
                }
            } catch (SQLException ex) {
                System.out.println("Error:" + ex);
            }
        tabel.setItems(data);
        
        tabel.setEditable(true);
        tabel.getColumns().addAll(coloanaCNP, coloanaNume, coloanaPrenume, coloanaParola, coloanaOras, coloanaTelefon, coloanaID, coloanaSold);
        
        Button back = new Button("Inapoi");
        back.setOnAction(e -> {
            MeniuPrincipal.meniu();
            tabel.getColumns().clear();
            stage.close();
        });
   
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(tabel, back);

        Scene scene = new Scene(new Group(), 800, 550);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();
        }
    
    public static String setareParola(){
        
        String parola = "";
        Random rand = new Random();

        for(int i = 0; i < 4; i++){
                parola += ((Integer)rand.nextInt(10)).toString() ;
        }
        return parola;
    }
    
    public static boolean verificareCNP(String cnp){   
        boolean status=false;
	try{
            Connection conn = DataBaseLogin.connector();
            PreparedStatement ps=conn.prepareStatement("select * from client where cnp=?");
            ps.setString(1,cnp);
	    ResultSet rs=ps.executeQuery();
            status=rs.next();
            conn.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
   
}