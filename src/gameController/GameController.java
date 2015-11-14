package gameController;

import javax.swing.JFrame;

import model.board.Board;

public class GameController {
	
	public static void main(String args[])
	{
		Board main = new Board();
		main.setSize(600,600);
		main.setResizable(false);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);
	} 
	
}
