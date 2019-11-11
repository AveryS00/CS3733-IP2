package project.controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import project.boundary.App;
import project.entity.Coordinate;
import project.entity.Model;

public class MoveTile extends MouseAdapter {
	Model model;
	App app;
	
	public MoveTile (Model model, App app) {
		this.model = model;
		this.app = app;
	}
	
	/**
	 * Translates a given point from a mouseEvent into a row and column and sends that to the
	 * entity to see if it is moveable and moves it if it is.
	 */
	@Override
	public void mousePressed (MouseEvent me) {
		Point p = me.getPoint();
		int row = -1;
		int col = -1;
		if (p.getX() > 10 && p.getX() < 110) {
			col = 0;
		} else if (p.getX() > 120 && p.getX() < 220) {
			col = 1;
		} else if (p.getX() > 230 && p.getX() < 330) {
			col = 2;
		}
		
		if (p.getY() > 10 && p.getY() < 110) {
			row = 0;
		} else if (p.getY() > 120 && p.getY() < 220) {
			row = 1;
		} else if (p.getY() > 230 && p.getY() < 330) {
			row = 2;
		}
		
		// Ensure that the game is not over, a tile was actually clicked, and that the tile was moveable before moving
		if (!model.getPuzzle().isGameOver() && 
				row != -1 && col != -1 && 
				model.getPuzzle().isMoveable(new Coordinate(row, col))) {
			
			model.getPuzzle().swapTile(new Coordinate (row, col));
			app.getMovesLabel().setText("" + model.getPuzzle().getMoves());
			
			// Check to see if moving the tile ended the game.
			if (model.getPuzzle().hasWon()) {
				model.getPuzzle().endGame();
			} else if (model.getPuzzle().hasLost()) {
				model.getPuzzle().endGame();
			}
			
			app.repaint();
		}
		
	}
	
}
