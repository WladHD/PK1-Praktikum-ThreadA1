package de.wlad;

import javafx.application.Application;
import javafx.stage.Stage;
import pk1.gui.util.MessageView;

public class Zeitansage extends Application implements TimerListener {
	
	private int sekunden = 0;
	
	public static void main(String...strings) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		Thread t = new Thread(new Timer(this));
		t.start();
		MessageView.create(stage, "Message", "Zeitansage stoppen").showView();
		t.interrupt();
	}

	@Override
	public void signalPerformed() {
		System.out.printf("%d Sekunden seit Start%n", sekunden++);
	}
	
}
