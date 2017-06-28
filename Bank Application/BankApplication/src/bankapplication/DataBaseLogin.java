/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseLogin {

    public static Connection connector() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/banca?autoReconnect=true&useSSL=false", "root", "db1948");
        
            return con2;
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return null;
        }
    }
    
    public static boolean administratorLogin(String nume, String parola) {

        Connection connection;
        connection = connector();
        PreparedStatement ps = null;
        ResultSet rst = null;
        String query2 = "select * from admin where Nume = ? and Parola = ?";

        try {
            ps = connection.prepareStatement(query2);
            ps.setString(1, nume);
            ps.setString(2, parola);
            rst = ps.executeQuery();
            if (rst.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            try {
                rst.close();
                ps.close();
            } catch (Exception e) {
            }
        }
    }
    
    public static boolean clientLogin(String cnp, String id, String parola) {

        Connection connection;
        connection = connector();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query = "select * from client where cnp = ? and id = ? and parola = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cnp);
            preparedStatement.setString(2, id);
            preparedStatement.setString(3, parola);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (Exception e) {
            }
        }
    }
}