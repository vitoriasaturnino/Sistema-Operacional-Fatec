package mutex_java;

import java.util.concurrent.Semaphore;

public class Connection {

	private static Connection instance = new Connection();

	private Semaphore semaphore = new Semaphore(10, true);

	int connections = 0;

	private Connection() {

	}

	public static Connection getInstance() {
		return instance;
	}

	public void connect() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		try {
			doconnect();
		} finally {
			semaphore.release();
		}
	}

	public void doconnect() {

		try {

			semaphore.acquire();
		} catch (InterruptedException e1) {
			System.out.println("aqui 2");
			e1.printStackTrace();
		}

		synchronized (this) {
			this.connections++;
			System.out.println("Current connections: " + this.connections);
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (this) {
			this.connections--;
		}
	}
}
