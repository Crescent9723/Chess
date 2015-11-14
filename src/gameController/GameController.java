package gameController;

import javax.swing.JFrame;

import model.board.Board;
import model.piece.Piece;
import model.player.Player;
import model.player.PlayerColor;

public class GameController {
	public static boolean picked = false;
	public static int turn = 0;
	public static Piece currentPiece = null;
	static private int boardSize = 600;
	static private Board board;
	static private Player playerWhite = new Player(PlayerColor.White);
	static private Player playerBlack = new Player(PlayerColor.Black);
	public static void main(String args[])
	{
		board = new Board();
		board.setSize(getBoardSize(), getBoardSize());
		board.setResizable(false);
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.setVisible(true);
	}
	public static Player getPlayerWhite() {
		return playerWhite;
	}
	public static void setPlayerWhite(Player playerWhite) {
		GameController.playerWhite = playerWhite;
	}
	public static Player getPlayerBlack() {
		return playerBlack;
	}
	public static void setPlayerBlack(Player playerBlack) {
		GameController.playerBlack = playerBlack;
	}
	public static int getBoardSize() {
		return boardSize;
	}
	public static void setBoardSize(int boardSize) {
		GameController.boardSize = boardSize;
	}
	
}
