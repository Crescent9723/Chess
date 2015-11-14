package model.piece;

import model.board.Spot;
import model.player.Player;

public class Bishop extends Piece {
	public Bishop(int x, int y, Player player) {
		super(x, y, player, PieceIcon.BISHOP);
	}
	@Override
	public boolean isValidMove(Spot newSpot) {
		return true;
	}

}
