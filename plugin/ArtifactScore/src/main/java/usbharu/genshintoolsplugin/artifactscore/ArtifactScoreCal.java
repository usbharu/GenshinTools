package usbharu.genshintoolsplugin.artifactscore;

public class ArtifactScoreCal {
	public static float artifactSore(float criticalRate,float criticalDamage,float ATK){
		return criticalRate*2+criticalDamage+ATK;
	}
}