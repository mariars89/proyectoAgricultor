package runnable;

//Clase Productor de melones, implementando la interfaz Runnable
public class Melon implements Runnable {
 
	 // Atributos
	 private Parcela zonaCompartida;
	
	 // Constructor
	 public Melon(Parcela zonaCompartida) {
	     this.zonaCompartida = zonaCompartida;
	 }
 
 
	 @Override
	 public void run() {
	     
	     // El productor de melones sigue creciendo melones hasta que se hayan plantado 20
	     while (zonaCompartida.getMelonesPlantados() < 20) {
	         
	         try {
	             // Simula el crecimiento de melones
	             Thread.sleep((long) (Math.random() * 1000)); 
	             zonaCompartida.crecerMelon();
	         
	         } catch (InterruptedException e) {
	             e.printStackTrace();
	         }
	     }
	 }


}