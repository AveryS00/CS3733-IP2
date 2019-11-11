package project.entity;

public class Model {
	
	Puzzle puzzle;
	
	public Model () {
		puzzle = new Puzzle();
	}
	
	/**
	 * Keeps the same model, but makes a whole new puzzle.
	 */
	public void newPuzzle () {
		puzzle = new Puzzle();
	}
	
	/**
	 * Return the puzzle for the model.
	 * @return
	 */
	public Puzzle getPuzzle () {
		return puzzle;
	}
}
