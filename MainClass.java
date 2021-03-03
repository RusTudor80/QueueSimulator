import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;

public class MainClass {
	public static ArrayList<Client> clientRandom(int nrClienti, int t_max_simulation,int minAjuns,int maxAjuns, int minServit,int maxServit) {
		
		ArrayList<Client> clienti = new ArrayList<Client>();
		for (int i = 0; i < nrClienti; i++) {
			Client a= new Client(i, new Random().nextInt(maxAjuns + 1) + minAjuns,new Random().nextInt(maxServit + 1) + minServit);
			clienti.add(a);
		}

		return clienti;
	}

	public static void main(String[] args) throws FileNotFoundException {
		try {
            System.setOut(new PrintStream(new File(args[1])));
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		Fisiere start = new Fisiere(args[0]); 
		Input input = new Input(); 
		start.openInputFile();
		input = start.readInputFile(); 

		RunServer[] runServer = new RunServer[input.getQ()];

		for (int i = 0; i < input.getQ(); ++i) {
			runServer[i] = new RunServer();
		}

		Thread[] thread = new Thread[input.getQ()];

		for (int i = 0; i < input.getQ(); ++i) {
			thread[i] = new Thread(runServer[i]);
			thread[i].start();
		}

		ArrayList<Client> clienti = new ArrayList<Client>();
		clienti = clientRandom(input.getNrClienti(), input.getT_max_simulation(),input.getMinAjuns(), input.getMaxAjuns(), input.getMinServit(), input.getMaxServit());
		clienti.sort(Comparator.comparingInt(Client::getAjuns));
		
		Simulator simulation = new Simulator(new ArrayList<>(Arrays.asList(runServer)), clienti,input.getT_max_simulation());

		Thread t1 = new Thread(simulation);
		t1.start();
	
		}
	}