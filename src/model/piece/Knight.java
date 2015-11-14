package model.piece;

import model.board.Spot;
import model.player.Player;

public class Knight extends Piece {
	public Knight(int x, int y, Player player) {
		super(x, y, player, PieceIcon.KNIGHT);
	}
	@Override
	public boolean isValidMove(Spot newSpot) {
		return true;
	}

}
