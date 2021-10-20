package usbharu.genshintools.main;

import usbharu.genshintools.resin.ResinCounter;
import usbharu.genshintools.shield.CharacterShieldCal;

import javax.swing.*;

public class Main {
	public static JFrame frame = new JFrame("ResinCounter");

	public static void main(String[] args) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		frame.setContentPane(new MainForm().contentPane);
		frame.pack();
		frame.setVisible(true);
	}

	public static void createResinCounter() {
		frame.setContentPane(new ResinCounter().contentPane);
		frame.pack();
		frame.revalidate();
		frame.repaint();
	}

	public static void createShieldCounter() {
		frame.setContentPane(new CharacterShieldCal().contenPane);
		frame.pack();
		frame.revalidate();
		frame.repaint();
	}
}