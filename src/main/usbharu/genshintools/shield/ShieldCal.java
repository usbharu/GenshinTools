package usbharu.genshintools.shield;

import java.util.ResourceBundle;

public class ShieldCal {
	public static int shieldStrength(String name, int base, int talentsLevel, int shieldIncreases) {
		if (name == null || name.isEmpty()) {
			return 0;
		}
		ResourceBundle resourceBundle = ResourceBundle.getBundle(name);
		int talentsPer = Integer.parseInt(resourceBundle.getString("level" + (talentsLevel + 1) + "Per"));
		int talents = Integer.parseInt(resourceBundle.getString("level" + (talentsLevel + 1)));
		return ((base * talentsPer) + talents) * (shieldIncreases / 100);
	}

	public static int shieldStrength(ResourceBundle resourceBundle, int base, int talentsLevel, int shieldIncreases) {
		int talentsPer = Integer.parseInt(resourceBundle.getString("level" + (talentsLevel + 1) + "Per"));
		int talents = Integer.parseInt(resourceBundle.getString("level" + (talentsLevel + 1)));
		return ((base * talentsPer) + talents) * (shieldIncreases / 100);
	}
}