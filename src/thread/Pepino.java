package thread;

// Clase Productor de pepinos
public class Pepino extends Thread {
  	
	//Atributos
	private Parcela zonaCompartida;

    //Constructor
	public Pepino(Parcela zonaCompartida) {
        this.zonaCompartida = zonaCompartida;
    }

    public void run() {
        
    	// Mientras no haya 50 pepinos plantados, el hilo seguirá ejecutando el crecimiento
    	while (zonaCompartida.getPepinosPlantados() < 50) {
            
    		try {
                sleep((long) (Math.random() * 500)); // Simula el crecimiento de pepinos
                zonaCompartida.crecerPepino();
            
    		} catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

