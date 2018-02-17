/**
 * Part of the logic. This class holds the game play elements such as what
 * happens when particular keys are pressed and defines the endround conditions
 * 
 * @author elyssakiva
 * @version 1
 */
public class TetrisGame {
	private static final int RIGHT = 0;
	private static final int LEFT = 1;
	private static final int DOWN = 2;
	private static final int CW = 3;
	private static final int CCW = 4;
	TetrisBoard tetrisBoard;

	public TetrisGame() {
		tetrisBoard = new TetrisBoard();

	}

	/** moves the piece based on the information passed in by the user
	 * 
	 * @param moveType
	 */
	public void attemptMove(int moveType) {
		if (moveType == RIGHT) {
			tetrisBoard.moveRight();

		} else if (moveType == LEFT) {
			tetrisBoard.moveLeft();

		} else if (moveType == DOWN) {
			endRound();

		} else if (moveType == CW) {
			tetrisBoard.rotateCW();

		} else if (moveType == CCW) {
			tetrisBoard.rotateCCW();

		} else {

		}

	}

	/** finishes each round. if the game is lost freezes the board
	 * 
	 */
	private void endRound() {
		// if the piece can't move down anymore, lands it, removes any full rows
		// and updates the score, adds a new piece
		if (tetrisBoard.moveDown() == false) {
			tetrisBoard.landPiece();
			tetrisBoard.numberOfFormedLines();
			tetrisBoard.addNewPiece();
			TetrisPiece currentPiece = tetrisBoard.getCurrentPiece();
			int[] currentLocation = tetrisBoard.getCurrentPieceGridPosition();
			// if there isn't space for the piece to be added to the board print
			// game over and start a new game
			if (tetrisBoard.validMove(currentPiece,
					currentPiece.getPieceRotation(), currentLocation[0],
					currentLocation[1]) == false) {	
				System.out.println("Game Over");
				tetrisBoard=new TetrisBoard();
			}

		}

	}

	public TetrisBoard getTetrisBoard() {
		return tetrisBoard;
	}

}
