package project.boundary;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import project.entity.Model;
import project.entity.Tile;

public class PuzzleView extends JPanel {
	Model model;
	
	public PuzzleView (Model model) {
		//this.model = model;
		this.model = new Model();
	}

	
	@Override
	public void paintComponent (Graphics g) {
		
		Tile[][] board = model.getPuzzle().getBoard();
		
		// CAREFUL!!! X CORRELATES TO COLUMN AND Y CORRELATES TO ROW ON SCREEN!!!
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] != null) {
					if (board[row][col].getIsFlipped()) {
						g.setColor(Color.black);
						g.fillRect(col*110 + 10, row*110 + 10, 100, 100);
						g.setColor(Color.white);
						g.drawString("" + board[row][col].getVisibleNum(), 60 + 110 * col, row * 110 + 60);
					} else {
						g.setColor(Color.gray);
						g.fillRect(col*110 + 10, row*110 + 10, 100, 100);
						g.setColor(Color.black);
						g.drawString("" + board[row][col].getVisibleNum(), col * 110 + 60, row * 110 + 60);
					}			
				}
			}
		}
	}
}
