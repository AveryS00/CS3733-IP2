package project.entity;



public class Puzzle {

	Tile board[][];
	Coordinate emptyCoordinate;
	
	/**
	 * Constructs a new puzzle in initial configuration.
	 */
	public Puzzle() {
		board = initConfig();
		emptyCoordinate = new Coordinate (0, 2);
	}
	
	/**
	 * Constructs the initial configuration of the board. The empty tile is represented by null
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
	 * @param row The row of the tile
	 * @param col The col of the tile
	 * @return true if the tile is next to the empty space
	 */
	boolean isMoveable (Coordinate coordinate) {
		return Math.abs(coordinate.row - emptyCoordinate.row) == 1 &&
				Math.abs(coordinate.row - emptyCoordinate.row) == 1;
	}
}
