package runnable;

// Clase Productor de pepinos que implementa Runnable
public class Pepino implements Runnable {
  
    // Atributos
    private Parcela zonaCompartida;

    // Constructor
    public Pepino(Parcela zonaCompartida) {
        this.zonaCompartida = zonaCompartida;
    }

    @Override
    public void run() {
        // Mientras no haya 50 pepinos plantados, el hilo seguirá ejecutando el crecimiento
        while (zonaCompartida.getPepinosPlantados() < 50) {
            
            try {
                // Simula el crecimiento de pepinos (duerme por un tiempo aleatorio)
                Thread.sleep((long) (Math.random() * 500));
                zonaCompartida.crecerPepino();
            
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
