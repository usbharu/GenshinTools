package usbharu.genshintoolsplugin.shield.character;

import usbharu.genshintools.gui.IContentPane;
import usbharu.genshintoolsplugin.shield.ShieldCal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class Thoma implements IContentPane {
	private final String NAME = "Thoma";
	private JFormattedTextField hpInput;
	private JTextField skillBaseShield;
	private JFormattedTextField skillInput;
	private JFormattedTextField shieldIncreasesInput;
	private JTextField skillFinalShield;
	private JTextField skillMaxShield;
	private JFormattedTextField burstInput;
	private JTextField burstBaseShield;
	private JTextField burstFinalShield;
	private JTextField skillDMGAbsorptionPer;
	private JTextField skillDMGAbsorption;
	private JTextField skillMaxDMGAbsorptionPer;
	private JTextField burstDMGAbsorptionPer;
	private JTextField burstDMGAbsorption;
	private JLabel thomaLabel;
	private JTextField skillMaxDMGAbsorption;
	private JCheckBox pyroSelect;
	private JPanel contantPane;
	private int skillShield;
	private int burstShield;
	private int skillMaxShieldAnInt;

	public Thoma() {
		$$$setupUI$$$();
		hpInput.addActionListener(new ActionListener() {
			/**
			 * Invoked when an action occurs.
			 *
			 * @param e the event to be processed
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				calShield();
				setShield();
				setTalents();
			}
		});
		skillInput.addActionListener(new ActionListener() {
			/**
			 * Invoked when an action occurs.
			 *
			 * @param e the event to be processed
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				calShield();
				setShield();
				setTalents();
			}
		});
		burstInput.addActionListener(new ActionListener() {
			/**
			 * Invoked when an action occurs.
			 *
			 * @param e the event to be processed
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				calShield();
				setShield();
				setTalents();
			}
		});
		shieldIncreasesInput.addActionListener(new ActionListener() {
			/**
			 * Invoked when an action occurs.
			 *
			 * @param e the event to be processed
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				calShield();
				setShield();
				setTalents();
			}
		});
	}

	/**
	 * Returns a string representation of the object. In general, the
	 * {@code toString} method returns a string that
	 * "textually represents" this object. The result should
	 * be a concise but informative representation that is easy for a
	 * person to read.
	 * It is recommended that all subclasses override this method.
	 * <p>
	 * The {@code toString} method for class {@code Object}
	 * returns a string consisting of the name of the class of which the
	 * object is an instance, the at-sign character `{@code @}', and
	 * the unsigned hexadecimal representation of the hash code of the
	 * object. In other words, this method returns a string equal to the
	 * value of:
	 * <blockquote>
	 * <pre>
	 * getClass().getName() + '@' + Integer.toHexString(hashCode())
	 * </pre></blockquote>
	 *
	 * @return a string representation of the object.
	 */
	@Override
	public String toString() {
		return NAME;
	}

	void calShield() {
		int hp = Integer.parseInt(hpInput.getText());
		int skill = Integer.parseInt(skillInput.getText());
		int burst = Integer.parseInt(burstInput.getText());
		int increases = Integer.parseInt(shieldIncreasesInput.getText());
		skillShield = ShieldCal.shieldStrength(NAME, "skill_", hp, skill, increases);
		skillMaxShieldAnInt = ShieldCal.shieldStrength(NAME, "skill_max_", hp, skill, increases);
		burstShield = ShieldCal.shieldStrength(NAME, "burst_", hp, burst, increases);
	}

	void setShield() {
		skillBaseShield.setText(String.valueOf(skillShield));
		float finalSkillShieldStrength = skillShield;
		if (pyroSelect.isSelected()) {
			finalSkillShieldStrength *= 2.5;
		}
		skillFinalShield.setText(String.valueOf(finalSkillShieldStrength));
		skillMaxShield.setText(String.valueOf(skillMaxShieldAnInt));
		burstBaseShield.setText(String.valueOf(burstShield));
		float finalBurstShieldStrength = burstShield;
		if (pyroSelect.isSelected()) {
			finalBurstShieldStrength *= 2.5;
		}
		burstFinalShield.setText(String.valueOf(finalBurstShieldStrength));
	}

	void setTalents() {
		skillDMGAbsorptionPer.setText(String.valueOf(ShieldCal.talentsPercent(NAME, "skill_", Integer.parseInt(skillInput.getText()))));
		skillDMGAbsorption.setText(String.valueOf(ShieldCal.talentsValue(NAME, "skill_", Integer.parseInt(skillInput.getText()))));
		skillMaxDMGAbsorptionPer.setText(String.valueOf(ShieldCal.talentsPercent(NAME, "skill_max_", Integer.parseInt(skillInput.getText()))));
		skillMaxDMGAbsorption.setText(String.valueOf(ShieldCal.talentsValue(NAME, "skill_max_", Integer.parseInt(skillInput.getText()))));
		burstDMGAbsorptionPer.setText(String.valueOf(ShieldCal.talentsPercent(NAME, "burst_", Integer.parseInt(burstInput.getText()))));
		burstDMGAbsorption.setText(String.valueOf(ShieldCal.talentsValue(NAME, "burst_", Integer.parseInt(burstInput.getText()))));
	}

	private void createUIComponents() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.Thoma");
		thomaLabel = new JLabel(resourceBundle.getString("nameLang"));
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
		contantPane = new JPanel();
		contantPane.setLayout(new GridBagLayout());
		contantPane.setFocusable(false);
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(thomaLabel, gbc);
		final JPanel spacer1 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(spacer1, gbc);
		final JLabel label1 = new JLabel();
		label1.setFocusable(false);
		label1.setText("HP");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label1, gbc);
		hpInput = new JFormattedTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(hpInput, gbc);
		final JLabel label2 = new JLabel();
		label2.setFocusable(false);
		label2.setText("base Shield");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label2, gbc);
		skillBaseShield = new JTextField();
		skillBaseShield.setColumns(8);
		skillBaseShield.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(skillBaseShield, gbc);
		skillInput = new JFormattedTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(skillInput, gbc);
		shieldIncreasesInput = new JFormattedTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(shieldIncreasesInput, gbc);
		final JLabel label3 = new JLabel();
		label3.setFocusable(false);
		label3.setText("Skill Talents");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label3, gbc);
		final JLabel label4 = new JLabel();
		label4.setFocusable(false);
		label4.setText("Shield Increases");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label4, gbc);
		final JLabel label5 = new JLabel();
		label5.setFocusable(false);
		label5.setText("Burst Talents");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label5, gbc);
		burstInput = new JFormattedTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(burstInput, gbc);
		final JPanel spacer2 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 5;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(spacer2, gbc);
		final JLabel label6 = new JLabel();
		label6.setText("Skil");
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label6, gbc);
		burstBaseShield = new JTextField();
		burstBaseShield.setColumns(8);
		burstBaseShield.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(burstBaseShield, gbc);
		final JLabel label7 = new JLabel();
		label7.setText("Burst");
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label7, gbc);
		final JLabel label8 = new JLabel();
		label8.setFocusable(false);
		label8.setText("DMG Absorption(%)");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label8, gbc);
		skillDMGAbsorptionPer = new JTextField();
		skillDMGAbsorptionPer.setColumns(8);
		skillDMGAbsorptionPer.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(skillDMGAbsorptionPer, gbc);
		final JLabel label9 = new JLabel();
		label9.setFocusable(false);
		label9.setText("DMG Absorption");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label9, gbc);
		skillDMGAbsorption = new JTextField();
		skillDMGAbsorption.setColumns(8);
		skillDMGAbsorption.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(skillDMGAbsorption, gbc);
		final JLabel label10 = new JLabel();
		label10.setFocusable(false);
		label10.setText("Max DMG Absorption(%)");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label10, gbc);
		skillMaxDMGAbsorptionPer = new JTextField();
		skillMaxDMGAbsorptionPer.setColumns(8);
		skillMaxDMGAbsorptionPer.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(skillMaxDMGAbsorptionPer, gbc);
		burstDMGAbsorptionPer = new JTextField();
		burstDMGAbsorptionPer.setColumns(8);
		burstDMGAbsorptionPer.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(burstDMGAbsorptionPer, gbc);
		burstDMGAbsorption = new JTextField();
		burstDMGAbsorption.setColumns(8);
		burstDMGAbsorption.setEditable(false);
		burstDMGAbsorption.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(burstDMGAbsorption, gbc);
		skillMaxDMGAbsorption = new JTextField();
		skillMaxDMGAbsorption.setColumns(8);
		skillMaxDMGAbsorption.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(skillMaxDMGAbsorption, gbc);
		final JLabel label11 = new JLabel();
		label11.setFocusable(false);
		label11.setText("Max DMG Absorption");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label11, gbc);
		pyroSelect = new JCheckBox();
		pyroSelect.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 5;
		contantPane.add(pyroSelect, gbc);
		final JLabel label12 = new JLabel();
		label12.setFocusable(false);
		label12.setText("Pyro");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label12, gbc);
		final JLabel label13 = new JLabel();
		label13.setFocusable(false);
		label13.setText("max Shield");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label13, gbc);
		skillMaxShield = new JTextField();
		skillMaxShield.setColumns(8);
		skillMaxShield.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(skillMaxShield, gbc);
		final JLabel label14 = new JLabel();
		label14.setFocusable(false);
		label14.setText("final Shield");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		contantPane.add(label14, gbc);
		skillFinalShield = new JTextField();
		skillFinalShield.setColumns(8);
		skillFinalShield.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(skillFinalShield, gbc);
		burstFinalShield = new JTextField();
		burstFinalShield.setColumns(8);
		burstFinalShield.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 6;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contantPane.add(burstFinalShield, gbc);
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return contantPane;
	}

	@Override
	public JPanel getContentPane() {
		return contantPane;
	}

	@Override
	public String getName() {
		return "Thoma";
	}
}