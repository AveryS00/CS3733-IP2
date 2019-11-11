package project.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import project.entity.Model;
import project.entity.Tile;

public class PuzzleView extends JPanel {
	Model model;

	public PuzzleView (Model model) {
		this.model = model;
	}


	@Override
	public void paintComponent (Graphics g) {
		if (model != null) {
			Tile[][] board = model.getPuzzle().getBoard();
			g.setFont(new Font("Times New Roman", Font.PLAIN, 40));

			// CAREFUL!!! X CORRELATES TO COLUMN AND Y CORRELATES TO ROW ON SCREEN!!!
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					if (board[row][col] != null) {
						if (board[row][col].getIsFlipped()) {
							g.setColor(Color.black);
							g.fillRect(col*110 + 10, row*110 + 10, 100, 100);
							g.setColor(Color.white);
							g.drawString("" + board[row][col].getVisibleNum(), col * 110 + 53, row * 110 + 75);
						} else {
							g.setColor(Color.gray);
							g.fillRect(col*110 + 10, row*110 + 10, 100, 100);
							g.setColor(Color.black);
							g.drawString("" + board[row][col].getVisibleNum(), col * 110 + 53, row * 110 + 75);
						}			
					}
				}
			}
			
			if (model.getPuzzle().isGameOver() && model.getPuzzle().hasWon()) {
				g.setColor(Color.red);
				g.setFont(new Font("Times New Roman", Font.BOLD, 40));
				g.drawString("Congratulations!", 30, 160);
				g.drawString("You've won!", 70, 200);
			} else if (model.getPuzzle().isGameOver() && model.getPuzzle().hasLost()) {
				g.setColor(Color.red);
				g.setFont(new Font("Times New Roman", Font.BOLD, 40));
				g.drawString("Sorry, you've lost!", 20, 175);
			}
		}
	}
	
	
}
