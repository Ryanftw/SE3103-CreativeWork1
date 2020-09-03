package view;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MenuScreen {

	private JFrame window;
	private JButton game4 = new JButton("New memory game : Board Size = 4");
	private JButton game6 = new JButton("New memory game : Board Size = 6");
	private JButton game8 = new JButton("New memory game : Board Size = 8");
	private JButton game10 = new JButton("New memory game : Board Size = 10");
	private JButton game12 = new JButton("New memory game : Board Size = 12");

	public MenuScreen(JFrame window) {
		this.window = window;
		window.setTitle("Menu");
	}

	public void init() {
		Container cp = window.getContentPane();
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 200));
		JPanel row1 = new JPanel();
		JPanel row2 = new JPanel();
		JPanel row3 = new JPanel();
		JPanel row4 = new JPanel();
		JPanel row5 = new JPanel();
		JPanel row6 = new JPanel();
		JTextArea gameSelection = new JTextArea();
		gameSelection.setText("Select a game board size to start a new game.");
		panel.setLayout(new GridLayout(6, 1));
		row1.add(gameSelection);
		row2.add(game4);
		row3.add(game6);
		row4.add(game8);
		row5.add(game10);
		row6.add(game12);
		panel.add(row1);
		panel.add(row2);
		panel.add(row3);
		panel.add(row4);
		panel.add(row5);
		panel.add(row6);
		cp.add(BorderLayout.CENTER, panel);
		game4.addActionListener(e -> {
			window.getContentPane().removeAll();
			var mem = new MemoryGameSimulator(window, 4);
			mem.init();
			window.pack();
			window.revalidate();
		});
		game6.addActionListener(e -> {
			window.getContentPane().removeAll();
			var mem = new MemoryGameSimulator(window, 6);
			mem.init();
			window.pack();
			window.revalidate();
		});
		game8.addActionListener(e -> {
			window.getContentPane().removeAll();
			var mem = new MemoryGameSimulator(window, 8);
			mem.init();
			window.pack();
			window.revalidate();
		});
		game10.addActionListener(e -> {
			window.getContentPane().removeAll();
			var mem = new MemoryGameSimulator(window, 10);
			mem.init();
			window.pack();
			window.revalidate();
		});
		game12.addActionListener(e -> {
			window.getContentPane().removeAll();
			var mem = new MemoryGameSimulator(window, 12);
			mem.init();
			window.pack();
			window.revalidate();
		});
	}
}