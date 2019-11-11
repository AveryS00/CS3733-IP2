package project.controller;

import static org.junit.Assert.assertEquals;

import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

import project.boundary.App;
import project.entity.Model;
import project.entity.Tile;

public class MoveTileTest {
	App app;
	Model model;
	
	@Before
	public void setup () {
		model = new Model();
		app = new App(model);
	}
	
	@Test
	public void testMove () {
		MoveTile tileMover = new MoveTile(model, app);
		tileMover.mousePressed(new MouseEvent(app.getPanel(), 0, 0, 0, 50, 50, 1, false));
		
		// Nothing happens, clicked unmoveable tile
		assertEquals(model.getPuzzle().getMoves(), 0);
		
		// Click inbetween tiles
		tileMover.mousePressed(new MouseEvent(app.getPanel(), 0, 0, 0, 115, 200, 1, false));
		assertEquals(model.getPuzzle().getMoves(), 0);
		
		// Click on moveable tile
		Tile tile = model.getPuzzle().getBoard()[2][1];
		tileMover.mousePressed(new MouseEvent(app.getPanel(), 0, 0, 0, 121, 250, 1, false));
		assertEquals(model.getPuzzle().getMoves(), 1);
		assertEquals(tile, model.getPuzzle().getBoard()[2][0]);
	}
}
