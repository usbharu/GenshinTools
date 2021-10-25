package usbharu.genshintoolsplugin.expectationvaluecal;

import usbharu.genshintools.gui.IContentPane;
import usbharu.genshintools.main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ExpectationValueForm implements IContentPane {
	private final List<InputPanel> inputPanelList = new ArrayList<>();
	private JPanel contentPane;
	private JPanel mainPanel;
	private JButton backButton;
	private JPanel listPanel;
	private JLabel description;

	public ExpectationValueForm() {
		$$$setupUI$$$();
		backButton.addActionListener(new ActionListener() {
			/**
			 * Invoked when an action occurs.
			 *
			 * @param e the event to be processed
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.main();
			}
		});
	}

	private void createUIComponents() {
		listPanel = new JPanel(new GridLayout(5, 0));
		inputPanelList.add(new InputPanel(this));
		listPanel.add(inputPanelList.get(0));
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		createUIComponents();
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(0, 0));
		contentPane.add(mainPanel, BorderLayout.CENTER);
		final JScrollPane scrollPane1 = new JScrollPane();
		mainPanel.add(scrollPane1, BorderLayout.CENTER);
		scrollPane1.setViewportView(listPanel);
		description = new JLabel();
		description.setText("攻撃力、会心率、会心ダメージの組み合わせで期待値を算出します。");
		mainPanel.add(description, BorderLayout.NORTH);
		backButton = new JButton();
		backButton.setText("back");
		contentPane.add(backButton, BorderLayout.NORTH);
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return contentPane;
	}

	@Override
	public JPanel getContentPane() {
		return contentPane;
	}

	@Override
	public String getName() {
		return "ExpectationValueCal";
	}

	public void recalculation() {
		int trueCount = 0;
		for (int j = 0, inputPanelListSize = inputPanelList.size(); j < inputPanelListSize; j++) {
			InputPanel i = inputPanelList.get(j);
			if (i.isUse()) {
				trueCount++;
				if (trueCount >= inputPanelList.size()) {
					System.out.println("add");
					inputPanelList.add(new InputPanel(this));
					listPanel.add(inputPanelList.get(inputPanelList.size() - 1));
					listPanel.repaint();
					listPanel.revalidate();
					break;
				}
			}
		}
	}

	class InputPanel extends JPanel {
		private final ExpectationValueForm expectationValueForm;
		private final JLabel atkLabel = new JLabel("ATK");
		private final JLabel criticalRateLabel = new JLabel("CriticalRate");
		private final JLabel criticalDamageLabel = new JLabel("CriticalDamage");
		private final JTextField expectationValue = new JTextField();
		private boolean wasUse = false;
		private int atk = 0;
		private final JFormattedTextField atkInput = new JFormattedTextField(atk);
		private float criticalRate = 0.05f;
		private final JFormattedTextField criticalRateInput = new JFormattedTextField(criticalRate);
		private float criticalDamage = 50f;
		private final JFormattedTextField criticalDamageInput = new JFormattedTextField(criticalDamage);

		{
			atkInput.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					wasUse = true;
					setExpectationValue();
					expectationValueForm.recalculation();
				}
			});
			criticalRateInput.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					wasUse = true;
					setExpectationValue();
					expectationValueForm.recalculation();
				}
			});
			criticalDamageInput.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					wasUse = true;
					setExpectationValue();
					expectationValueForm.recalculation();
				}
			});
			add(atkLabel);
			add(atkInput);
			add(criticalRateLabel);
			add(criticalRateInput);
			add(criticalDamageLabel);
			add(criticalDamageInput);
			add(expectationValue);
			setExpectationValue();
		}

		public InputPanel(ExpectationValueForm expectationValueForm) {
			super(new GridLayout(1, 0));
			this.expectationValueForm = expectationValueForm;
		}

		public InputPanel(ExpectationValueForm expectationValueForm, int atk, float criticalRate, float criticalDamage) {
			super(new GridLayout(1, 0));
			this.expectationValueForm = expectationValueForm;
			this.atk = atk;
			this.criticalRate = criticalRate;
			this.criticalDamage = criticalDamage;
		}

		public boolean isUse() {
			return wasUse;
		}

		public void setUse(boolean wasUse) {
			this.wasUse = wasUse;
		}

		private int calExpectationValue() {
			return (int) ExpectationValueCal.calExpectationValue(Integer.parseInt(atkInput.getText()), Float.parseFloat(criticalRateInput.getText()), Float.parseFloat(criticalDamageInput.getText()));
		}

		private void setExpectationValue() {
			expectationValue.setText(String.valueOf(calExpectationValue()));
		}
	}
}