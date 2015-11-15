/**
 * @author Andy Son
 * @date Nov.14.2015
 * Enum class named PlayerColor.
 * This class sets colors to two players,
 * so that it is easier to identify the users.
 */
package model.player;

public enum PlayerColor {
	White(0), Black(1);
	private int num;
	/**
	 * @param num
	 */
	PlayerColor(int num){
		this.setNum(num);
	}
	/**
	 * @return num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;
	}
}
