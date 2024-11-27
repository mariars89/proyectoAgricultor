package runnable;


//El programa principal que inicializa los recursos y lanza los hilos.
public class Agricultor {
    
public static void main(String[] args) {
        
        // Inicializa la parcela con 10 pepinos y 5 melones
        Parcela parcela = new Parcela(10, 5);

        // Crea objetos Runnable para los hilos de pepinos y melones
        Pepino hiloPepinos = new Pepino(parcela, "Hilo de Pepinos");
        Melon hiloMelones = new Melon(parcela, "Hilo de Melones");

        // Crea y lanza los hilos
        Thread hiloDePepinos = new Thread(hiloPepinos);
        Thread hiloDeMelones = new Thread(hiloMelones);

        // Inicia los hilos
        hiloDePepinos.start();
        hiloDeMelones.start();

        // Espera a que ambos hilos terminen
        try {
            hiloDePepinos.join();
            hiloDeMelones.join();
        
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("Recolección completada. Todos los productos han sido recogidos.");
        System.out.println("-----------------------------------------------------------------");
    }
}