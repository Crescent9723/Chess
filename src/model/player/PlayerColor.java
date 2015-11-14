package model.player;

public enum PlayerColor {
	White(0), Black(1);
	private int num;
	PlayerColor(int num){
		this.setNum(num);
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
