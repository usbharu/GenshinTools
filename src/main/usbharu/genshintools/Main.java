package usbharu.genshintools;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("ResinCounter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		frame.setContentPane(new ResinCounter().contentPane);
		frame.pack();
		frame.setVisible(true);
	}
}