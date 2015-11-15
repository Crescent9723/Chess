/**
 * @author Andy
 * @date Nov.14.2015
 * King class.
 * This class is  King piece that is part of
 * chess game piece.
 * It gets the Image from PieceIcon and contains
 * valid movements that only King can do.
 * The game is over when one of the king piece from
 * two players dies.
 */
package model.piece;

import javax.swing.JOptionPane;

import gameController.GameController;
import model.board.Spot;
import model.player.Player;

public class King extends Piece {
	/**
	 * @param x
	 * @param y
	 * @param player
	 */
	public King(int x, int y, Player player) {
		super(x, y, player, PieceIcon.KING);
	}
	@Override
	/**
	 * @param newSpot
	 */
	public boolean isValidMove(Spot newSpot) {
		if (Math.abs(xAxis - newSpot.getXAxis()) == 1 && Math.abs(yAxis - newSpot.getYAxis()) == 1){
			if (newSpot.getPiece() != null){
				if (newSpot.getPiece().getPlayer().getColor() == player.getColor()){
					return false;
				}
			}
			return true;
		} else if (Math.abs(xAxis - newSpot.getXAxis()) == 1 && Math.abs(yAxis - newSpot.getYAxis()) == 0){
			if (newSpot.getPiece() != null){
				if (newSpot.getPiece().getPlayer().getColor() == player.getColor()){
					return false;
				}
			}
			return true;
		} else if (Math.abs(xAxis - newSpot.getXAxis()) == 0 && Math.abs(yAxis - newSpot.getYAxis()) == 1){
			if (newSpot.getPiece() != null){
				if (newSpot.getPiece().getPlayer().getColor() == player.getColor()){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	@Override
	public void killPiece() {
		JOptionPane.showMessageDialog(GameController.container, "Game End: Player " + player.getColor().name() + " wins!");
		System.exit(0);
	}
	

}
