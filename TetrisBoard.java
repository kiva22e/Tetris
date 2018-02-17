/**
 * Part of the logic. This class controls the board and what appears on it.
 * 
 * @author elyssakiva
 * @version 1
 *
 */
public class TetrisBoard {

	private static final int NUM_COLS = 10;
	private static final int NUM_ROWS = 18;
	/** holds the total number of rows cleared over the corse of a game **/
	int rowsCleared;
	/** holds the total number of tetrises completed over the course of a game **/
	int numTetrises;
	/** board matrix **/
	boolean[][] blockMatrix;
	TetrisPiece currentPiece;
	int[] currentPieceGridPosition;

	/** create starting board and add a piece to it **/
	public TetrisBoard() {
		initBoard();
		addNewPiece();

	}

	/**
	 * Add a new random Tetris piece to the board at grid position (0, 3).
	 * 
	 */
	public void addNewPiece() {
		initCurrentGP();
		currentPieceGridPosition[0] = 0;
		currentPieceGridPosition[1] = 3;
		int randGen = (int) (Math.random() * 7);
		if (randGen == 0) {
			currentPiece = new TetrisL1();
		}
		if (randGen == 1) {
			currentPiece = new TetrisL2();
		}
		if (randGen == 2) {
			currentPiece = new TetrisS1();
		}
		if (randGen == 3) {
			currentPiece = new TetrisS2();
		}
		if (randGen == 4) {
			currentPiece = new TetrisSquare();
		}
		if (randGen == 5) {
			currentPiece = new TetrisStick();
		}
		if (randGen == 6) {
			currentPiece = new TetrisT();
		}

	}

