public class Input{

	private int nrClienti, Q, t_max_simulation, minAjuns, maxAjuns, minServit, maxServit;

	public int getNrClienti() {
		return nrClienti;
	}

	public void setNrClienti(int nrClienti) {
		this.nrClienti = nrClienti;
	}

	public int getQ() {
		return Q;
	}

	public void setQ(int q) {
		Q = q;
	}

	public int getT_max_simulation() {
		return t_max_simulation;
	}

	public void setT_max_simulation(int t_max_simulation) {
		this.t_max_simulation = t_max_simulation;
	}

	public int getMinAjuns() {
		return minAjuns;
	}

	public void setMinAjuns(int minAjuns) {
		this.minAjuns = minAjuns;
	}

	public int getMaxAjuns() {
		return maxAjuns;
	}

	public void setMaxAjuns(int maxAjuns) {
		this.maxAjuns = maxAjuns;
	}

	public int getMinServit() {
		return minServit;
	}

	public void setMinServit(int minServit) {
		this.minServit = minServit;
	}

	public int getMaxServit() {
		return maxServit;
	}

	public void setMaxServit(int maxServit) {
		this.maxServit = maxServit;
	}

	public String toString() {
		return "nrClienti: " + this.nrClienti + "\nnrCozi: " + this.Q + "\nTimpul maxim de simulare: " + this.t_max_simulation
				+ "\nTimpul minim de ajungere: " + this.minAjuns + "\nTimpul maxim de ajungere: " + this.maxAjuns
				+ "\nTimpul minim de servire: " + this.minServit + "\nTimpul maxim de servire: " + this.maxServit + "\n";
	}
}
