package semaforos;

public class Parcela {
	
	private int totalPepinos = 0;
    private int totalMelones = 0; 
    private int pepinosRecogidos = 0;
    private int melonesRecogidos = 0;
    
    public void recogerPepinos() {
    	if (totalPepinos > 0) {
    		System.out.println("Agricultor recoge " + totalPepinos+ " pepinos.");
    		pepinosRecogidos += totalPepinos;
            totalPepinos = 0;
           
        }
    }
    
    public void recogerMelones() {
    	if (totalMelones > 0) { 
            totalMelones--;
            melonesRecogidos++;
            System.out.println("Agricultor recoge 1 melón. Quedan en la parcela: " + totalMelones);
        }
    }
    
    public void crecerPepinos(int n) {
    	System.out.println("Ha crecido el pepino Número " + n);
    	totalPepinos++;
    }
    
    public void crecerMelones(int n) {
    	System.out.println("Ha crecido el melón Número " + n);
    	totalMelones++;
    }
    
    public int getPepinosRecogidos() {
    	return pepinosRecogidos;
    }
    
    public int getMelonesRecogidos() {
    	return melonesRecogidos;
    }
    
    public int getPepinos() {
    	return totalPepinos;
    }
    
    public int getMelones() {
    	return totalMelones;
    }
}
