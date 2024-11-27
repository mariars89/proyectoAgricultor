package monitores;

public class Parcela {

	private int numPepinos = 0;

	private int numMelones = 0;

	private int pepinosPlantados = 0;

	private int melonesPlantados = 0;

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
		while (recogiendo == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
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
