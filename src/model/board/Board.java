package model.board;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import gameController.GameController;
import model.piece.Bishop;
import model.piece.King;
import model.piece.Knight;
import model.piece.Pawn;
import model.piece.Queen;
import model.piece.Rook;


@SuppressWarnings("serial")
public class Board extends JFrame implements MouseListener{
	
	private static Spot[][] initBoard = {
			{new Spot(0, 0, new Rook(0, 0, GameController.getPlayerWhite())), new Spot(1, 0, new Knight(1, 0, GameController.getPlayerWhite())), 
				new Spot(2, 0, new Bishop(2, 0, GameController.getPlayerWhite())), new Spot(3, 0, new King(3, 0, GameController.getPlayerWhite())),
				new Spot(4, 0, new Queen(4, 0, GameController.getPlayerWhite())), new Spot(5, 0, new Bishop(5, 0, GameController.getPlayerWhite())),
				new Spot(6, 0, new Knight(6, 0, GameController.getPlayerWhite())), new Spot(7, 0, new Rook(7, 0, GameController.getPlayerWhite()))},
			{new Spot(0, 1, new Pawn(0, 1, GameController.getPlayerWhite())), new Spot(1, 1, new Pawn(1, 1, GameController.getPlayerWhite())),
				new Spot(2, 1, new Pawn(2, 1, GameController.getPlayerWhite())), new Spot(3, 1, new Pawn(3, 1, GameController.getPlayerWhite())),
				new Spot(4, 1, new Pawn(4, 1, GameController.getPlayerWhite())), new Spot(5, 1, new Pawn(5, 1, GameController.getPlayerWhite())), 
				new Spot(6, 1, new Pawn(6, 1, GameController.getPlayerWhite())), new Spot(7, 1, new Pawn(7, 0, GameController.getPlayerWhite()))},
			{new Spot(0, 2, null), new Spot(1, 2, null), new Spot(2, 2, null), new Spot(3, 2, null), 
						new Spot(4, 2, null), new Spot(5, 2, null), new Spot(6, 2, null), new Spot(7, 2, null)},
			{new Spot(0, 3, null), new Spot(1, 3, null), new Spot(2, 3, null), new Spot(3, 3, null),
						new Spot(4, 3, null), new Spot(5, 3, null), new Spot(6, 3, null), new Spot(7, 3, null)},
			{new Spot(0, 4, null), new Spot(1, 4, null), new Spot(2, 4, null), new Spot(3, 4, null),
							new Spot(4, 4, null), new Spot(5, 4, null), new Spot(6, 4, null), new Spot(7, 4, null)},
			{new Spot(0, 5, null), new Spot(1, 5, null), new Spot(2, 5, null), new Spot(3, 5, null),
								new Spot(4, 5, null), new Spot(5, 5, null), new Spot(6, 5, null), new Spot(7, 5, null)},
			{new Spot(0, 6, new Pawn(0, 6, GameController.getPlayerBlack())), new Spot(1, 6, new Pawn(1, 6, GameController.getPlayerBlack())), 
					new Spot(2, 6, new Pawn(2, 6, GameController.getPlayerBlack())), new Spot(3, 6, new Pawn(3, 6, GameController.getPlayerBlack())),
					new Spot(4, 6, new Pawn(4, 6, GameController.getPlayerBlack())), new Spot(5, 6, new Pawn(5, 6, GameController.getPlayerBlack())), 
					new Spot(6, 6, new Pawn(6, 6, GameController.getPlayerBlack())), new Spot(7, 6, new Pawn(7, 6, GameController.getPlayerBlack()))},
			{new Spot(0, 7, new Rook(0, 7, GameController.getPlayerBlack())), new Spot(1, 7, new Knight(1, 7, GameController.getPlayerBlack())), 
					new Spot(2, 7, new Bishop(2, 7, GameController.getPlayerBlack())), new Spot(3, 7, new King(3, 7, GameController.getPlayerBlack())),
					new Spot(4, 7, new Queen(4, 7, GameController.getPlayerBlack())), new Spot(5, 7, new Bishop(5, 7, GameController.getPlayerBlack())), 
					new Spot(6, 7, new Knight(6, 7, GameController.getPlayerBlack())), new Spot(7, 7, new Rook(7, 7, GameController.getPlayerBlack()))}			
	};
	static Spot[][] board = initBoard;
	public Board(){
		Container c = getContentPane();
		c.setLayout(new GridLayout(8,8,0,0));
		initBoard(c);
	}


	private void initBoard(Container c) {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if((i+j)%2 == 0 )
					board[i][j].setBackground(Color.white);
				else 
					board[i][j].setBackground(Color.gray);
				board[i][j].addMouseListener(this);
				c.add(board[i][j]);
			}
		}
	}

	public void mouseClicked(MouseEvent e){ 
		// Piece not picked
		int x = e.getX();
		int y = e.getY();
		if (x < 5 || y < 5 || x > 70 || y > 70){
			JOptionPane.showMessageDialog(this, "Error: Please click center");
		}
		Spot spot = (Spot) e.getComponent();
		
		if (!GameController.picked){
			
			if (spot.getPiece() == null){
				JOptionPane.showMessageDialog(this, "Error: Please select your piece");
			} else if (spot.getPiece().getPlayer().checkPlayerTurn(GameController.turn)) {
				JOptionPane.showMessageDialog(this, "Error: Please select your piece");
			} else {
				GameController.currentPiece = spot.getPiece();
			}
			
			GameController.picked = true;
			return;
		} else {
			if (GameController.currentPiece.isValidMove(spot.getXAxis(), spot.getYAxis())){
				GameController.currentPiece.movePiece(spot.getXAxis(), spot.getYAxis());
			}
			
		}
	} 
	public void mouseEntered(MouseEvent e){ } 
	public void mouseExited(MouseEvent e) { } 
	public void mousePressed(MouseEvent e) { } 
	public void mouseReleased(MouseEvent e) { }
}