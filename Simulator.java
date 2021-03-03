import static java.lang.System.exit;
import java.util.ArrayList;

public class Simulator implements Runnable {
	
	int nrClienti, timpDeSimulare, timpMaximDeSimulare;
	ArrayList<RunServer> servers;
	ArrayList<Client> clienti;
	
	public Simulator(ArrayList<RunServer> servers, ArrayList<Client> clienti, int timpMaximDeSimulare) {
		this.servers = servers;
		this.clienti = clienti;
		this.nrClienti = clienti.size();
		this.timpDeSimulare = -1;
		this.timpMaximDeSimulare = timpMaximDeSimulare;
	}

	
	private RunServer findMinWaitingTQ() {
		RunServer minim = this.servers.get(0);
		int marime = this.servers.size();

		for (int i = 1; i < marime; ++i) {
			if (minim.getServer().getTimpDeAsteptare() > this.servers.get(i).getServer().getTimpDeAsteptare()) {
				minim = this.servers.get(i);
				}
			}
		return minim;
		}

	public void updateClienti() {
		for (RunServer server : servers) {
			if (server.getServer().getClienti().isEmpty()) {
				server.setStandby(true);
			} else {
				server.setQuit(false);
			}
		}
	}

	public double computeAvgWaitingT() {
		double timpAsteptare = 0;

		for (RunServer server : this.servers) {
			timpAsteptare = timpAsteptare+server.getServer().getTimpDeAsteptare();
		}

		timpAsteptare = timpAsteptare/nrClienti;
		return timpAsteptare;
	}

	public boolean isEmptySimulation() {
		for (RunServer server : this.servers) {
			if (server.getServer().getClienti().isEmpty()==false) {
				return false;
			}
		}
		return true;
	}

	public void quitServersAll() {
		for (RunServer server : servers) {
			server.setQuit(true);
		}
	}

	@Override
	public void run() {
		while (true) {
			timpDeSimulare++;
			System.out.println("Timp: " + timpDeSimulare+"s");

			if (timpDeSimulare > timpMaximDeSimulare) {
				System.out.println("Timpul de simulare a depasit limita.");
				quitServersAll();
				System.out.println("Timpul mediu de asteptare:" + computeAvgWaitingT());
				exit(0);
			} 

			updateClienti();
			
			if (this.clienti.size()==0) {
				System.out.println("Toti clientii au fost procesati.");
				quitServersAll();
				System.out.println("Timpul mediu de asteptare :" + computeAvgWaitingT());
				exit(0);
			}
			else
				;

			if (clienti.get(0).getAjuns() <= timpDeSimulare) {
				RunServer minim = findMinWaitingTQ();
				minim.getServer().setTimpDeAsteptare(minim.getServer().getTimpDeAsteptare() + timpDeSimulare - clienti.get(0).getAjuns());
				minim.getServer().addClient(clienti.get(0));
				System.out.println(clienti.get(0)+"A ajuns la coada la timpul :"+timpDeSimulare+"s");
				clienti.remove(0);
				}
		}
	}
}