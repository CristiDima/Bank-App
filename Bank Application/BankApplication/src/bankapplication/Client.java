/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Cristian Dima
 */
public class Client {
    
    private final StringProperty CNP;
    private final StringProperty Nume;
    private final StringProperty Prenume;
    private final StringProperty Parola;
    private final StringProperty Localiate;
    private final StringProperty Telefon;
    private final StringProperty id;
    private final DoubleProperty Sold;

    public Client(String CNP, String Nume, String Prenume, String Parola, String Localiate, String Telefon, String id, double Sold) {
        this.Nume = new SimpleStringProperty(Nume);
        this.Parola = new SimpleStringProperty(Parola);
        this.Prenume = new SimpleStringProperty(Prenume);
        this.Localiate= new SimpleStringProperty(Localiate);
        this.Telefon = new SimpleStringProperty(Telefon);
        this.CNP = new SimpleStringProperty(CNP);
        this.Sold = new SimpleDoubleProperty(Sold);
        this.id = new SimpleStringProperty(id);
        
    }

    public String getCNP() { return CNP.get(); }

    public String getNume() { return Nume.get(); }

    public String getParola() { return Parola.get(); }

    public String getPrenume() { return Prenume.get(); }
    
    public String getId() { return id.get(); }

    public String getOras() { return Localiate.get(); }

    public String getTelefon() { return Telefon.get(); }

    public Double getSold() { return Sold.get(); }
    
    public void setCNP(String value) { CNP.setValue(value); }

    public void setNume(String value) { Nume.setValue(value); }

    public void setParola(String value) { Parola.setValue(value);}

    public void setPrenume(String value) { Prenume.setValue(value);}
    
    public void setId(String value) { id.setValue(value);}

    public void setOras(String value) { Localiate.setValue(value); }

    public void setTelefon(String value) { Telefon.setValue(value); }
    
    public void setSold(Integer value) { Sold.setValue(value); }
  
    public StringProperty cnpProperty() { return CNP; }

    public StringProperty numeProperty() { return Nume; }

    public StringProperty parolaProperty() { return Parola; }

    public StringProperty prenumeProperty() { return Prenume; }
    
    public StringProperty IdProperty() { return id; }

    public StringProperty orasProperty() { return Localiate; }

    public StringProperty telefonProperty() { return Telefon; }
    
    public DoubleProperty soldProperty() { return Sold; }
    
    
}
