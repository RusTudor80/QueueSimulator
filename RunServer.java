import static java.lang.Thread.sleep;

public class RunServer implements Runnable {
	private Server server;
	private boolean standby;
	private boolean quit;

	public RunServer() {
		this.server = new Server();
		this.standby = true;
		this.quit = false;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public boolean isStandby() {
		return standby;
	}

	public void setStandby(boolean standby) {
		this.standby = standby;
	}

	public boolean isQuit() {
		return quit;
	}

	public void setQuit(boolean quit) {
		this.quit = quit;
	}

	@Override
	public void run() {
		while (quit==false) {
			while(standby==true)
				try {
					sleep(100);
				} catch (InterruptedException e) {
					System.out.println("ERROR: sleep");
				}
			}
			server.update();
		}
	}
