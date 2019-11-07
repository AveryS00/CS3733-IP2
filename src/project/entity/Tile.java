package project.entity;

public class Tile {
	
	int topNum;
	int bottomNum;
	boolean isFlipped;
	
	/**
	 * Constructs a Tile with the given parameters
	 * @param topNum The number shown when the tile is face up
	 * @param bottomNum The number shown when the tile is face down
	 * @param isFlipped Whether the tile starts face up or down
	 */
	public Tile (int topNum, int bottomNum, boolean isFlipped) {
		this.topNum = topNum;
		this.bottomNum = bottomNum;
		this.isFlipped = isFlipped;
	}
	
	/**
	 * Flips the tile
	 */
	void flipTile () {
		isFlipped = !isFlipped;
	}
	
	/**
	 * Getter for if Flipped.
	 * @return isFlipped
	 */
	boolean getFlipped () {
		return isFlipped;
	}
	
	/**
	 * topNum is associated with the tile not being flipped
	 * @return bottomNum if isFlipped is true, topNum otherwise
	 */
	int getVisibleNum () {
		if (isFlipped) {
			return bottomNum;
		} else {
			return topNum;
		}
	}
}
