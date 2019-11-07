package entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PuzzleTest {
	
	Puzzle puzzle;
	
	@Before
	public void setup () {
		puzzle = new Puzzle();
	}
	
	@Test
	public void testIsMoveable() {
		// Board is in initial configuration, only moveable ones are (2, 1) and (1, 0)
		assertTrue(puzzle.isMoveable(new Coordinate(2,1)));
		assertTrue(puzzle.isMoveable(new Coordinate(1,0)));
		assertFalse(puzzle.isMoveable(new Coordinate(1,1)));
		assertFalse(puzzle.isMoveable(new Coordinate(2,0)));
		
		// Board now has empty space in middle
		Tile[][] emptyMiddle = {{new Tile(1,1,false), new Tile(1,1,false), new Tile(1,1,false)},
				{new Tile(1,1,false), null, new Tile(1,1,false)},
				{new Tile(1,1,false), new Tile(1,1,false), new Tile(1,1,false)}};
		puzzle.board = emptyMiddle;
		puzzle.emptyCoordinate = new Coordinate(1,1);
		
		assertTrue(puzzle.isMoveable(new Coordinate(0,1)));
		assertTrue(puzzle.isMoveable(new Coordinate(1,0)));
		assertTrue(puzzle.isMoveable(new Coordinate(1,2)));
		assertTrue(puzzle.isMoveable(new Coordinate(2,1)));
		assertFalse(puzzle.isMoveable(new Coordinate(1,1)));
		assertFalse(puzzle.isMoveable(new Coordinate(0,0)));
	}
}
