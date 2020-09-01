package view;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.MemoryGame;
import model.Tile;

import java.awt.GridLayout;
import java.awt.BorderLayout;

public class MemoryGameSimulator {

	private MemoryGame memGame = new MemoryGame();
	private int rows;
	private JFrame window;
	private Tile[][] tiles;
	private JButton[][] tileButtons;
	private JPanel[] buttonRows;

	public MemoryGameSimulator(JFrame window) {
		this.window = window;
		window.setTitle("Memory Game Simulator");
		rows = memGame.getGameBoardSize();
		tiles = new Tile[rows][rows];
		tileButtons = new JButton[rows][rows];
		buttonRows = new JPanel[rows];
	}

	public void init() {
		Container cp = window.getContentPane();
		JPanel centerPanel = new JPanel();
		cp.add(centerPanel);
		centerPanel.setLayout(new GridLayout(rows, 1));
		for (int i = 0; i < rows; i++) {
			buttonRows[i] = new JPanel();
			for (int j = 0; j < rows; j++) {
				tileButtons[i][j] = new JButton("Tile : " + (i + 1) * (j + 1));
				buttonRows[i].add(tileButtons[i][j]);
			}
			centerPanel.add(buttonRows[i]);
		}
		JPanel southPanel = new JPanel();
	}

}