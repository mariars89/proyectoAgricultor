package runnable;


//El programa principal que inicializa los recursos y lanza los hilos.
public class Main {

	 public static void main(String[] args) {
	
	     // Crear la parcela compartida
	     Parcela parcela = new Parcela();
	
	     // Crear los objetos que implementan Runnable
	     Runnable productorPepinos = new Pepino(parcela);
	     Runnable productorMelones = new Melon(parcela);
	     Runnable consumidor = new Agricultor(parcela);
	
	     // Crear los hilos, pasándoles los objetos Runnable
	     Thread hiloPepinos = new Thread(productorPepinos);
	     Thread hiloMelones = new Thread(productorMelones);
	     Thread hiloConsumidor = new Thread(consumidor);
	
	     // Iniciar los hilos
	     hiloPepinos.start();
	     hiloMelones.start();
	     hiloConsumidor.start();
	
	     try {
	         // Esperar a que terminen los tres hilos
	         hiloPepinos.join();
	         hiloMelones.join();
	         hiloConsumidor.join();
	
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }
	
	     // Mostrar resultados
	     System.out.println("----------------------------------------------------");
	     System.err.println("Pepinos recogidos: " + parcela.getPepinosPlantados());
	     System.out.println("----------------------------------------------------");
	     System.err.println("Melones recogidos: " + parcela.getMelonesPlantados());
	     System.out.println("----------------------------------------------------");
	 }
}

