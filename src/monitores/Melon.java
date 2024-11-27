package monitores;

public class Melon extends Thread {
	
	private Parcela zonaCompartida;
	
	public Melon(Parcela zonaCompartida) {
		this.zonaCompartida=zonaCompartida;
	}
	
	public void run() {
		while(zonaCompartida.getMelonesPlantados()<20) {
			try {
				sleep((long) (Math.random()*1000));
				zonaCompartida.crecerMelon();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
