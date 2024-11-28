package thread;

//Clase Productor de melones
public class Melon extends Thread {
    
	 //Atributos
	 private Parcela zonaCompartida;

	 //Constructor
	 public Melon(Parcela zonaCompartida) {
		 this.zonaCompartida = zonaCompartida;
	 }
	 
	 
	 public void run() {
		 
		 // El productor de melones sigue creciendo melones hasta que se hayan plantado 20
		 while (zonaCompartida.getMelonesPlantados() < 20) {
			 
			 try {
				 
				 sleep((long) (Math.random() * 1000)); // Simula el crecimiento de melones
	             zonaCompartida.crecerMelon();
	         
			 } catch (InterruptedException e) {
	                e.printStackTrace();
	         }
	     }
	    
	 }

	    
	}