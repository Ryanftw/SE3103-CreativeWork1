package test;

import model.MemoryGame;
import model.Tile;

public class MemoryGameTest {

	public static void main(String[] args) {
		MemoryGame g1 = new MemoryGame(6);
		g1.init();
		g1.printList();
		g1.getVal(2, 3);
		// g1.playGame();
		System.out.println("---------------------------");
		for (int i = 0; i < g1.getGameBoardSize(); i++) {
			for (int j = 0; j < g1.getGameBoardSize(); j++) {
				System.out.println(g1.getTile(i, j).getValue());
			}
		}

	}

}