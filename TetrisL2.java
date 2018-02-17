/**Creates the L2 piece and all it's rotations 
 * 
 * @author elyssakiva
 *
 */
public class TetrisL2 extends TetrisPiece {
	public TetrisL2() {
		pieceRotation = 0;
		filledSquares = new boolean[4][4][4];
		boolean[][] l20 = { { false, true, false, false },
				{ false, true, false, false }, { true, true, false, false },
				{ false, false, false, false } };
		boolean[][] l21 = { { true, false, false, false },
				{ true, true, true, false }, { false, false, false, false },
				{ false, false, false, false } };
		boolean[][] l22 = { { true, true, false, false },
				{ true, false, false, false }, { true, false, false, false },
				{ false, false, false, false } };
		boolean[][] l23 = { { true, true, true, false },
				{ false, false, true, false }, { false, false, false, false },
				{ false, false, false, false } };
		filledSquares[0] = l20;
		filledSquares[1] = l21;
		filledSquares[2] = l22;
		filledSquares[3] = l23;

	}

}
