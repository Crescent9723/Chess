package model.piece;

import model.board.Spot;
import model.player.Player;

public class Knight extends Piece {
	public Knight(int x, int y, Player player) {
		super(x, y, player, PieceIcon.KNIGHT);
	}
	@Override
	public boolean isValidMove(Spot newSpot) {
		if (Math.abs(xAxis - newSpot.getXAxis()) == 2 && Math.abs(yAxis - newSpot.getYAxis()) == 1){
			if (newSpot.getPiece() != null){
				if (newSpot.getPiece().getPlayer().getColor() == player.getColor()){
					return false;
				}
			}
			return true;
		} else if (Math.abs(xAxis - newSpot.getXAxis()) == 1 && Math.abs(yAxis - newSpot.getYAxis()) == 2){
			if (newSpot.getPiece() != null){
				if (newSpot.getPiece().getPlayer().getColor() == player.getColor()){
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
