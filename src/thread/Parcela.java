package thread;


//La clase Parcela implementa la interfaz Recoleccion. 
//Gestiona los recursos de pepinos y melones con lógica básica para recolección.

public class Parcela implements Recoleccion {
    
	//Atributos
	private int pepinos;
    private int melones;

    
    //Constructor
    public Parcela(int pepinos, int melones) {
        this.pepinos = pepinos;
        this.melones = melones;
    }

    //Método para recoger pepinos
    @Override
    public boolean recogerPepinos() {
        
    	if (pepinos > 0) {
            System.out.println("Recogiendo varios pepinos.");
            pepinos--;
            
            try {
                Thread.sleep(500); // Simula el tiempo de recolección de pepinos
            
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("Terminó de recoger pepinos. Pepinos restantes: " + pepinos);
            return true;
        }
        return false;
    }

    
    //Método para recoger melones
    @Override
    public boolean recogerMelon() {
        
    	if (melones > 0) {
            
    		System.err.println("Recogiendo un melón.");
            melones--;
            
            try {
                Thread.sleep(1000); // Simula el tiempo de recolección de melones
            
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.err.println("Terminó de recoger un melón. Melones restantes: " + melones);
            return true;
        }
        return false;
    }
}
