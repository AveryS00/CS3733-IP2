package project.entity;

public class Puzzle {
	Tile board[][];
	Coordinate emptyCoordinate;
	int moves;
	boolean gameOver;
	
	/**
	 * Constructs a new puzzle in initial configuration.
	 */
	Puzzle () {
		board = initConfig();
		emptyCoordinate = new Coordinate (2, 0);
		moves = 0;
		gameOver = false;
	}
	
	/**
	 * Constructs the initial configuration of the board. The empty tile is represented by null
	 * Initial configuration for student ID ending in 6.
	 * @return the 2D tile array of the board
	 */
	Tile[][] initConfig () {
		/*
		 * numShown | T-Top or B-Bottom
		 *	1T	4B	3T
		 *	2T	1B	4T
		 *	0	2T	3T
		 */
		Tile t1 = new Tile(1, 4, false);
		Tile t2 = new Tile(1, 4, true);
		Tile t3 = new Tile(3, 2, false);
		Tile t4 = new Tile(2, 3, false);
		Tile t5 = new Tile(4, 1, true);
		Tile t6 = new Tile(4, 1, false);
		Tile t8 = new Tile(2, 3, false);
		Tile t9 = new Tile(3, 2, false);
		
		Tile tiles[][] = {
				{t1,   t2, t3}, 
				{t4,   t5, t6}, 
				{null, t8, t9}};
		
		return tiles;
	}
	
	/**
	 * Checks if the tile is next to the empty space and can be moved.
	 * @param coordinate The x, y coordinate of the tile.
	 * @return true if the tile is next to the empty space
	 */
	public boolean isMoveable (Coordinate coordinate) {
		return (Math.abs(coordinate.row - emptyCoordinate.row) == 1 && 
				coordinate.col - emptyCoordinate.col == 0) 
				|| // ^same column, row difference is 1. \/same row, column difference is 1.
				(coordinate.row - emptyCoordinate.row == 0 &&
				Math.abs(coordinate.col - emptyCoordinate.col) == 1);
	}
	
	/**
	 * Checks to see if there are 4 of the same number visible among all the tiles
	 * @return true if the puzzle is in a losing state
	 */
	public boolean hasLost () {
		int count[] = new int[5];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board[row][col] != null) {
					if (++count[board[row][col].getVisibleNum()] == 4) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks to see if the puzzle is in a winning configuration
	 * @return true if the puzzle is won.
	 */
	public boolean hasWon () {
		// Check empty space first, as that can quickly spot if the board is not won.
		if (emptyCoordinate.row != 1 || emptyCoordinate.col != 1) {
			return false;
		}
		// Check first row
		for (int col = 0; col < 3; col++) {
			if (board[0][col].isFlipped || board[0][col].getVisibleNum() != col + 1) {
				return false;
			}
		}
		// Check third row
		for (int col = 0; col < 3; col++) {
			if (!board[2][col].isFlipped || board[2][col].getVisibleNum() != 3 - col) {
				return false;
			}
		}
		// Check tiles in second row. Must check to ensure proper face is showing. Cannot assume last tile is in right position
		// just because everything else is in the right position.
		if (!board[1][0].isFlipped || board[1][0].getVisibleNum() != 4 
				|| board[1][2].isFlipped || board[1][2].getVisibleNum() != 4) {
			return false;
		}
		return true;
	}
	
	/**
	 * Assume that the tile has already been validated as moveable.
	 * Swaps the tile with the empty space.
	 * @param coordinate The row and column of the tile to be swapped with the empty space.
	 */
	public void swapTile (Coordinate coordinate) {
		board[coordinate.row][coordinate.col].flipTile();
		board[emptyCoordinate.row][emptyCoordinate.col] = board[coordinate.row][coordinate.col];
		board[coordinate.row][coordinate.col] = null;
		emptyCoordinate = coordinate;
		moves++;
	}
	
	/**
	 * @return The number of moves made in the puzzle.
	 */
	public int getMoves () {
		 return moves;
	}
	
	/**
	 * Returns the board of the puzzle.
	 * @return A 2D array of tiles with null indicating the empty space.
	 */
	public Tile[][] getBoard () {
		return board;
	}
	
	/**
	 * Changes the state of gameOver to indicate that the puzzle has been finished.
	 */
	public void endGame () {
		gameOver = true;
	}
	
	/**
	 * Checks to see if the puzzle is considered finished.
	 * @return
	 */
	public boolean isGameOver () {
		return gameOver;
	}
}
