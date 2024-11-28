package semaforos;

import java.util.concurrent.Semaphore;

public class Main {

	/**
	 * Parte de Semáforos - Iván Gulín.
	 */
	public static void main(String[] args) throws InterruptedException {

		Semaphore mutex = new Semaphore(1);
		Semaphore sPepino = new Semaphore(0);
		Semaphore sMelon = new Semaphore(0);
		
		Parcela parcela = new Parcela();
		
		
		// Inicio el hilo AGRICULTOR
		Agricultor agricultor = new Agricultor(mutex, sPepino, sMelon, parcela);
		agricultor.start();
		
	
		// Inicio el hilo PEPINO
		Pepino pepino = new Pepino(mutex, sPepino, parcela);
		pepino.start();
	
		// Inicio el hilo MELON
		Melon melon = new Melon(mutex, sMelon, parcela);
		melon.start();
	}
}