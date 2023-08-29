package com.casa.esercitazione.database1.com;



public class Persona {

	private String nome;
	private String cognome;
	private String dataNascita;
	private String genere;
	private String luogoNascita;
	private String codiceFiscale;
	
	
	public Persona(String nome,String cognome) {
		this.nome = nome;
		this.cognome = cognome;
		
	}
	
	public Persona() {
		
	}
	
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getLuogoNascita(String luogoNascita) {
		return luogoNascita;
	}
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	@Override
	public String toString() {
		return nome + " "  + cognome + " nata/o il giorno " + dataNascita + " di sesso " + genere + " con codice fiscale " + codiceFiscale + " città di nascita " + luogoNascita;		
	}
	
	
}
