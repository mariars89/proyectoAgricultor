package monitores;

public class Pepino extends Thread {
	
	private Parcela zonaCompartida;
	
	public Pepino(Parcela zonaCompartida) {
		this.zonaCompartida=zonaCompartida;
	}
	
	public void run() {
		while(zonaCompartida.getPepinosPlantados()<50) {
			try {
				sleep((long) (Math.random()*500));
				zonaCompartida.crecerPepino();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
