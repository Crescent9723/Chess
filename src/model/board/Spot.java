package model.board;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.piece.Piece;

public class Spot extends JPanel {
	private int xAxis;
	private int yAxis;
	private Piece piece;
	private JLabel icon = new JLabel();
	public Spot(int x , int y, Piece piece){
		this.setXAxis(x);
		this.setYAxis(y);
		this.setPiece(piece);
	}
	public int getXAxis() {
		return xAxis;
	}
	public void setXAxis(int xAxis) {
		this.xAxis = xAxis;
	}
	public int getYAxis() {
		return yAxis;
	}
	public void setYAxis(int yAxis) {
		this.yAxis = yAxis;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public void setPieceImage(){
		if (piece == null){
			icon.setVisible(false);
		}
		icon.setIcon(new ImageIcon(piece.getIcon()));
		icon.setVisible(true);
		this.repaint();
	}

}
