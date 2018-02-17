/**Creates the S1 piece and all it's rotations 
 * 
 * @author elyssakiva
 *
 */
public class TetrisS1 extends TetrisPiece {
	public TetrisS1() {
		pieceRotation = 0;
		filledSquares = new boolean[2][4][4];
		boolean[][] s10 = { { false, true, true, false },
				{ true, true, false, false }, { false, false, false, false },
				{ false, false, false, false } };
		boolean[][] s11 = { { true, false, false, false },
				{ true, true, false, false }, { false, true, false, false },
				{ false, false, false, false } };
		filledSquares[0] = s10;
		filledSquares[1] = s11;
	}

}
