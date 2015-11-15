package gameController;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import eventListener.MouseClickListener;
import model.board.Spot;
import model.piece.Bishop;
import model.piece.King;
import model.piece.Knight;
import model.piece.Pawn;
import model.piece.Piece;
import model.piece.Queen;
import model.piece.Rook;
import model.player.Player;
import model.player.PlayerColor;

public class GameController{
	public static boolean picked = false;
	public static int turn = 0;
	public static Piece currentPiece = null;
	static private int boardSize = 600;
	static private Player playerWhite = new Player(PlayerColor.White);
	static private Player playerBlack = new Player(PlayerColor.Black);
	public static JFrame container = new JFrame();


	private static Spot[][] initBoard = {
			{new Spot(0, 0, new Rook(0, 0, GameController.playerWhite)), new Spot(1, 0, new Knight(1, 0, GameController.playerWhite)), 
				new Spot(2, 0, new Bishop(2, 0, GameController.playerWhite)), new Spot(3, 0, new King(3, 0, GameController.playerWhite)),
				new Spot(4, 0, new Queen(4, 0, GameController.playerWhite)), new Spot(5, 0, new Bishop(5, 0, GameController.playerWhite)),
				new Spot(6, 0, new Knight(6, 0, GameController.playerWhite)), new Spot(7, 0, new Rook(7, 0, GameController.playerWhite))},
			{new Spot(0, 1, new Pawn(0, 1, GameController.playerWhite)), new Spot(1, 1, new Pawn(1, 1, GameController.playerWhite)),
					new Spot(2, 1, new Pawn(2, 1, GameController.playerWhite)), new Spot(3, 1, new Pawn(3, 1, GameController.playerWhite)),
					new Spot(4, 1, new Pawn(4, 1, GameController.playerWhite)), new Spot(5, 1, new Pawn(5, 1, GameController.playerWhite)), 
					new Spot(6, 1, new Pawn(6, 1, GameController.playerWhite)), new Spot(7, 1, new Pawn(7, 1, GameController.playerWhite))},
			{new Spot(0, 2, null), new Spot(1, 2, null), new Spot(2, 2, null), new Spot(3, 2, null), 
						new Spot(4, 2, null), new Spot(5, 2, null), new Spot(6, 2, null), new Spot(7, 2, null)},
			{new Spot(0, 3, null), new Spot(1, 3, null), new Spot(2, 3, null), new Spot(3, 3, null),
							new Spot(4, 3, null), new Spot(5, 3, null), new Spot(6, 3, null), new Spot(7, 3, null)},
			{new Spot(0, 4, null), new Spot(1, 4, null), new Spot(2, 4, null), new Spot(3, 4, null),
								new Spot(4, 4, null), new Spot(5, 4, null), new Spot(6, 4, null), new Spot(7, 4, null)},
			{new Spot(0, 5, null), new Spot(1, 5, null), new Spot(2, 5, null), new Spot(3, 5, null),
									new Spot(4, 5, null), new Spot(5, 5, null), new Spot(6, 5, null), new Spot(7, 5, null)},
			{new Spot(0, 6, new Pawn(0, 6, GameController.playerBlack)), new Spot(1, 6, new Pawn(1, 6, GameController.playerBlack)), 
										new Spot(2, 6, new Pawn(2, 6, GameController.playerBlack)), new Spot(3, 6, new Pawn(3, 6, GameController.playerBlack)),
										new Spot(4, 6, new Pawn(4, 6, GameController.playerBlack)), new Spot(5, 6, new Pawn(5, 6, GameController.playerBlack)), 
										new Spot(6, 6, new Pawn(6, 6, GameController.playerBlack)), new Spot(7, 6, new Pawn(7, 6, GameController.playerBlack))},
			{new Spot(0, 7, new Rook(0, 7, GameController.playerBlack)), new Spot(1, 7, new Knight(1, 7, GameController.playerBlack)), 
											new Spot(2, 7, new Bishop(2, 7, GameController.playerBlack)), new Spot(3, 7, new King(3, 7, GameController.playerBlack)),
											new Spot(4, 7, new Queen(4, 7, GameController.playerBlack)), new Spot(5, 7, new Bishop(5, 7, GameController.playerBlack)), 
											new Spot(6, 7, new Knight(6, 7, GameController.playerBlack)), new Spot(7, 7, new Rook(7, 7, GameController.playerBlack))}			
	};

	public static Spot[][] board = initBoard;

	public static void main(String args[]){
		container.setLayout(new GridLayout(8,8,0,0));
		container.setSize(getBoardSize(), getBoardSize());
		container.setResizable(false);
		container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container.setVisible(true);
		initBoard(container);
		initPlayer();
		setESCKey();
	}

	@SuppressWarnings("serial")
	private static void setESCKey() {
		container.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
		container.getRootPane().getActionMap().put("Cancel", new AbstractAction(){ //$NON-NLS-1$

			@Override
			public void actionPerformed(ActionEvent e){
				if (picked){
					picked = false;
					Spot origSpot = currentPiece.getPlayer().getPieces().get(currentPiece);
					if((origSpot.getXAxis() + origSpot.getYAxis()) % 2 == 0 ){
						origSpot.setBackground(Color.WHITE);
					} else {
						origSpot.setBackground(Color.GRAY);
					}
					currentPiece = null;
				}
			}
		});
	}

	private static void initPlayer() {
		for (int i = 0 ; i < 2 ; i++){
			for (int j = 0 ; j < 8 ; j++){
				playerWhite.addPiece(board[i][j], board[i][j].getPiece());
			}
		}
		for (int i = 6 ; i < 8 ; i++){
			for (int j = 0 ; j < 8 ; j++){
				playerBlack.addPiece(board[i][j], board[i][j].getPiece());
			}
		}
	}

	private static void initBoard(Container c) {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if((i+j)%2 == 0 )
					board[i][j].setBackground(Color.white);
				else 
					board[i][j].setBackground(Color.gray);
				board[i][j].addMouseListener(new MouseClickListener());
				c.add(board[i][j]);
			}
		}
	}

	public static int getBoardSize() {
		return boardSize;
	}

}
