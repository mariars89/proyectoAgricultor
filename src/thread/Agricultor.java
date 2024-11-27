package thread;


//El programa principal que inicializa los recursos y lanza los hilos.
public class Agricultor {
    
	public static void main(String[] args) {
        
		// Inicializa la parcela con 10 pepinos y 5 melones
        Parcela parcela = new Parcela(10, 5);

        // Crea hilos para recoger pepinos y melones con nombres personalizados
        Pepino hiloPepinos = new Pepino(parcela, "Hilo de Pepinos");
        Melon hiloMelones = new Melon(parcela, "Hilo de Melones");

        // Inicia los hilos
        hiloPepinos.start();
        hiloMelones.start();

        // Espera a que ambos hilos terminen
        try {
            hiloPepinos.join();
            hiloMelones.join();
        
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("Recolección completada. Todos los productos han sido recogidos.");
        System.out.println("-----------------------------------------------------------------");
    }
}