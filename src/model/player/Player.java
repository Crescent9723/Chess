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
		return getColor().getNum() == turn;
	}
	
	public void addPiece(Spot spot, Piece piece){
		pieces.put(piece, spot);
	}
	public void removePiece(Piece piece){
		pieces.remove(piece);
	}
	public HashMap<Piece, Spot> getPieces() {
		return pieces;
	}
	public PlayerColor getColor() {
		return color;
	}
	
}
