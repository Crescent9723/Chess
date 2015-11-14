package model.piece;

import model.board.Spot;
import model.player.Player;

public class Queen extends Piece {
	public Queen(int x, int y, Player player) {
		super(x, y, player, PieceIcon.QUEEN);
	}
	@Override
	public boolean isValidMove(Spot newSpot) {
		return true;
	}

}
