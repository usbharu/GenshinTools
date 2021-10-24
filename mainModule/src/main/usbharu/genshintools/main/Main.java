package usbharu.genshintools.main;

import usbharu.genshintools.gui.IContentPane;
import usbharu.genshintools.plugin.PluginLoader;
import usbharu.genshintools.resin.ResinCounter;
import usbharu.genshintools.shield.CharacterShieldCal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
	public static JFrame frame = new JFrame("ResinCounter");
	public static MainForm mainForm = new MainForm();
	public static void main(String[] args) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(false);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		frame.setPreferredSize(new Dimension(640,480));
		frame.setContentPane(mainForm.contentPane);
		PluginLoader pluginLoader = new PluginLoader();
		ArrayList<IContentPane> pluginList = pluginLoader.getPlugins();
		for (IContentPane contentPane : pluginList) {
			JButton button = new JButton(contentPane.getName());
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					create(contentPane);
				}
			});
			frame.getContentPane().add(button);
		}
		frame.pack();
		frame.setVisible(true);
	}

	public static void createResinCounter() {
		frame.setContentPane(new ResinCounter().contentPane);
		frame.revalidate();
		frame.repaint();
	}

	public static void createShieldCounter() {
		frame.setContentPane(new CharacterShieldCal().getContentPane());
		frame.revalidate();
		frame.repaint();
	}

	public static void main(){
		frame.setContentPane(mainForm.contentPane);
	}

	public static void create(IContentPane contentPane){
		frame.setContentPane(contentPane.getContentPane());
		frame.revalidate();
		frame.repaint();
	}
}