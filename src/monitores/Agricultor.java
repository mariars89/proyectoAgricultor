package monitores;

public class Agricultor extends Thread {
	
	private Parcela zonaCompartida;
	
	public Agricultor(Parcela zonaCompartida){
		this.zonaCompartida=zonaCompartida;
	}
	
	public void run() {
		while(zonaCompartida.getPepinosPlantados()<50 && zonaCompartida.getMelonesPlantados()<20) {
			try {
				// Espera un tiempo aleatorio y se pone a recoger el cultivo 
				sleep((long) (Math.random()*2000+500));
				// Señala que va a recoger
				zonaCompartida.setRecogiendo(true);
				// Mientras haya cultivo que recoger, va a recoger
				do {
					zonaCompartida.recoger();
				}while(zonaCompartida.getPepinos()>0 || zonaCompartida.getMelones()>0);
				// Señala que dejo de recoger
				zonaCompartida.setRecogiendo(false);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
