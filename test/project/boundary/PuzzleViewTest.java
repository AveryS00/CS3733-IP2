package project.boundary;

import org.junit.Before;
import org.junit.Test;

import project.entity.Model;
import project.entity.Tile;

public class PuzzleViewTest {
	
	Model model;
	App app;
	
	@Before
	public void setup () {
		model = new Model();
		app = new App(model);
	}
	
	@Test
	public void testPuzzleView () {
		app.setVisible(true);
		app.panel.paintComponent(app.getGraphics());
	}

}
