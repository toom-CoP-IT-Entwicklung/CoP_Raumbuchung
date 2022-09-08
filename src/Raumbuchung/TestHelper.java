package Raumbuchung;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;


public class TestHelper {
	
	public static void help() {
		
		//InsertBuchung();
		line();
		System.out.println("Buchungen");
		line();
		ReadBuchungen();
		System.out.println();
		
		line();
		System.out.println("Mitarbeiter");
		line();
		ReadMitarbeiter();
		System.out.println();
		
		line();
		System.out.println("Räume");
		line();
		ReadRäume();
		
	}
	
	private static void ReadBuchungen() {
		DataReader DR = new DataReader();
		LocalDate date = LocalDate.of(2022, 9, 5);
		
		//ResultSet Buchungen = DR.ReadBuchungen(date);
		//ResultSet Buchungen = DR.ReadBuchungen(1);
		ResultSet Buchungen = DR.ReadBuchungen();
		
		try {
			while (Buchungen.next()) {
			    Date datum = Buchungen.getDate("Datum");
			    int raum = Buchungen.getInt("RaumID");
			    int mitarbeiter = Buchungen.getInt("MitarbeiterID");
			    
			     
			    System.out.println(datum + ", " + raum + ", " + mitarbeiter);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void InsertBuchung() {
		try {
			//String databaseURL = "jdbc:ucanaccess://K://OR-KOE-BM//ENTW//EPT Markt//IT-Verkauf//00 Mitarbeiter//Denise Thomas//Raumbuchung.accdb";
			String databaseURL = "jdbc:ucanaccess://C://Users//A163C9A//Desktop//CoP-Raumbuchung//Backup DB//Raumbuchung.accdb";
        	Connection connection = DriverManager.getConnection(databaseURL);

            // Temp
        	String tempsql = "INSERT INTO Buchungstabelle (Datum, RaumID, MitarbeiterID) VALUES (?, ?, ?)";
            PreparedStatement tempstatement = connection.prepareStatement(tempsql);
            LocalDate date = LocalDate.now();
            tempstatement.setString(1, date.toString());
            tempstatement.setString(2, "2");
            tempstatement.setString(3, "2");
            int temprow = tempstatement.executeUpdate();
            if (temprow > 0) {
            	System.out.println("Der Satz wurde eingefügt");	
            }
            // Temp
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
	}
	
	private static void ReadMitarbeiter( ) {
		DataReader DR = new DataReader();
		ResultSet mitarbeiter = DR.ReadMitarbeiter();
		try {
			
		
		while (mitarbeiter.next()) {
			int id = mitarbeiter.getInt("Mitarbeiter_ID");
			String vorname = mitarbeiter.getString("Vorname");
			String nachname = mitarbeiter.getString("Nachname");
			
			System.out.println(id + "," + vorname + "," + nachname);

		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void ReadRäume() {
		DataReader DR = new DataReader();
		ResultSet räume = DR.ReadRäume();
		try {
			while(räume.next()) {
				int id = räume.getInt("ID");
				String raum = räume.getString("RaumNr");
				int maxBelegung = räume.getInt("MaxBelegung");
				
				System.out.println(id + "," + raum + "," + maxBelegung);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void line(){
		System.out.println("---------------------------------------------------------");
	}

}
