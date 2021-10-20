package usbharu.genshintools;

/**
 * 樹脂の数と時間を計算する
 *
 * @author main.usbharu
 * @version 1.0.0
 * @since 1.0.0
 */
public class ResinCalculate {
	/**
	 * 樹脂の数の数から貯めるのにかかる時間を返す
	 *
	 * @param resin 樹脂の数
	 * @return 貯めるのにかかる時間(分)
	 */
	public static int convertIntoTime(int resin) {
		return resin * 8;
	}

	/**
	 * 時間から貯まる樹脂の数を返す
	 *
	 * @param minutes 貯める時間(分)
	 * @return 貯まる樹脂の数
	 */
	public static int convertIntoResin(int minutes) {
		return minutes / 8;
	}
}