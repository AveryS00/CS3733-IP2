package project.entity;

public class Model {
	
	Puzzle puzzle;
	
	public Model () {
		puzzle = new Puzzle();
	}
	
	public void newPuzzle () {
		puzzle = new Puzzle();
	}
	
	public Puzzle getPuzzle () {
		return puzzle;
	}
}
