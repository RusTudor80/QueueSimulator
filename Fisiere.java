import java.io.File;
import java.util.Scanner;

public class Fisiere {
	String input;
	private Scanner cititor;
	public Fisiere(String input) {
		this.input=input;
	}
	public void openInputFile() {
		try {
			cititor = new Scanner(new File("In-Test-1.txt"));
		} catch (Exception e) {
			System.out.println("ERROR: Fisierul nu se poate deschide.");
		}
	}
		public Input readInputFile() {
			
		Input input = new Input();

		input.setNrClienti(cititor.nextInt());
		input.setQ(cititor.nextInt());
		input.setT_max_simulation(cititor.nextInt());
		String aux;
		int delimitator;
		aux = cititor.next();
		delimitator = aux.indexOf(",");

		input.setMinAjuns(Integer.parseInt(aux.substring(0, delimitator)));
		input.setMaxAjuns(Integer.parseInt(aux.substring(delimitator + 1, aux.length())));

		aux = cititor.next();
		delimitator = aux.indexOf(",");

		input.setMinServit(Integer.parseInt(aux.substring(0, delimitator)));
		input.setMaxServit(Integer.parseInt(aux.substring(delimitator + 1, aux.length())));

		return input;
	}
	
	public void closeInputFile() {
		cititor.close();
	}
}
