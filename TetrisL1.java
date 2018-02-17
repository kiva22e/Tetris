/**Creates the L1 piece and all it's rotations 
 * 
 * @author elyssakiva
 *
 */
public class TetrisL1 extends TetrisPiece {
	public TetrisL1() {
		pieceRotation=0;
		filledSquares = new boolean[4][4][4];
		boolean[][] l10 = { { true, false, false, false },
				{ true, false, false, false }, { true, true, false, false },
				{ false, false, false, false } };
		boolean[][] l11 = { { true, true, true, false },
				{ true, false, false, false }, { false, false, false, false },
				{ false, false, false, false } };
		boolean[][] l12 = { { true, true, false, false },
				{ false, true, false, false }, { false, true, false, false },
				{ false, false, false, false } };
		boolean[][] l13 = { { false, false, true, false },
				{ true, true, true, false }, { false, false, false, false },
				{ false, false, false, false } };
		filledSquares[0] = l10;
		filledSquares[1] = l11;
		filledSquares[2] = l12;
		filledSquares[3] = l13;

	}

}
