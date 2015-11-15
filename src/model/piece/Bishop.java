package model.piece;

import model.board.Spot;
import model.player.Player;

public class Bishop extends Piece {
	public Bishop(int x, int y, Player player) {
		super(x, y, player, PieceIcon.BISHOP);
	}
	@Override
	public boolean isValidMove(Spot newSpot) {
		if (Math.abs(xAxis - newSpot.getXAxis()) == Math.abs(yAxis - newSpot.getYAxis())){
			if (isEmptyBetween(player.getPieces().get(this), newSpot, true)){
				if (newSpot.getPiece() != null){
					if (newSpot.getPiece().getPlayer().getColor() == player.getColor()){
						return false;
					}
				}
				return true;
			}
			
		} 
		return false;
	}

}
