package monitores;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parcela parcela = new Parcela();
		
		Melon melon = new Melon(parcela);
		Pepino pepino = new Pepino(parcela);
		Agricultor agricultor = new Agricultor(parcela);
		
		pepino.start();
		melon.start();
		agricultor.start();
		
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
