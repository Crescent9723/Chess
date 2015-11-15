/**
 * @author Andy Son
 * @date Nov.14.2015
 * Queen class.
 * This class is  Queen piece that is part of
 * chess game piece.
 * It gets the Image from PieceIcon and contains
 * valid movements that only Queen can do.
 */
package model.piece;

import model.board.Spot;
import model.player.Player;

public class Queen extends Piece {
	/**
	 * @param x
	 * @param y
	 * @param player
	 */
	public Queen(int x, int y, Player player) {
		super(x, y, player, PieceIcon.QUEEN);
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
		} else if (Math.abs(xAxis - newSpot.getXAxis()) == 0 && Math.abs(yAxis - newSpot.getYAxis()) != 0){
			if (isEmptyBetween(player.getPieces().get(this), newSpot, false)){
				if (newSpot.getPiece() != null){
					if (newSpot.getPiece().getPlayer().getColor() == player.getColor()){
						return false;
					}
				}
				return true;
			}
		} else if (Math.abs(xAxis - newSpot.getXAxis()) != 0 && Math.abs(yAxis - newSpot.getYAxis()) == 0){
			if (isEmptyBetween(player.getPieces().get(this), newSpot, false)){
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
