/**
 * abstract class which contains the constructor for the piece and methods which
 * return information about a piece this is part of the logic
 * 
 * @author elyssakiva
 *
 */
public abstract class TetrisPiece {
	/**
	 * 3 dimensional array maintaining which squares are filled first dimension
	 * is rotation (index 0: 0 degrees, index 1: 90 degrees, index 2: 180
	 * degrees, index 3: 270 degrees) second and third dimensions create 4x4
	 * grid with true values indicating filled squares
	 * 
	 */
	protected boolean[][][] filledSquares;
	/**
	 * Maintains the current rotation.
	 * 
	 */
	protected int pieceRotation;

	public TetrisPiece() {

	}

	/**
	 * Rotate the piece clockwise by 90 degrees.
	 * 
	 */
	public void rotateCW() {
		if (pieceRotation < filledSquares.length - 1) {
			pieceRotation += 1;
		} else
			pieceRotation = 0;

	}

	/**
	 * Rotate the piece counter-clockwise by 90 degrees.
	 * 
	 */
	public void rotateCCW() {
		if (pieceRotation > 0) {
			pieceRotation -= 1;
		} else
			pieceRotation = filledSquares.length - 1;

	}

	/**
	 * Get the rotation of this piece.
	 * 
	 * @return int representing piece rotation
	 */
	public int getPieceRotation() {
		return pieceRotation;
	}

	/**
	 * Checks if there is a TetrisBlock at the (row, col) position for the
	 * rotation rot, where rot is 0, 90, 180 or 270 degrees.
	 * 
	 * @param rot
	 * @param row
	 * @param col
	 * @return true if there is
	 */
	public boolean isFilled(int rot, int row, int col) {
		return filledSquares[rot][row][col];

	}
}
