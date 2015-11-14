package model.piece;

public abstract class Piece {
	private PieceIcon icon;
	private int xAxis;
	private int yAxis;
	public Piece(int x, int y, PieceIcon icon){
		setxAxis(x);
		setyAxis(y);
		this.icon = icon;
	}
	public abstract void movePiece(int x, int y);
	public void killPiece(){
		
	};
	public String getIcon(){
		return icon.getImageName();
	}
	public int getxAxis() {
		return xAxis;
	}
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	public int getyAxis() {
		return yAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	};
}
