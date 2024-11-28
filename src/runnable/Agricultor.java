package runnable;

//Clase Consumidor, implementando la interfaz Runnable
public class Agricultor implements Runnable {
 
	 // Atributos
	 private Parcela zonaCompartida;
	
	 // Constructor
	 public Agricultor(Parcela zonaCompartida) {
	     this.zonaCompartida = zonaCompartida;
	 }

 
	 @Override
	 public void run() {
	     
	     // El agricultor seguirá trabajando hasta que se hayan recogido al menos 50 pepinos y 20 melones
	     while (zonaCompartida.getPepinosPlantados() < 50 || zonaCompartida.getMelonesPlantados() < 20) {
	         
	         zonaCompartida.recogerPepinos();
	         zonaCompartida.recogerMelon();
	         
	         // Espera aleatoria entre 0 y 1500 ms para simular el tiempo que el agricultor tarda 
	         // en hacer otras tareas
	         try {
	             Thread.sleep((long) (Math.random() * 1500));  
	         
	         } catch (InterruptedException e) {
	             e.printStackTrace();
	         }
	     }
	 }
}