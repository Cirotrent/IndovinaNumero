package it.polito.tdp.indonumero;

import java.security.InvalidParameterException;

public class Model {

	private int NMAX=100;
	private int TMAX=7;
	
	private int tentativi;
	private int numeroSegreto;
	
	private boolean inGame=false;
	
	public boolean isInGame() {// equivalente del metodo getInGame
		return inGame;
	}

	public Model() {
		this.inGame=false;
	}
	/**
	 * Avvia una nuova partita, generando un nuovo numero segreto.
	 */
	public void newGame() {
		tentativi=0;
    	numeroSegreto=(int) (Math.random()*NMAX)+1;
    	inGame=true;
    	
	}
	
	/**
	 * Fai un tentativo di indovinare il numero segreto
	 * @param t   valore numerico del tentativo
	 * @return	  0 se hai indovinato, +1 se è troppo grande, -1 se è troppo piccolo
	 */
	public int tentativo(int t) {
		if(!inGame) {
			throw new IllegalStateException("Partita non attiva");
		}
		if(!valoreValido(t)) {
			throw new InvalidParameterException("Tentativo fuori rang");
		}
		
		this.tentativi++;
		if(this.tentativi==this.TMAX) {
			this.inGame=false;
		}
		
		if(t==this.numeroSegreto) {
			this.inGame=false;
			return 0;
			}
		if(t<this.numeroSegreto)
			return -1;
		return +1;
					
		
	}
	/**
	 * Controlla se il tentativo fornito rispetta le regole formali del 
	 * gioco cioè nel range da 1 a NMAX
	 * @param tentativo
	 * @return {@code true} se il tentativo e valido
	 */
	public  boolean  valoreValido(int tentativo) {
		return tentativo>=1 && tentativo<=this.NMAX;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getTentativi() {
		return tentativi;
	}
	
	public int Segreto() {
		return this.numeroSegreto;
	}
}
