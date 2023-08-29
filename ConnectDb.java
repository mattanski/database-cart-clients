package com.casa.esercitazione.database1.com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;


public class ConnectDb {

	private final String url = "jdbc:postgresql://localhost:5432/db_bari";					//dobbiamo usare un url predefinto 
	private final String user = "postgres";												// se avremmo usato sql avremmo inserito mysql
	private final String password = "password";
	
	private ArrayList<Persona> personaList;
	
	private final String insertPersonaSQL = "INSERT INTO persone (nome, cognome) VALUES (?,?);";    //insert da java
	
	public Connection connect() {
		
		this.personaList = new ArrayList<Persona>();
		Connection connessione = null;
		
		try {	 // il try-catch non ha bisogno di if, e se va in errore bugga anche alla prima linea
			
			connessione = DriverManager.getConnection(url, user, password);
			System.out.println("Connessione riuscita");
			
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
			System.err.println("CONNESSIONE NON RIUSCITA");
			
			return connessione;
			
		}
		return connessione;
		
	}

	
	
	public void getPersone(String query) {
	
		String querySql = query;
		
		try {
			Connection connessione = connect();
			Statement stmt = connessione.createStatement();     
			ResultSet rs = stmt.executeQuery(querySql); 
			System.out.println("Query eseguita correttamente");
			this.personaList=addPersonaList(rs);		// popolami la lista
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.err.println("Query non eseguita correttamente");
		}
		
		System.out.println(this.personaList.toString());
	}
	
	
	// ci ritornerà  una lista (è come un metodo statico perchè lo utlizzeremo solo all'interno di altri metodi come quello che sta sopra)
	
	public ArrayList<Persona> addPersonaList(ResultSet rs) throws SQLException{
		
		  ArrayList<Persona>  personaList = new ArrayList<Persona>();
		
		while(rs.next()){  					 // next() andrà a prenderci uno alla volta gli elementi che sono presenti nel Result Set
			Persona p = new Persona();
			p.setNome(rs.getString("nome"));
			p.setCognome(rs.getString("cognome"));
			p.setDataNascita(rs.getString("dataNascita"));
			p.setGenere(rs.getString("genere"));
			p.setLuogoNascita(rs.getString("luogoNascita"));
			p.setCodiceFiscale(rs.getString("codiceFiscale"));
			
			
			personaList.add(p);
		}
		
		return personaList;
	}
	
	
	public void insertRecordPersone(String nome,String cognome) {
		
		try {
			Connection connessione = connect();
			PreparedStatement  prdStmt = connessione.prepareStatement(insertPersonaSQL);
			prdStmt.setString(1, nome);
			prdStmt.setString(2, cognome);
			prdStmt.executeUpdate();
			System.out.println("Insert eseguito correttamente");
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			System.err.println("Insert non eseguita correttamente");
			
		}
		
	}
	
	public void insertRecordsPersone(ArrayList<Persona> personaList) {
		
		int count = 0;
		
		try {
			Connection connessione = connect();
			PreparedStatement  prdStmt = connessione.prepareStatement(insertPersonaSQL);
			for (Persona persona : personaList) {
				prdStmt.setString(1, persona.getNome());
				prdStmt.setString(2, persona.getCognome());
				
				prdStmt.addBatch();   // ci serve per inserire all'interno dello Stmt
				count++;
				
				if(count == personaList.size()) {
					prdStmt.executeBatch();
				}
				
			}
			
			
			System.out.println("Insert records  eseguito correttamente");
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			System.err.println("Insert records non eseguita correttamente");
			
		}
		
	}
	
}
	
	
	
