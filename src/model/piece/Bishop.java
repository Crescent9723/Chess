/**
 * @author Andy
 * @date Nov.14.2015
 * Bishop class.
 * This class is  Bishop piece that is part of
 * chess game piece.
 * It gets the Image from PieceIcon and contains
 * valid movements that only Bishop can do.
 */
package model.piece;

import model.board.Spot;
import model.player.Player;

public class Bishop extends Piece {
	/**
	 * @param x
	 * @param y
	 * @param player
	 */
	public Bishop(int x, int y, Player player) {
		super(x, y, player, PieceIcon.BISHOP);
	}

	@Override
	/**
	 * @param newSpot
	 */
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
