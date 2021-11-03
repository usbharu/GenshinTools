package usbharu.genshintoolsplugin.shield;

import java.util.ResourceBundle;

public class ShieldCal {

	public static int baseShieldStrength(String name,int base , int talentsLevel){
		if (name == null||name.isEmpty()) {
			return 0;
		}
		ResourceBundle resourceBundle = ResourceBundle.getBundle(name);
		return shieldStrength(resourceBundle,"",base,talentsLevel,0);
	}

	public static int baseShieldStrength(ResourceBundle resourceBundle,int base,int talentsLevel){
		return shieldStrength(resourceBundle,"",base,talentsLevel,0);
	}

	public static int shieldStrength(String name,int base,int talentsLevel,int shieldIncreases){
		return shieldStrength(name,"",base,talentsLevel,shieldIncreases);
	}

	public static int shieldStrength(String name,String talentsName, int base, int talentsLevel, int shieldIncreases) {
		if (name == null || name.isEmpty()) {
			return 0;
		}
		ResourceBundle resourceBundle = ResourceBundle.getBundle(name);
		return shieldStrength(resourceBundle,talentsName,base,talentsLevel,shieldIncreases);
	}

	public static int shieldStrength(ResourceBundle resourceBundle,String talentsName, int base, int talentsLevel, int shieldIncreases) {
		float talentsPer = Float.parseFloat(resourceBundle.getString(talentsName+"level" + talentsLevel + "Per"));
		int talents = (int) Float.parseFloat(resourceBundle.getString(talentsName+"level" + talentsLevel));
		float shieldEffect = shieldIncreases/100f+1;
		float talentsPerFloat = talentsPer/100f;
		float baseShieldStrength = baseShieldStrength(base,talentsPerFloat,talents);
		baseShieldStrength*=shieldEffect;
		return (int) baseShieldStrength;
	}

	public static float talentsPercent(ResourceBundle resourceBundle,String talentsName,int level){
		return Float.parseFloat(resourceBundle.getString(talentsName+"level"+level+"Per"));
	}

	public static float talentsValue(ResourceBundle resourceBundle,String talentsName,int level){
		return Float.parseFloat(resourceBundle.getString(talentsName+"level"+level));
	}

	public static float talentsPercent(ResourceBundle resourceBundle,int level){
		return talentsPercent(resourceBundle,"",level);
	}

	public static float talentsValue(ResourceBundle resourceBundle,int level){
		return talentsValue(resourceBundle,"",level);
	}

	public static float talentsPercent(String name,int level){
		return talentsPercent(ResourceBundle.getBundle(name),level);
	}

	public static float talentsValue(String name,int level){
		return talentsValue(ResourceBundle.getBundle(name),level);
	}

	public static float talentsPercent(String name,String talentsName,int level){
		if (name != null) {
			return talentsPercent(ResourceBundle.getBundle(name),talentsName,level);
		}
		return 0;
	}

	public static float talentsValue(String name,String talentsName,int level){
		if (name != null) {
			return talentsValue(ResourceBundle.getBundle(name),talentsName,level);
		}
		return 0;
	}

	public static float baseShieldStrength(int base,float talentsPer,float talents){
		return base*talentsPer+talents;
	}
}