/**
 * @author Andy Son
 * @date Nov.14.2015
 * Player class.
 * It contains hashmap to store piece and spots.
 * It also contains methods to define players turn
 * from white and black from PlayerColor class.
 */
package model.player;

import java.util.HashMap;

import model.board.Spot;
import model.piece.Piece;

public class Player {
	private HashMap<Piece, Spot> pieces = new HashMap<Piece, Spot>();
	private PlayerColor color;
	/**
	 * @param color
	 */
	public Player(PlayerColor color){
		this.color = color;
	}
	/**
	 * @param turn
	 * @return color.getNum()
	 */
	public boolean checkPlayerTurn(int turn){
		return getColor().getNum() == turn;
	}
	
	/**
	 * @param spot
	 * @param piece
	 */
	public void addPiece(Spot spot, Piece piece){
		pieces.put(piece, spot);
	}
	/**
	 * @param piece
	 */
	public void removePiece(Piece piece){
		pieces.remove(piece);
	}
	/**
	 * @return pieces
	 */
	public HashMap<Piece, Spot> getPieces() {
		return pieces;
	}
	/**
	 * @return color
	 */
	public PlayerColor getColor() {
		return color;
	}
	
}
