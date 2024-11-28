package semaforos;

import java.util.concurrent.Semaphore;

public class Pepino extends Thread{

	private Semaphore mutex, sPepino;
	private Parcela parcela;
	
	public Pepino (Semaphore mutex, Semaphore sPepino, Parcela parcela){
		this.mutex = mutex;
		this.sPepino = sPepino;
		this.parcela = parcela;
	}
	
	public void run() {
		try {
			for (int i = 0; i < 50; i++) {
				sleep((long) (Math.random() * 500));
	            mutex.acquire(); // Espera Mutex.
	            parcela.crecerPepinos(i+1); // Genera un pepino.
	            mutex.release(); // Suelta Mutex.
	            sPepino.release(); // Notifica al agricultor que hay un pepino disponible.
			}
			
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}