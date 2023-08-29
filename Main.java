package com.casa.esercitazione.database1.com;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		
		ConnectDb connessioneDataBase1 = new ConnectDb();
		
		connessioneDataBase1.connect();
		
		connessioneDataBase1.getPersone("SELECT * FROM  Persone");
		connessioneDataBase1.insertRecordPersone("Giulio", "Bianco");
		connessioneDataBase1.getPersone("SELECT * FROM  Persone");
		
		
		
		
		Persona persona1 = new Persona("Gianluca","Amedeo");
		Persona persona2 = new Persona("Gaetano","Antonelli");
		Persona persona3 = new Persona("Vitangelo","Boccasini");
		
		
		ArrayList<Persona> personaList = new ArrayList<Persona>();
		personaList.add(persona1);
		personaList.add(persona2);
		personaList.add(persona3);
		
		
		connessioneDataBase1.insertRecordsPersone(personaList);
		connessioneDataBase1.getPersone("SELECT * FROM Persone");
		
	}

}
