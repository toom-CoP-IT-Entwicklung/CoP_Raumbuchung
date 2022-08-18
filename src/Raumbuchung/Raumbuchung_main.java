package Raumbuchung;

import java.sql.*;

public class Raumbuchung_main {
	
	public static void main(String[] args) {
		
	
	String databaseURL = "jdbc:ucanaccess://K://OR-KOE-BM//ENTW//EPT Markt//IT-Verkauf//00 Mitarbeiter//Denise Thomas//Raumbuchung.accdb";
    
    try (Connection connection = DriverManager.getConnection(databaseURL)) {
         
         
        String sql = "INSERT INTO Mitarbeiter (Vorname, Nachname) VALUES (?, ?)";
         
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "Christian");
        preparedStatement.setString(2, "Bär");
         
        int row = preparedStatement.executeUpdate();
         
        if (row > 0) {
            System.out.println("A row has been inserted successfully.");
        }
         
        sql = "SELECT * FROM Mitarbeiter";
         
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
         
        while (result.next()) {
            int id = result.getInt("Mitarbeiter_ID");
            String vorname = result.getString("Vorname");
            String nachname = result.getString("Nachname");
             
            System.out.println(id + ", " + vorname + ", " + nachname);
        }
         
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

}
}
