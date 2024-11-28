package thread;


//El programa principal que inicializa los recursos y lanza los hilos.
public class Main {
    
	public static void main(String[] args) {
        
		// Crear la parcela compartida
		Parcela parcela = new Parcela();

        // Crear los hilos para producir pepinos, melones y realizar la recolección
        Pepino productorPepinos = new Pepino(parcela);
        Melon productorMelones = new Melon(parcela);
        Agricultor consumidor = new Agricultor(parcela);

        // Iniciar los hilos 
        productorPepinos.start();
        productorMelones.start();
        consumidor.start();

        try {
        	// Esperar a que terminen los tres hilos
            productorPepinos.join();
            productorMelones.join();
            consumidor.join();
        
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------------------------");
        System.err.println("Pepinos recogidos: " + parcela.getPepinosPlantados());
        System.out.println("----------------------------------------------------");
        System.err.println("Melones recogidos: " + parcela.getMelonesPlantados());
        System.out.println("----------------------------------------------------");
    }
}