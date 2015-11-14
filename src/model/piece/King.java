package model.piece;

import model.player.Player;

public class King extends Piece {
	public King(int x, int y, Player player) {
		super(x, y, player, PieceIcon.KING);
	}
	@Override
	public boolean isValidMove(int x, int y) {
		return true;
	}

}
