/**
 * @author Andy Son
 * @date Nov.14.2015
 * MouseClickListener.
 * This class contains all the methods that
 * accepts functions from mouse inputs from the user.
 */
package eventListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import gameController.GameController;
import model.board.Spot;

public class MouseClickListener implements MouseListener {
	/**
	 * @param MouseEvent e
	 */
	public void mouseClicked(MouseEvent e){ 
		int x = e.getX();
		int y = e.getY();
		Spot spot = (Spot) e.getComponent();
		
		// Piece not picked
		if (!GameController.picked){
			if (spot.getPiece() == null){
				JOptionPane.showMessageDialog(GameController.container, "Error: Please select your piece");
			} else if (spot.getPiece().getPlayer().checkPlayerTurn(GameController.turn)) {
				JOptionPane.showMessageDialog(GameController.container, "Error: Please select your piece");
			} else {
				GameController.currentPiece = spot.getPiece();
				spot.setBackground(Color.RED);
				GameController.picked = true;
			}
			
		} else {
			if (GameController.currentPiece.isValidMove(spot)){
				GameController.currentPiece.movePiece(spot);
				GameController.turn = ++(GameController.turn) % 2;
				GameController.picked = false;
			} else {
				JOptionPane.showMessageDialog(GameController.container, "Error: Invalid move");
			}
		}
	} 
	public void mouseEntered(MouseEvent e){ } 
	public void mouseExited(MouseEvent e) { } 
	public void mousePressed(MouseEvent e) { } 
	public void mouseReleased(MouseEvent e) { }
}
