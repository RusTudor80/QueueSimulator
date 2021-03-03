import java.util.ArrayList;

public class Server {
	private ArrayList<Client> clienti;
	private int timpDeAsteptare;

	public Server() {
		this.clienti = new ArrayList<Client>();
		this.timpDeAsteptare = 0;
	}

	public ArrayList<Client> getClienti() {
		return clienti;
	}

	public void setClienti(ArrayList<Client> clienti) {
		this.clienti = clienti;
	}

	public int getTimpDeAsteptare() {
		return timpDeAsteptare;
	}

	public void setTimpDeAsteptare(int timpDeAsteptare) {
		this.timpDeAsteptare = timpDeAsteptare;
	}

	public void addClient(Client i) {
		this.clienti.add(i);
		this.timpDeAsteptare = this.timpDeAsteptare+i.getServit();
	}

	public void removeClient() {
		if (this.clienti.isEmpty()==false) {
			this.clienti.remove(0);
		}
	}

	public void update() {
		if (this.clienti.isEmpty()) {
			System.out.println("Eroare:Nu sunt clienti in coada.");
		} else {
			this.timpDeAsteptare--;
			this.clienti.get(0).setServit(this.clienti.get(0).getServit() - 1);

			if (this.clienti.get(0).getServit()==0) {
				this.removeClient();
			}
		}
	}
}