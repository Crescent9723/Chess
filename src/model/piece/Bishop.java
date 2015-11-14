package model.piece;

import model.player.Player;

public class Bishop extends Piece {
	public Bishop(int x, int y, Player player) {
		super(x, y, player, PieceIcon.BISHOP);
	}
	@Override
	public boolean isValidMove(int x, int y) {
		return true;
	}

}
