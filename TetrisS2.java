/**Creates the S2 piece and all it's rotations 
 * 
 * @author elyssakiva
 *
 */
public class TetrisS2 extends TetrisPiece {
	public TetrisS2() {
		pieceRotation = 0;
		filledSquares = new boolean[2][4][4];
		boolean[][] s20 = { { true, true, false, false },
				{ false, true, true, false }, { false, false, false, false },
				{ false, false, false, false } };
		boolean[][] s21 = { { false, true, false, false },
				{ true, true, false, false }, { true, false, false, false },
				{ false, false, false, false } };
		filledSquares[0] = s20;
		filledSquares[1] = s21;
	}

}
