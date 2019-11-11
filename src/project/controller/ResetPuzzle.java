package project.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import project.boundary.App;
import project.entity.Model;

public class ResetPuzzle extends MouseAdapter {
	Model model;
	App app;
	
	public ResetPuzzle (Model model, App app) {
		this.model = model;
		this.app = app;
	}
	
	@Override
	public void mousePressed (MouseEvent me) {
		model.newPuzzle();
		app.getMovesButton().setText("0");
		app.repaint();
	}
}
