package test;

import model.MemoryGame;
import model.Tile;

public class MemoryGameTest {

	public static void main(String[] args) {
		MemoryGame g1 = new MemoryGame(6);
		g1.init();
		g1.printList();
		g1.getVal(2, 3);
		g1.playGame();

	}

}