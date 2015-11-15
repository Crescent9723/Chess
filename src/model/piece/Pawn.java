package model.piece;

import model.board.Spot;
import model.player.Player;
import model.player.PlayerColor;

public class Pawn extends Piece {
	public Pawn(int x, int y, Player player) {
		super(x, y, player, PieceIcon.PAWN);
	}
	@Override
	public boolean isValidMove(Spot newSpot) {
		if (player.getColor() == PlayerColor.White){
			if (Math.abs(xAxis - newSpot.getXAxis()) == 1 && (yAxis - newSpot.getYAxis()) == -1){
				if (newSpot.getPiece() == null){
					return false;
				} else {
					return true;
				}
			} else if (Math.abs(xAxis - newSpot.getXAxis()) == 0 && (yAxis - newSpot.getYAxis()) == -1) {
				if (newSpot.getPiece() == null){
					return true;
				} else {
					return false;
				}
			}
		} else if (player.getColor() == PlayerColor.Black){
			if (Math.abs(xAxis - newSpot.getXAxis()) == 1 && (yAxis - newSpot.getYAxis()) == 1){
				if (newSpot.getPiece() == null){
					return false;
				} else {
					return true;
				}
			} else if (Math.abs(xAxis - newSpot.getXAxis()) == 0 && (yAxis - newSpot.getYAxis()) == 1) {
				if (newSpot.getPiece() == null){
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

}
