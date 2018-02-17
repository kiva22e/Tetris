/**Creates the T piece and all it's rotations 
 * 
 * @author elyssakiva
 *
 */
public class TetrisT extends TetrisPiece {
	public TetrisT() {
		pieceRotation = 0;
		filledSquares = new boolean[4][4][4];
		//
		boolean[][] t0 = { { true, true, true, false },
				{ false, true, false, false }, { false, false, false, false },
				{ false, false, false, false } };
		boolean[][] t1 = { { false, true, false, false },
				{ true, true, false, false }, { false, true, false, false },
				{ false, false, false, false } };
		boolean[][] t2 = { { false, true, false, false },
				{ true, true, true, false }, { false, false, false, false },
				{ false, false, false, false } };
		boolean[][] t3 = { { true, false, false, false },
				{ true, true, false, false }, { true, false, false, false },
				{ false, false, false, false } };
		filledSquares[0] = t0;
		filledSquares[1] = t1;
		filledSquares[2] = t2;
		filledSquares[3] = t3;
	}

}
