/**
 * @author elyssakiva
 * @version 1
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class TetrisBoardGUIView extends JComponent {
	private TetrisBoard board;

	public TetrisBoardGUIView(TetrisBoard b) {
		board = b;

	}

	/**
	 * Paint the game.
	 * 
	 */
	public void paint(Graphics g) {
		int size = computeBlockSize();
		paintBoardOutline(g, size);
		boolean[][] temp = board.getBlockMatrix();
		TetrisPiece piece = board.getCurrentPiece();
		int[] pieceLocation = board.getCurrentPieceGridPosition();
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				if ((i >= pieceLocation[0] && i <= pieceLocation[0] + 3)
						&& (j >= pieceLocation[1] && j <= pieceLocation[1] + 3)) {
					if (piece.isFilled(piece.getPieceRotation(), i
							- pieceLocation[0], j - pieceLocation[1])
							|| temp[i][j]) {
						paintBlock(g, i * size, j * size, size);

					}

				} else if (temp[i][j]) {
					paintBlock(g, i * size, j * size, size);
				}
			}
		}

	}

	/**
	 * Compute the best block size for the current width and height.
	 * 
	 * @return best block size
	 */
	private int computeBlockSize() {
		int height = getHeight();
		int width = getWidth();
		if (width < height / 18 * 10) {
			return width / 10;
		} else {
			return height / 18;
		}
	}

	/**
	 * Paint the block at grid row, grid col and size blockSize
	 * 
	 * @param g
	 * @param row
	 * @param col
	 * @param blockSize
	 */
	private void paintBlock(Graphics g, int row, int col, int blockSize) {
		g.setColor(Color.BLUE);
		g.fillRect(col, row, blockSize, blockSize);
		g.setColor(Color.BLACK);
		g.drawRect(col, row, blockSize, blockSize);

	}

	/**
	 * paint the Board outline based on the blockSize
	 * 
	 * @param g
	 * @param blockSize
	 */
	private void paintBoardOutline(Graphics g, int blockSize) {
		int width = getWidth();
		g.drawRect(0, 0, blockSize * 10, blockSize * 18);

	}

}
