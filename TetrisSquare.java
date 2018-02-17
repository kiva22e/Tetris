/**Creates the Sqaure piece and all it's rotations 
 * 
 * @author elyssakiva
 *
 */
public class TetrisSquare extends TetrisPiece {
	public TetrisSquare() {
		pieceRotation = 0;
		filledSquares = new boolean[1][4][4];
		boolean[][] sqaure = { { true, true, false, false },
				{ true, true, false, false }, { false, false, false, false },
				{ false, false, false, false } };
		filledSquares[0] = sqaure;
	}

}
