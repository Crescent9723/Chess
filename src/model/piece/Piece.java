package model.piece;

import model.board.Spot;
import model.player.Player;
import model.player.PlayerColor;

public abstract class Piece {
	private PieceIcon icon;
	private int xAxis;
	private int yAxis;
	private Player player;
	public Piece(int x, int y, Player player, PieceIcon icon){
		setxAxis(x);
		setyAxis(y);
		setPlayer(player);
		this.icon = icon;
	}
	public void movePiece(Spot newSpot){
		Spot origSpot = player.getPieces().get(this);
		newSpot.setPiece(this);
		origSpot.setPiece(null);
		newSpot.setPieceImage();
		origSpot.setPieceImage();
	}
	public abstract boolean isValidMove(Spot newSpot);
	public void killPiece(){
		
	};
	public String getIcon(){
		if (player.checkPlayerTurn(0)){
			return "../images/white" + icon.getImageName();
		} else {
			return "../images/black" + icon.getImageName();
		}
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
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
}
