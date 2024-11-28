package semaforos;

import java.util.concurrent.Semaphore;

public class Agricultor extends Thread {

	private Semaphore mutex, sPepino, sMelon;
	private Parcela parcela;

	public Agricultor(Semaphore mutex, Semaphore sPepino, Semaphore sMelon, Parcela parcela) {
		this.mutex = mutex;
		this.sPepino = sPepino;
		this.sMelon = sMelon;
		this.parcela = parcela;
	}

	public void run() {
		while (parcela.getMelonesRecogidos() < 20 || parcela.getPepinosRecogidos() < 50) {
			try {
				// Prioridad a los pepinos
				if (parcela.getPepinos() > 0) {
                    sPepino.acquire();  // Espera a que haya pepinos disponibles.
                    mutex.acquire();    // Espera Mutex.
                    parcela.recogerPepinos();  // Recoge los pepinos disponibles.
                    mutex.release();    // Suelta Mutex.
                } 
				
				if (parcela.getMelones() > 0) {
                    sMelon.acquire();
                    mutex.acquire();
                    parcela.recogerMelones();
                    mutex.release();
                }
				sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}

		System.out.println("SE HAN RECOGIDO TODOS LOS MELONES Y PEPINOS.");
	}
}