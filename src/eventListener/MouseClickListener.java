package eventListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import gameController.GameController;
import model.board.Spot;

public class MouseClickListener implements MouseListener {
	public void mouseClicked(MouseEvent e){ 
		int x = e.getX();
		int y = e.getY();
		if (x < 5 || y < 5 || x > 70 || y > 70){
			JOptionPane.showMessageDialog(GameController.container, "Error: Please click center");
		}
		Spot spot = (Spot) e.getComponent();
		
		// Piece not picked
		if (!GameController.picked){
			System.out.println(GameController.turn + "");
			if (spot.getPiece() == null){
				JOptionPane.showMessageDialog(GameController.container, "Error: Please select your piece");
			} else if (spot.getPiece().getPlayer().checkPlayerTurn(GameController.turn)) {
				JOptionPane.showMessageDialog(GameController.container, "Error: Please select your piece");
			} else {
				GameController.currentPiece = spot.getPiece();
				GameController.picked = true;
			}
			
		} else {
			if (GameController.currentPiece.isValidMove(spot)){
				GameController.currentPiece.movePiece(spot);
			}
			GameController.turn = ++(GameController.turn) % 2;
			GameController.picked = false;
		}
	} 
	public void mouseEntered(MouseEvent e){ } 
	public void mouseExited(MouseEvent e) { } 
	public void mousePressed(MouseEvent e) { } 
	public void mouseReleased(MouseEvent e) { }
}
