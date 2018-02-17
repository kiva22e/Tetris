/**The controller for the tetris gui version. takes in information from the player in the form of what keys are pressed and updates the game, board
 * and view accordingly
 * @author elyssakiva
 * @version 1
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class TetrisGameGUIController extends JPanel implements KeyListener {
	
	/** speed at which the piece drops**/
	private int dropRate=1000;
	/** instance of game which the controller used to move the piece**/
	private TetrisGame game;
	/** timer used to move the piece down **/
	private Timer gameTimer;
	/** holds the lines part of the score**/
	private JLabel linesLabel;
	/** holds the tetrises part of the score**/
	private JLabel tetrisesLabel;
	/** view to be updated as the game progresses **/
	private TetrisBoardGUIView view;
	/** board to be updates as the game progresses**/
	private TetrisBoard board;
	
	/** creates, game, board, score, view and timer **/
	public TetrisGameGUIController(){
		super(new BorderLayout());
		addKeyListener(this);
		setFocusable(true);
		game = new TetrisGame();
		board = game.getTetrisBoard();
		createScore();
		createView();
		setUpTimer();
	}
	
	private void createScore(){
		JPanel score = new JPanel();
		linesLabel = new JLabel("Lines cleared "+board.RowsCleared());
		tetrisesLabel = new JLabel("Tetrises cleared "+board.numTetrises());
		score.add(linesLabel);
		score.add(tetrisesLabel);
		this.add(score, BorderLayout.NORTH);
		
		
	}
	private void createView(){
	view = new TetrisBoardGUIView(board);
	this.add(view, BorderLayout.CENTER);

	
		
	}
	public void refreshDisplay(){
		view.repaint();
		linesLabel.setText("Lines cleared "+board.RowsCleared());
		tetrisesLabel.setText("Tetrises cleared "+board.numTetrises());
		
	}
	/** action preformed when the timer runs out. the action is move down**/
	ActionListener listener = new ActionListener(){
	public void actionPerformed(ActionEvent e){
		game.attemptMove(2);
		refreshDisplay();
	}
	};
	
	private void setUpTimer(){
		gameTimer = new Timer(dropRate, listener);
		gameTimer.start();
		
	}
	/** when the left, right or down key is pressed if it is a legal move the piece is moved down
	 * if z is pressed rotate counter clockwise, if x is pressed rotate clockwise.**/
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key==KeyEvent.VK_LEFT){
			game.attemptMove(1);
		} else if(key==KeyEvent.VK_RIGHT){
			game.attemptMove(0);
		} else if(key==KeyEvent.VK_DOWN){
			game.attemptMove(2);
		} else if(key==KeyEvent.VK_Z){
			game.attemptMove(4);
			
		} else if (key==KeyEvent.VK_X){
			game.attemptMove(3);
		}
		refreshDisplay();

		
	}
	/** needed for implementation**/
	public void keyTyped(KeyEvent e) {	
	}
	/**needed for implementation **/
	public void keyReleased(KeyEvent e) {	
	}

}
