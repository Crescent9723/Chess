package model.piece;

import model.player.Player;

public class Rook extends Piece {
	public Rook(int x, int y, Player player) {
		super(x, y, player, PieceIcon.ROOK);
	}
	@Override
	public boolean isValidMove(int x, int y) {
		return true;
	}

}