	/**
	 * Checks if placing the piece at grid position (row, col) with the rotation
	 * rot would cause a collision
	 * 
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return
	 */
	private boolean detectCollision(TetrisPiece piece, int rot, int gridRow,
			int gridCol) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (piece.isFilled(rot, i, j)) {
					if (blockMatrix[gridRow + i][gridCol + j]) {
						return true;

					}
				}

			}
		}
		return false;
	}

	/**
	 * Checks if placing the piece at grid position (row, col) with the rotation
	 * rot would cause an out of bounds condition
	 * 
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return
	 */

	private boolean detectOutOfBounds(TetrisPiece piece, int rot, int gridRow,
			int gridCol) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (piece.isFilled(rot, i, j))
					if (gridRow + i > NUM_ROWS - 1 || gridCol < 0
							|| gridCol + j > NUM_COLS - 1) {
						return true;
					}
			}
		}
		return false;
	}

	public boolean[][] getBlockMatrix() {
		return blockMatrix;
	}

	public TetrisPiece getCurrentPiece() {
		return currentPiece;
	}

	public int[] getCurrentPieceGridPosition() {
		return currentPieceGridPosition;
	}

	/**
	 * Initialize the 2D board array to have all false values
	 * 
	 */
	private void initBoard() {
		blockMatrix = new boolean[NUM_ROWS][NUM_COLS];
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_COLS; j++) {
				blockMatrix[i][j] = false;
			}
		}

	}

	/**
	 * Initialize an int array of length two to keep track of the grid position
	 * of the current piece (row, col)
	 * 
	 */
	private void initCurrentGP() {
		currentPieceGridPosition = new int[2];

	}

	/**
	 * Update the board array to reflect the newly landed piece's filled squares
	 * using the currentGridPosition values and the currentPiece's rotation
	 * value.
	 * 
	 */
	public void landPiece() {
		// walk the matrix and if you reach an entry that overlaps with the
		// piece array check if that entry is filled then set the block matrix
		// to be true
		for (int i = 0; i < blockMatrix.length; i++) {
			for (int j = 0; j < blockMatrix[i].length; j++) {
				if ((i >= currentPieceGridPosition[0] && i <= currentPieceGridPosition[0] + 3)
						&& (j >= currentPieceGridPosition[1] && j <= currentPieceGridPosition[1] + 3)) {
					if (currentPiece.isFilled(currentPiece.getPieceRotation(),
							i - currentPieceGridPosition[0], j
									- currentPieceGridPosition[1])) {
						blockMatrix[i][j] = true;
					}
				}
			}
		}
	}

	/**
	 * Check if moving down is valid and move down
	 * 
	 * @return true if can move down
	 */
	public boolean moveDown() {
		if (validMove(currentPiece, currentPiece.getPieceRotation(),
				currentPieceGridPosition[0] + 1, currentPieceGridPosition[1])) {
			currentPieceGridPosition[0] += 1;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check if moving left is valid and move left
	 * 
	 * @return true if can move left
	 */
	public boolean moveLeft() {
		if (validMove(currentPiece, currentPiece.getPieceRotation(),
				currentPieceGridPosition[0], currentPieceGridPosition[1] - 1)) {
			currentPieceGridPosition[1] -= 1;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check if moving right is valid and move right
	 * 
	 * @return true if can move right
	 */
	public boolean moveRight() {
		if (validMove(currentPiece, currentPiece.getPieceRotation(),
				currentPieceGridPosition[0], currentPieceGridPosition[1] + 1)) {
			currentPieceGridPosition[1] += 1;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Detect and remove any lines formed. updates the rowsCleared and numTetris
	 * values based on the lines removed
	 * 
	 * @return updates rowsCleared and numTetrises
	 */
	public int numberOfFormedLines() {
		int rowsThisRound = 0;
		for (int i = 0; i < blockMatrix.length; i++) {
			int counter = 0;
			for (int j = 0; j < blockMatrix[i].length; j++) {
				if (blockMatrix[i][j]) {
					counter += 1;
					if (counter == NUM_COLS) {
						removeLine(i);
						rowsThisRound += 1;
					}
				}
			}

		}
		if (rowsThisRound < 4) {
			System.out.println(rowsCleared);
			return rowsCleared += rowsThisRound;
		} else {
			return numTetrises += 1;
		}

	}

	public int RowsCleared() {
		return rowsCleared;
	}

	public int numTetrises() {
		return numTetrises;
	}

	/**
	 * Remove the line at row in the model and move the rows above it down
	 * 
	 * @param row
	 */
	private void removeLine(int row) {
		for (int i = row; i >= 0; i--) {
			if (i == 0) {
				for (int j = 0; j < blockMatrix[i].length; j++) {
					blockMatrix[i][j] = false;
				}
			} else {
				for (int j = 0; j < blockMatrix[i].length; j++) {
					blockMatrix[i][j] = blockMatrix[i - 1][j];
				}

			}
		}

	}

	/**
	 * Check if rotating counter clockwise is valid if so rotate
	 * 
	 * @return true if you can rotate CCW
	 */
	public boolean rotateCCW() {
		currentPiece.rotateCCW();
		if (validMove(currentPiece, currentPiece.getPieceRotation(),
				currentPieceGridPosition[0], currentPieceGridPosition[1]) == false) {
			currentPiece.rotateCW();
			return false;
		}
		return true;
	}

	/**
	 * Check if rotating clockwise is valid if so rotate
	 * 
	 * @returntrue if you can rotate CW
	 */
	public boolean rotateCW() {
		currentPiece.rotateCW();
		if (validMove(currentPiece, currentPiece.getPieceRotation(),
				currentPieceGridPosition[0], currentPieceGridPosition[1]) == false) {
			currentPiece.rotateCCW();
			return false;
		}
		return true;
	}

	/**
	 * Checks if placing the piece at grid position (row, col) with the rotation
	 * rot (values can be 0, 90, 180, 270) is a valid move.
	 * 
	 * @param piece
	 * @param rot
	 * @param gridRow
	 * @param gridCol
	 * @return
	 */
	public boolean validMove(TetrisPiece piece, int rot, int gridRow,
			int gridCol) {
		if (detectOutOfBounds(piece, rot, gridRow, gridCol) == false
				&& detectCollision(piece, rot, gridRow, gridCol) == false) {
			return true;
		}
		return false;
	}

}
