package usbharu.resincal;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("ResinCounter");
		frame.setContentPane(new ResinCounter().contentPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
}