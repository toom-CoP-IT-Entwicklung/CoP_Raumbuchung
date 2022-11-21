package Raumbuchung;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class DataReader {
	private String databaseURL = "jdbc:ucanaccess://K://OR-KOE-BM//ENTW//EPT Markt//IT-Verkauf//00 Mitarbeiter//Denise Thomas//Raumbuchung.accdb";
	//private String databaseURL = "jdbc:ucanaccess://C://Users//A163C9A//Desktop//CoP-Raumbuchung//Backup DB//Raumbuchung.accdb";
	private String sql;
	private ResultSet results;
	
	private String buchselect = "SELECT * FROM Buchungstabelle";
	private String mitarselect = "SELECT * FROM Mitarbeiter";
	private String raumselect = "SELECT * FROM Räume";
	

	private ResultSet ReadData (String _sql) {
		try (Connection connection = DriverManager.getConnection(databaseURL)) {
	         
	        Statement statement = connection.createStatement();
	        ResultSet result = statement.executeQuery(_sql);
	        return result;
	         
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		return null; //sollte nur bei DB Exception auftreten #Test Test3
		//Test4
		//Nein, Test 5°!
		//Test6 Bene  #erledigt
	

	}
	
	

	
	/**
	 * Alle Buchungen lesen
	 */
	public ResultSet ReadBuchungen() {
		sql = buchselect;
		results = ReadData(sql);
		return results;
	}
	
	/**
	 * Alle Buchungen zu einem Datum lesen
	 * @param _date ( Datum, zu dem die Buchungen gelesen werden )
	 */
	public ResultSet ReadBuchungen(LocalDate _date) {
		sql = buchselect + " WHERE Datum = '" + _date.toString() + "'";
		results = ReadData(sql);
		return results;
	}
	
	/**
	 * Alle Buchungen zu einem Raum lesen
	 * @param _raumID ( RaumID, zu dem die Buchungen gelesen werden )
	 */
	public ResultSet ReadBuchungen(int _raumID) {
		sql = buchselect + " WHERE RaumID = " + _raumID;
		results = ReadData(sql);
		return results;
	}
	
	/**
	 * Alle Buchungen zu einem Raum, an einem bestimmten Datum lesen
	 * @param _date ( Datum der Buchung )
	 * @param _raumID ( ID des Raums )
	 */
	public ResultSet ReadBuchungen(LocalDate _date, int _raumID) {
		sql = buchselect + " WHERE Datum = '" + _date.toString() + "'" + " AND RaumID = " + _raumID;
		results = ReadData(sql);
		return results;
	}
	
	/**
	 *  Eine Buchung anhand der BuchungsID lesen.
	 *  Diese Methode wird nie ein Mensch brauchen...
	 * @param _buchungsID
	 */
	public ResultSet ReadBuchung(int _buchungsID) {
		sql = buchselect + " WHERE ID = " + _buchungsID;
		results = ReadData(sql);
		return results;
	}
	
	
	
	
	/**
	 * Alle Mitarbeiter lesen
	 */
	public ResultSet ReadMitarbeiter() {
		sql = mitarselect;
		results = ReadData(sql);
		return results;
	}
	
	/**
	 * Mitarbeiter anhand ID lesen
	 * @param _mitarbeiterID
	 */
	public ResultSet ReadMitarbeiter(int _mitarbeiterID) {
		sql = mitarselect + " WHERE Mitarbeiter_ID = " + _mitarbeiterID;
		results = ReadData(sql);
		return results;
	}
	
	/**
	 * Alle Räume lesen
	 */
	public ResultSet ReadRäume() {
		sql = raumselect;
		results = ReadData(sql);
		return results;
	}
	
	/**
	 * Raum anhand ID lesen
	 * @param _raumID
	 */
	public ResultSet ReadRaum(int _raumID) {
		sql = raumselect + " WHERE ID = " + _raumID;
		results = ReadData(sql);
		return results;
	}

}
