package monitores;

public class Parcela {

	// Variable que almacena el número de pepinos que están para ser recogidos
	private int numPepinos = 0;

	// Variable que almacena el número de melones que están para ser recogidos
	private int numMelones = 0;

	// Variable que almacena el número de pepinos que han sido plantados en total, recogidos y no recogidos
	private int pepinosPlantados = 0;

	// Variable que almacena el número de melones que han sido plantados en total, recogidos y no recogidos
	private int melonesPlantados = 0;

	// Variable booleana para comprobar si el agricultor esta recogiendo el cultivo o no
	private boolean recogiendo = false;

	public Parcela() {

	}
	
	public int getPepinos() {
		return numPepinos;
	}
	
	public int getMelones() {
		return numMelones;
	}
	
	public void setRecogiendo(boolean b) {
		recogiendo=b;
	}

	public int getPepinosPlantados() {
		return pepinosPlantados;
	}

	public int getMelonesPlantados() {
		return melonesPlantados;
	}

	public void activarRecogiendo() {
		recogiendo=true;
	}

	public synchronized void crecerPepino() {
		// Si recogiendo es verdadero, entonces no puede crecer el pepino
		while (recogiendo == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Ha crecido un pepino");
		numPepinos++;
		pepinosPlantados++;
		
		notify();
	}

	public synchronized void crecerMelon() {
		// Si recogiendo es verdadero, entonces no puede crecer el melón
		while (recogiendo == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Ha crecido un melón");
		numMelones++;
		melonesPlantados++;
		
		notify();
	}

	public synchronized void recoger() {
		// Si recogiendo es falso, entonces el agricultor no puede ponerse a recoger
		while (recogiendo == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			// Comprueba si hay pepinos disponibles para recoger, si los hay los recoge
			// sino, entonces recoge un melón
			if (numPepinos > 0) {
				Thread.sleep((long) (50 * numPepinos));
				System.out.println("El agricultor ha recogido " + numPepinos + " pepinos");
				numPepinos = 0;
			} else{
				Thread.sleep(100);
				System.out.println("El agricultor ha recogido un melón");
				numMelones--;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		notify();
	}

}
