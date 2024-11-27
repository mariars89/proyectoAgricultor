package runnable;


//El hilo encargado de recolectar pepinos. 
//Utiliza la interfaz Recoleccion para operar sobre los recursos.
public class Pepino implements Runnable {
    
    // Atributos
    private Recoleccion parcela;
    private String hiloPepino; 

    // Constructor
    public Pepino(Recoleccion parcela, String nombre) {
        this.parcela = parcela;
        this.hiloPepino = nombre;
    }

    @Override
    public void run() {
        
    	// El ciclo se ejecuta mientras haya pepinos
        while (true) {
            System.out.println(hiloPepino + " está recogiendo pepinos.");
            
            if (!parcela.recogerPepinos()) {
                break;
            }
            System.out.println("Recogiendo varios pepinos.");
        }
        System.out.println(hiloPepino + " ha terminado de recoger pepinos.");
    }
}