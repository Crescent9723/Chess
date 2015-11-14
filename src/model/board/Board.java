package model.board;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Board extends JFrame implements MouseListener{
	static Spot[][] board = new Spot[8][8];

	public Board(){
		Container c = getContentPane();
		c.setLayout(new GridLayout(8,8,0,0));
		initBoard(c);
	}


	private void initBoard(Container c) {
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				board[i][j] = new Spot(i, j, null);
				if((i+j)%2 == 0 )
					board[i][j].setBackground(Color.white);
				else 
					board[i][j].setBackground(Color.black);
				board[i][j].addMouseListener(this);
				c.add(board[i][j]);
			}
		}
	}

	public void mouseClicked(MouseEvent e){ 
		int x = e.getX();
		int y = e.getY();
		if (x < 5 || y < 5 || x > 70 || y > 70){
			JOptionPane.showMessageDialog(this, "Error: Please click center");
		}
		Spot spot = (Spot) e.getComponent();
		int xAxis = spot.getXAxis();
		int yAxis = spot.getYAxis();
	} 
	public void mouseEntered(MouseEvent e){ } 
	public void mouseExited(MouseEvent e) { } 
	public void mousePressed(MouseEvent e) { } 
	public void mouseReleased(MouseEvent e) { }
}