package model.player;

import java.util.ArrayList;

import model.piece.Piece;

public class Player {
	ArrayList<Piece> pieces = new ArrayList<Piece>();
	private PlayerColor color;
	public Player(PlayerColor color){
		this.color = color;
	}
	public boolean checkPlayerTurn(int turn){
		return color.getNum() == turn;
	}
}
