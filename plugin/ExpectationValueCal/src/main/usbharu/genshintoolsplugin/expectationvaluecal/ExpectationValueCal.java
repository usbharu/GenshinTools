package usbharu.genshintoolsplugin.expectationvaluecal;

public class ExpectationValueCal {
	/**
	 * @param atk 攻撃力(最終攻撃力)
	 * @param criticalRate 会心率(%)
	 * @param criticalDamage 会心ダメージ(%)
	 * @return 期待値
	 */
	public static float calExpectationValue(int atk,float criticalRate,float criticalDamage){
		return atk * (criticalRate / 100) * (1 + (criticalDamage / 100));
	}
}