package model.piece;

import model.player.Player;

public class Pawn extends Piece {
	public Pawn(int x, int y, Player player) {
		super(x, y, player, PieceIcon.PAWN);
	}
	@Override
	public boolean isValidMove(int x, int y) {
		return true;
	}

}
