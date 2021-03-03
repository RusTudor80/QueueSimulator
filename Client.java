public class Client {
	protected int nr;
	private int ajuns;
	private int servit;
	
	public Client(int nr, int ajuns, int servit) {
		this.nr = nr;
		this.ajuns = ajuns;
		this.servit = servit;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}
	

	public int getAjuns() {
		return ajuns;
	}

	public void setAjuns(int ajuns) {
		this.ajuns = ajuns;
	}

	public int getServit() {
		return servit;
	}

	public void setServit(int servit) {
		this.servit = servit;
	}

	public String toString() {
		return "Clientul numarul " + this.getNr() + " a ajuns la timpul : " + this.getAjuns() + "s, si a fost servit in: " + this.getServit() + "s\n";
	}

}
