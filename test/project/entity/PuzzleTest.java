package project.entity;

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
	public void testIsMoveable () {
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
	
	@Test
	public void testHasLost () {
		//	1T	0	1B
		//	2B	1B	2T
		//	3B	2B	1T
		Tile[][] fourRepeats = {{new Tile(1, 4, false), null, new Tile(4, 1, true)},
				{new Tile(3, 2, true), new Tile(4, 1, true), new Tile(2, 3, false)},
				{new Tile(2, 3, true), new Tile(3, 2, true), new Tile(1, 4, false)}};
		puzzle.board = fourRepeats;
		
		assertTrue(puzzle.hasLost());
	}
	
	@Test
	public void testHasWon () {
			//	1T	2T	3T
			//	4B	0	4T
			//	3B	2B	1B
			Tile[][] winner = {{new Tile(1, 4, false), new Tile(2, 3, false), new Tile(3, 2, false)},
					{new Tile(1, 4, true), null, new Tile(4, 1, false)},
					{new Tile(2, 3, true), new Tile(3, 2, true), new Tile(4, 1, true)}};
			puzzle.board = winner;
			puzzle.emptyCoordinate = new Coordinate(1,1);
			
			assertTrue(puzzle.hasWon());
			
			// Simulate a swap of 2B and empty space so board should not be winning
			puzzle.board[1][1] = new Tile(3, 2, false);
			puzzle.board[2][1] = null;
			puzzle.emptyCoordinate = new Coordinate(2,1);
			
			assertFalse(puzzle.hasWon());
	}
	
	@Test
	public void testSwapTile () {
		//	1T	0	3T
		//	4B	3B	4T
		//	3B	2B	1B
		Tile[][] winner = {{new Tile(1, 4, false), null, new Tile(3, 2, false)},
				{new Tile(1, 4, true), new Tile(2, 3, true), new Tile(4, 1, false)},
				{new Tile(2, 3, true), new Tile(3, 2, true), new Tile(4, 1, true)}};
		
		puzzle.board = winner;
		puzzle.emptyCoordinate = new Coordinate(0, 1); 
		
		puzzle.swapTile(new Coordinate(1, 1));
		assertTrue(puzzle.hasWon());
		assertEquals(puzzle.moves, 1);
	}
}
