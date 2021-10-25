package usbharu.genshintoolsplugin.shield;

import java.util.ResourceBundle;

public class ShieldCal {
	public static int shieldStrength(String name, int base, int talentsLevel, int shieldIncreases) {
		if (name == null || name.isEmpty()) {
			return 0;
		}
		ResourceBundle resourceBundle = ResourceBundle.getBundle(name);
		float talentsPer = Float.parseFloat(resourceBundle.getString("level" + (talentsLevel) + "Per"));
		int talents = Integer.parseInt(resourceBundle.getString("level" + (talentsLevel)));
		return (int) (((base * (talentsPer / 100)) + talents) * ((shieldIncreases / 100) + 1));
	}

	public static int shieldStrength(ResourceBundle resourceBundle, int base, int talentsLevel, int shieldIncreases) {
		int talentsPer = Integer.parseInt(resourceBundle.getString("level" + talentsLevel + "Per"));
		int talents = Integer.parseInt(resourceBundle.getString("level" + talentsLevel));
		return ((base * (talentsPer / 100)) + talents) * ((shieldIncreases / 100) + 1);
	}

	public static float talentsPercent(ResourceBundle resourceBundle,int level){
		return Float.parseFloat(resourceBundle.getString("level"+level+"Per"));
	}

	public static float talentsValue(ResourceBundle resourceBundle,int level){
		return Float.parseFloat(resourceBundle.getString("level"+level));
	}

	public static float talentsPercent(String name,int level){
		return talentsPercent(ResourceBundle.getBundle(name),level);
	}

	public static float talentsValue(String name,int level){
		return talentsValue(ResourceBundle.getBundle(name),level);
	}
}