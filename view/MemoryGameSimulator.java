package view;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.ButtonClickListener;
import model.MemoryGame;

import java.awt.GridLayout;
import java.awt.BorderLayout;

public class MemoryGameSimulator {

	private MemoryGame memGame;// = new MemoryGame();
	private int rows;
	private JFrame window;
	private JButton[][] tileButtons;
	private JButton exit = new JButton("Exit");
	private String[][] myText;
	private JPanel[] buttonRows;
	private JTextArea foundDisplay = new JTextArea();;
	private JTextArea youWinDisplay = new JTextArea("You Win!!!");

	public MemoryGameSimulator(JFrame window, int x) {
		memGame = new MemoryGame(x);
		this.window = window;
		window.setTitle("Memory Game Simulator");
		rows = memGame.getGameBoardSize();
		tileButtons = new JButton[rows][rows];
		buttonRows = new JPanel[rows];
		myText = new String[rows][rows];
		youWinDisplay.setVisible(false);
		memGame.init();
	}

	public void init() {
		Container cp = window.getContentPane();
		JPanel centerPanel = new JPanel();
		cp.add(BorderLayout.CENTER, centerPanel);
		centerPanel.setLayout(new GridLayout(rows, 1));
		for (int i = 0; i < rows; i++) {
			buttonRows[i] = new JPanel();
			for (int j = 0; j < rows; j++) {
				tileButtons[i][j] = new JButton("Tile : " + (i + 1) * (j + 1));
				myText[i][j] = new String("Tile : " + (i + 1) * (j + 1));
				buttonRows[i].add(tileButtons[i][j]);
			}
			centerPanel.add(buttonRows[i]);
		}

		ButtonClickListener buttonClickListener = new ButtonClickListener(this);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < rows; j++) {
				tileButtons[i][j].addActionListener(buttonClickListener);
			}
		}

		JPanel southPanel = new JPanel();
		cp.add(BorderLayout.SOUTH, southPanel);
		southPanel.setLayout(new GridLayout(3, 1));
		JPanel foundRow = new JPanel();
		foundDisplay.setText("Pairs found : ");
		JPanel exitRow = new JPanel();
		JPanel youWinRow = new JPanel();
		foundRow.add(foundDisplay);
		exitRow.add(exit);
		youWinRow.add(youWinDisplay);
		southPanel.add(foundRow);
		southPanel.add(exitRow);
		southPanel.add(youWinRow);

		exit.addActionListener(e -> {
			window.getContentPane().removeAll();
			var menu = new MenuScreen(window);
			menu.init();
			window.pack();
			window.revalidate();
		});
	}

	public void setYouWonDisplay() {
		youWinDisplay.setVisible(true);
	}

	public int getRows() {
		return rows;
	}

	public JButton getButton(int x, int y) {
		return tileButtons[x][y];
	}

	public MemoryGame getMemoryGame() {
		return memGame;
	}

	public String getMyText(int x, int y) {
		return myText[x][y];
	}

	public JTextArea getDisplay() {
		return foundDisplay;
	}
}