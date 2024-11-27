package monitores;

public class Agricultor extends Thread {
	
	private Parcela zonaCompartida;
	
	public Agricultor(Parcela zonaCompartida){
		this.zonaCompartida=zonaCompartida;
	}
	
	public void run() {
		while(zonaCompartida.getPepinosPlantados()<50 && zonaCompartida.getMelonesPlantados()<20) {
			try {
				sleep((long) (Math.random()*2000+500));
				zonaCompartida.setRecogiendo(true);
				do {
					zonaCompartida.recoger();
				}while(zonaCompartida.getPepinos()>0 || zonaCompartida.getMelones()>0);
				zonaCompartida.setRecogiendo(false);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
