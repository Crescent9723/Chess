package model.board;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameController.GameController;
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
		setPieceImage();
		this.add(icon);
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
			return;
		}
		java.net.URL url = getClass().getResource(piece.getIcon());
		ImageIcon imageIcon = new ImageIcon(url);
		icon.setIcon(getScaleImageIcon(imageIcon, GameController.getBoardSize() / 8, GameController.getBoardSize() / 8));
		icon.setVisible(true);
		this.repaint();
	}
	static public ImageIcon getScaleImageIcon(ImageIcon icon, int width, int height) {
		return new ImageIcon(getScaledImage(icon.getImage(), width, height));
	}
	static private Image getScaledImage(Image srcImg, int width, int height){
		BufferedImage resizedImg = 
				new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = resizedImg.createGraphics();
		g2.setRenderingHint(
				RenderingHints.KEY_INTERPOLATION, 
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(srcImg, 0, 0, width, height, null);
		g2.dispose();
		return resizedImg;
	}

}
