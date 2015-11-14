package model.player;

import java.util.HashMap;

import model.board.Spot;
import model.piece.Piece;

public class Player {
	private HashMap<Piece, Spot> pieces = new HashMap<Piece, Spot>();
	private PlayerColor color;
	public Player(PlayerColor color){
		this.color = color;
	}
	public boolean checkPlayerTurn(int turn){
		return color.getNum() == turn;
	}
	
	public void addPiece(Spot spot, Piece piece){
		getPieces().put(piece, spot);
	}
	public void removePiece(Piece piece){
		getPieces().remove(piece);
	}
	public HashMap<Piece, Spot> getPieces() {
		return pieces;
	}
}
