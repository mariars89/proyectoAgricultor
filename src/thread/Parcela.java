package thread;


// Sirve como contenedor para almacenar la cantidad de pepinos y melones.
//Zona Crítica (recursos compartidos)

public class Parcela {
    
	//Atributos
	private int numPepinos = 0; // Número de pepinos disponibles para la recolección.
    private int numMelones = 0;
    private int pepinosPlantados = 0;
    private int melonesPlantados = 0;

   
    // Método para simular el crecimiento de un pepino en la parcela
    public void crecerPepino() {
        
    	System.out.println("Ha crecido un pepino");
        numPepinos++;
        pepinosPlantados++;
    }

    // Método para simular el crecimiento de un melón en la parcela
    public void crecerMelon() {
        
    	System.out.println("Ha crecido un melón");
        numMelones++;
        melonesPlantados++;
    }

    
    // Método para simular la recolección de pepinos
    public void recogerPepinos() {
        
    	if (numPepinos > 0) {
            
    		System.out.println("----------------------------------------------------");
    		System.out.println("Agricultor ha recogido " + numPepinos + " pepinos");
    		System.out.println("----------------------------------------------------");
            numPepinos = 0;
        }
    }

    // Método para simular la recolección de melones
    public void recogerMelon() {
        
    	if (numMelones > 0) {
            
    		System.out.println("----------------------------------------------------");
    		System.out.println("Agricultor ha recogido un melón");
    		System.out.println("----------------------------------------------------");
            numMelones--;
        }
    }
    
    //Getters
    public int getPepinos() {
        return numPepinos;
    }

    public int getMelones() {
        return numMelones;
    }

    public int getPepinosPlantados() {
        return pepinosPlantados;
    }

    public int getMelonesPlantados() {
        return melonesPlantados;
    }
}