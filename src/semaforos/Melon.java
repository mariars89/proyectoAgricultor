package semaforos;

import java.util.concurrent.Semaphore;

public class Melon extends Thread{

	private Semaphore mutex, sMelon;
	private Parcela parcela;
	
	public Melon (Semaphore mutex, Semaphore sMelon, Parcela parcela){
		this.mutex = mutex;
		this.sMelon = sMelon;
		this.parcela = parcela;
	}
	
	public void run() {
		try {
			for (int i = 0; i < 20; i++) {
				sleep((long) (Math.random() * 500));
	            mutex.acquire(); // Espera Mutex.
	            parcela.crecerMelones(i+1); // Genera un melón.
	            mutex.release(); // Suelta Mutex.
	            sMelon.release(); // Notifica al agricultor que hay un melón disponible.
			}
			
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
