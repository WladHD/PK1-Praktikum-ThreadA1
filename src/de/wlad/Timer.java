package de.wlad;

public class Timer implements Runnable {
	
	private TimerListener listener;
	
	public Timer(TimerListener listener) {
		this.listener = listener;
	}

	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			listener.signalPerformed();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("interrupted");
				Thread.currentThread().interrupt();
			}
		}
	}

}
