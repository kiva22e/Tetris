/**Creates the Stick piece and all it's rotations 
 * 
 * @author elyssakiva
 *
 */
public class TetrisStick extends TetrisPiece {
	public TetrisStick() {
		pieceRotation = 0;
		filledSquares = new boolean[2][4][4];
		boolean[][] stick0 = { { true, false, false, false },
				{ true, false, false, false }, { true, false, false, false },
				{ true, false, false, false } };
		boolean[][] stick1 = { { true, true, true, true },
				{ false, false, false, false }, { false, false, false, false },
				{ false, false, false, false } };
		filledSquares[0] = stick0;
		filledSquares[1] = stick1;
	}

}
