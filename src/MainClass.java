
import view.MainWindow;
import java.awt.EventQueue;

import javax.swing.*;

public class MainClass {

	public static void createGUI() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		MainWindow main = new MainWindow();
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			try {
				createGUI();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}

