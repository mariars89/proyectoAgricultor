package runnable;

//El hilo encargado de recolectar melones. 
//Usa la interfaz Recoleccion.
public class Melon implements Runnable {
    
    // Atributos
    private Recoleccion parcela;
    private String hiloMelon; 

    // Constructor
    public Melon(Recoleccion parcela, String nombre) {
        this.parcela = parcela;
        this.hiloMelon = nombre;
    }

    @Override
    public void run() {
        
    	// El ciclo se ejecuta mientras haya melones
        while (true) {
            System.out.println(hiloMelon + " está recogiendo melones.");
            
            if (!parcela.recogerMelon()) {
                break;
            }
            System.out.println("Recogiendo un melón.");
        }
        System.out.println(hiloMelon + " ha terminado de recoger melones.");
    }
}