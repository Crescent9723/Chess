package model.piece;

import javax.swing.JOptionPane;

import gameController.GameController;
import model.board.Spot;
import model.player.Player;

public class King extends Piece {
	public King(int x, int y, Player player) {
		super(x, y, player, PieceIcon.KING);
	}
	@Override
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
