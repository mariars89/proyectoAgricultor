package monitores;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Sección crítica
		Parcela parcela = new Parcela();
		
		// Hilos del programa
		Melon melon = new Melon(parcela);
		Pepino pepino = new Pepino(parcela);
		Agricultor agricultor = new Agricultor(parcela);
		
		// Ejecutamos los hilos
		pepino.start();
		melon.start();
		agricultor.start();
		
		// Esperamos a que los procesos de los hilos acaben para mostrar el número de pepinos y melones recogidos
		try {
			pepino.join();
			melon.join();
			agricultor.join();
			
			System.out.println("Pepinos recogidos: " + parcela.getPepinosPlantados());
			System.out.println("Melones recogidos: " + parcela.getMelonesPlantados());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
