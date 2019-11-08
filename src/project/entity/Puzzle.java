package project.entity;



public class Puzzle {

	Tile board[][];
	Coordinate emptyCoordinate;
	
	/**
	 * Constructs a new puzzle in initial configuration.
	 */
	public Puzzle() {
		board = initConfig();
		emptyCoordinate = new Coordinate (2, 0);
	}
	
	/**
	 * Constructs the initial configuration of the board. The empty tile is represented by null
	 * Initial configuration for student ID ending in 6.
	 * @return the 2D tile array of the board
	 */
	Tile[][] initConfig () {
		Tile t1 = new Tile(1, 4, false);
		Tile t2 = new Tile(1, 4, false);
		Tile t3 = new Tile(1, 4, false);
		Tile t4 = new Tile(1, 4, false);
		Tile t5 = new Tile(1, 4, false);
		Tile t6 = new Tile(1, 4, false);
		Tile t8 = new Tile(1, 4, false);
		Tile t9 = new Tile(1, 4, false);
		
		Tile tiles[][] = {{t1,   t2, t3}, 
						  {t4,   t5, t6}, 
						  {null, t8, t9}};
		
		return tiles;
	}
	
	/**
	 * Checks if the tile is next to the empty space and can be moved.
	 * @param coordinate The x, y coordinate of the tile.
	 * @return true if the tile is next to the empty space
	 */
	boolean isMoveable (Coordinate coordinate) {
		return (Math.abs(coordinate.row - emptyCoordinate.row) == 1 && 
				coordinate.col - emptyCoordinate.col == 0) 
				|| // ^same column, row difference is 1. \/same row, column difference is 1.
				(coordinate.row - emptyCoordinate.row == 0 &&
				Math.abs(coordinate.col - emptyCoordinate.col) == 1);
	}
}
