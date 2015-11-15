package model.piece;

import java.awt.Color;

import gameController.GameController;
import model.board.Spot;
import model.player.Player;

public abstract class Piece {
	private PieceIcon icon;
	protected int xAxis;
	protected int yAxis;
	protected Player player;
	public Piece(int x, int y, Player player, PieceIcon icon){
		setxAxis(x);
		setyAxis(y);
		setPlayer(player);
		this.icon = icon;
	}
	public void movePiece(Spot newSpot){
		Piece newSpotPiece = newSpot.getPiece();
		Spot origSpot = player.getPieces().remove(this);
		
		if (newSpotPiece != null){
			newSpotPiece.killPiece();
		}
		if((origSpot.getXAxis() + origSpot.getYAxis()) % 2 == 0 ){
			origSpot.setBackground(Color.WHITE);
		} else {
			origSpot.setBackground(Color.GRAY);
		}
		newSpot.setPiece(this);
		origSpot.setPiece(null);
		newSpot.setPieceImage();
		origSpot.setPieceImage();
		xAxis = newSpot.getXAxis();
		yAxis = newSpot.getYAxis();
		player.addPiece(newSpot, this);
	}
	public abstract boolean isValidMove(Spot newSpot);
	public boolean isEmptyBetween(Spot origSpot, Spot newSpot, boolean diagonal){
		if (diagonal){
			if (origSpot.getXAxis() > newSpot.getXAxis()){
				if (origSpot.getYAxis() > newSpot.getYAxis()){
					int xIndex = origSpot.getXAxis() - 1;
					int yIndex = origSpot.getYAxis() - 1;
					while (xIndex > newSpot.getXAxis()){
						if (GameController.board[yIndex][xIndex].getPiece() != null){
							return false;
						}
						xIndex--;
						yIndex--;
					}
				} else {
					int xIndex = origSpot.getXAxis() - 1;
					int yIndex = origSpot.getYAxis() + 1;
					while (xIndex > newSpot.getXAxis()){
						if (GameController.board[yIndex][xIndex].getPiece() != null){
							return false;
						}
						xIndex--;
						yIndex++;
					}
				}
			} else {
				if (origSpot.getYAxis() > newSpot.getYAxis()){
					int xIndex = origSpot.getXAxis() + 1;
					int yIndex = origSpot.getYAxis() - 1;
					while (xIndex < newSpot.getXAxis()){
						if (GameController.board[yIndex][xIndex].getPiece() != null){
							return false;
						}
						xIndex++;
						yIndex--;
					}
				} else {
					int xIndex = origSpot.getXAxis() + 1;
					int yIndex = origSpot.getYAxis() + 1;
					while (xIndex < newSpot.getXAxis()){
						if (GameController.board[yIndex][xIndex].getPiece() != null){
							return false;
						}
						xIndex++;
						yIndex++;
					}
				}
			}
		} else {
			if (origSpot.getXAxis() > newSpot.getXAxis()){
				int index = origSpot.getXAxis() - 1;
				while (index > newSpot.getXAxis()){
					if (GameController.board[origSpot.getYAxis()][index].getPiece() != null){
						return false;
					}
					index--;
				}
			} else {
				int index = origSpot.getXAxis() + 1;
				while (index < newSpot.getXAxis()){
					if (GameController.board[origSpot.getYAxis()][index].getPiece() != null){
						return false;
					}
					index++;
				}
			}
			if (origSpot.getYAxis() > newSpot.getYAxis()){
				int index = origSpot.getYAxis() - 1;
				while (index > newSpot.getYAxis()){
					if (GameController.board[index][origSpot.getXAxis()].getPiece() != null){
						return false;
					}
					index--;
				}
			} else {
				int index = origSpot.getYAxis() + 1;
				while (index < newSpot.getYAxis()){
					if (GameController.board[index][origSpot.getXAxis()].getPiece() != null){
						return false;
					}
					index++;
				}
			}
		}
		return true;
	}
	public void killPiece(){
		player.removePiece(this);
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
