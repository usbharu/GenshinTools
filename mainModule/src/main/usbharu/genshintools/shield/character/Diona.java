package usbharu.genshintools.shield.character;

import usbharu.genshintools.gui.IContentPane;
import usbharu.genshintools.shield.ShieldCal;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

public class Diona implements IContentPane {
	private JPanel contentPane;
	private JLabel diona;
	private JLabel hp;
	private JFormattedTextField hpInput;
	private JLabel talents;
	private JFormattedTextField talentsInput;
	private JLabel shieldIncreases;
	private JFormattedTextField increasesInput;
	private JTextField baseShield;
	private JTextField finalShield;
	private JLabel baseLabel;
	private JLabel finalLabel;
	private JCheckBox c2Check;
	private JLabel c2CheckLabel;
	private JCheckBox holdCheck;
	private JLabel holdCheckLabel;
	private JTextField basePercentInput;
	private JTextField addValueInput;
	private JLabel percentLabel;
	private JLabel addValue;
	private JLabel cyroLabel;
	private JCheckBox cyroCheck;

	private int shield;

	public Diona() {
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
		talentsInput.addActionListener(new ActionListener() {
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

		increasesInput.addActionListener(new ActionListener() {
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
		c2Check.addActionListener(new ActionListener() {
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
		holdCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				calShield();
				setShield();
				setTalents();
			}
		});
		cyroCheck.addActionListener(new ActionListener() {
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
		calShield();
		setShield();
		setTalents();
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
		return "Diona";
	}

	@Override
	public JPanel getContentPane() {
		return contentPane;
	}

	@Override
	public String getName() {
		return "Diona";
	}


	public void calShield() {
		int hp = Integer.parseInt(hpInput.getText());
		int talents = Integer.parseInt(talentsInput.getText());
		int increases = Integer.parseInt(increasesInput.getText());
		shield = ShieldCal.shieldStrength("resource.Diona", hp, talents, increases);
	}

	public void setShield() {
		baseShield.setText(String.valueOf(shield));
		float finalShieldStrength = shield;
		if (c2Check.isSelected()) {
			finalShieldStrength *= 1.15;
		}
		if (holdCheck.isSelected()) {
			finalShieldStrength *= 1.75;
		}
		if (cyroCheck.isSelected()) {
			finalShieldStrength *= 2.5;
		}
		finalShield.setText(String.valueOf(finalShieldStrength));
	}

	public void setTalents() {
		basePercentInput.setText(String.valueOf(ShieldCal.talentsPercent("resource.Diona", Integer.parseInt(talentsInput.getText()))));
		addValueInput.setText(String.valueOf(ShieldCal.talentsValue("resource.Diona", Integer.parseInt(talentsInput.getText()))));
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
		contentPane.setLayout(new GridBagLayout());
		diona.setEnabled(false);
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		contentPane.add(diona, gbc);
		hp = new JLabel();
		hp.setText("HP");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		contentPane.add(hp, gbc);
		hpInput = new JFormattedTextField();
		hpInput.setColumns(4);
		hpInput.setText("1000");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(hpInput, gbc);
		talents = new JLabel();
		talents.setText("Talents");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		contentPane.add(talents, gbc);
		talentsInput = new JFormattedTextField();
		talentsInput.setColumns(4);
		talentsInput.setText("1");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(talentsInput, gbc);
		shieldIncreases = new JLabel();
		shieldIncreases.setText("ShieldIncreases");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		contentPane.add(shieldIncreases, gbc);
		increasesInput = new JFormattedTextField();
		increasesInput.setColumns(4);
		increasesInput.setText("0");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(increasesInput, gbc);
		baseLabel = new JLabel();
		baseLabel.setText("base Shield");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		contentPane.add(baseLabel, gbc);
		baseShield = new JTextField();
		baseShield.setColumns(8);
		baseShield.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(baseShield, gbc);
		finalLabel = new JLabel();
		finalLabel.setText("final Shield");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		contentPane.add(finalLabel, gbc);
		finalShield = new JTextField();
		finalShield.setColumns(4);
		finalShield.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(finalShield, gbc);
		c2Check = new JCheckBox();
		c2Check.setHorizontalAlignment(0);
		c2Check.setHorizontalTextPosition(0);
		c2Check.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		contentPane.add(c2Check, gbc);
		c2CheckLabel = new JLabel();
		c2CheckLabel.setText("C2");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		contentPane.add(c2CheckLabel, gbc);
		holdCheckLabel = new JLabel();
		holdCheckLabel.setText("Hold");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		contentPane.add(holdCheckLabel, gbc);
		holdCheck = new JCheckBox();
		holdCheck.setHorizontalAlignment(0);
		holdCheck.setHorizontalTextPosition(0);
		holdCheck.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 5;
		contentPane.add(holdCheck, gbc);
		final JPanel spacer1 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(spacer1, gbc);
		percentLabel = new JLabel();
		percentLabel.setText("Base Shield DMG Absorption(%)");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		contentPane.add(percentLabel, gbc);
		addValue = new JLabel();
		addValue.setText("Base Shield DMG Absorption");
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		contentPane.add(addValue, gbc);
		basePercentInput = new JTextField();
		basePercentInput.setColumns(4);
		basePercentInput.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(basePercentInput, gbc);
		addValueInput = new JTextField();
		addValueInput.setColumns(4);
		addValueInput.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		contentPane.add(addValueInput, gbc);
		cyroLabel = new JLabel();
		cyroLabel.setText("Cyro");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		contentPane.add(cyroLabel, gbc);
		cyroCheck = new JCheckBox();
		cyroCheck.setText("");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 6;
		contentPane.add(cyroCheck, gbc);
		hp.setLabelFor(hpInput);
		talents.setLabelFor(talentsInput);
		shieldIncreases.setLabelFor(increasesInput);
	}

	/**
	 * @noinspection ALL
	 */
	public JComponent $$$getRootComponent$$$() {
		return contentPane;
	}

	private void createUIComponents() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.Diona");
		diona = new JLabel(resourceBundle.getString("nameLang"));
	}
}