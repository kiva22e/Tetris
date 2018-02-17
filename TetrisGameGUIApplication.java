/** starts the game!
 * @author elyssakiva
 * @version 1
 */
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TetrisGameGUIApplication {
	public static int FRAME_WIDTH = 400;
    public static int FRAME_HEIGHT = 400;
	public static void main(java.lang.String[] args){
		JFrame tetrisFrame = new JFrame("Tetris!");
		tetrisFrame.add(new TetrisGameGUIController());
		tetrisFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		tetrisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tetrisFrame.setVisible(true);
	}

}
