package usbharu.genshintools.main;

import javax.swing.*;
import java.awt.*;

public class MainForm {
	public JPanel contentPane;
	JPanel mainPanel;

	public MainForm() {

	}

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(0, 0));
		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.setMinimumSize(new Dimension(640, 480));
		contentPane.setPreferredSize(new Dimension(640, 480));
		mainPanel.add(contentPane, BorderLayout.NORTH);
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return mainPanel;
	}

}