package usbharu.genshintoolsplugin;

import usbharu.genshintools.gui.IContentPane;
import usbharu.genshintools.main.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPlugin implements IContentPane {
	JPanel contentPane = new JPanel();

	public TestPlugin(){
		JButton button = new JButton("back");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.main();
			}
		});
		contentPane.add(button);
	}

	@Override
	public JPanel getContentPane() {
		return contentPane;
	}

	@Override
	public String getName() {
		return "test";
	}
}