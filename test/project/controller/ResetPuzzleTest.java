package project.controller;

import static org.junit.Assert.assertEquals;

import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

import project.boundary.App;
import project.entity.Model;

public class ResetPuzzleTest {
	App app;
	Model model;
	
	@Before
	public void setup () {
		model = new Model();
		app = new App(model);
		
		
	}
	
	@Test
	public void testReset () {
		MoveTile tileMover = new MoveTile(model, app);
		// Move around the board to put the move count to 3 and the empty space to row 1 col 2
		tileMover.mousePressed(new MouseEvent(app.getPanel(), 0, 0, 0, 121, 250, 1, false));
		tileMover.mousePressed(new MouseEvent(app.getPanel(), 0, 0, 0, 121, 121, 1, false));
		tileMover.mousePressed(new MouseEvent(app.getPanel(), 0, 0, 0, 231, 121, 1, false));
		
		assertEquals(model.getPuzzle().getMoves(), 3);
		assertEquals(app.getMovesLabel().getText(), "3");
		
		ResetPuzzle reseter = new ResetPuzzle(model, app);
		reseter.mousePressed(new MouseEvent(app.getResetButton(), 0, 0, 0, 10, 10, 1, false));
		assertEquals(model.getPuzzle().getMoves(), 0);
		assertEquals(app.getMovesLabel().getText(), "0");
	}
}
