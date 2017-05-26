package club.iothings.data;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnexion {
	
	private String url = "";
	private String database = "";
	private String login = "";
	private String password = "";
	private String version = "";
	
	private Connection dbMySQL = null;
	
	public DataConnexion(){
		
		//----- Affectation des valeurs -----
		setValues();
	}
	
	private void setValues(){
//		url = "jdbc:mysql://www.iothings.club:3306/";
//		database = "db_unsa";
//		login = "alarcon";
//		password = "gunnar30";
		
		url = "jdbc:mysql://127.0.0.1/";
		database = "db_unsa";
		login = "user_unsa";
		password = "unsa";
		
		version = "1.03";
	}
	
	public String start(){
		
		String resultat = "";
		
		try {
			dbMySQL = null;
			
			// --- Tentative de connexion � la base de donn�es ---
			dbMySQL = DriverManager.getConnection( url + database, login, password);
			resultat = "OK";
			
		} catch (Exception ex) {
			dbMySQL = null;
			
			resultat = "ERREUR";
			System.out.println("### DataConnexion ### start ### " + ex.toString());
		}
		
		return resultat;
	}
	
	public Connection getDbMySQL(){
		return dbMySQL;
	}
	
	public String getVersion() {
		return version;
	}
	
	public String getDbName(){
		return database;
	}
}
