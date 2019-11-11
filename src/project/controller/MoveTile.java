package project.controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	
	@Override
	public void mousePressed (MouseEvent me) {
		Point p = me.getPoint();
		int row = 0;
		int col = 0;
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
		
		if (!model.getPuzzle().isGameOver() && model.getPuzzle().isMoveable(new Coordinate(row, col))) {
			model.getPuzzle().swapTile(new Coordinate (row, col));
			app.getMovesButton().setText("" + model.getPuzzle().getMoves());
			
			if (model.getPuzzle().hasWon()) {
				model.getPuzzle().endGame();
			} else if (model.getPuzzle().hasLost()) {
				model.getPuzzle().endGame();
			}
			app.repaint();
		}
	}
}
