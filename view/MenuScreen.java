package view;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuScreen {

	private JFrame window;

	public MenuScreen(JFrame window) {
		this.window = window;
		window.setTitle("Menu");
	}

	public void init() {
		Container cp = window.getContentPane();
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 400));

		JButton memGameButton = new JButton("MemoryGame");
		panel.add(memGameButton);
		cp.add(panel);

		memGameButton.addActionListener(e -> {
			window.getContentPane().removeAll();
			var mem = new MemoryGameSimulator(window);
			mem.init();
			window.pack();
			window.revalidate();
		});
	}

}