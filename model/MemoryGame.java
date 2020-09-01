package model;

import java.util.ArrayList;
import java.util.*;

public class MemoryGame {

	private int tilesSelected;
	private int pairsFound;
	private Tile lastTile;
	private Tile lastTile2;
	private int gameBoardSize;
	private int defaultSize;
	private ArrayList<Integer> pairs = new ArrayList<Integer>();
	private int pair;
	private Tile[][] gameBoard;

	public MemoryGame() {
		tilesSelected = 0;
		pairsFound = 0;
		pair = 0;
		defaultSize = 6;
		gameBoard = new Tile[defaultSize][defaultSize];
	}

	public MemoryGame(int gameSize) {
		tilesSelected = 0;
		pairsFound = 0;
		pair = 0;
		defaultSize = 6;
		gameBoardSize = gameSize;
		gameBoard = new Tile[gameBoardSize][gameBoardSize];
	}

	public void init() {
		int rand;
		while (pair < (gameBoardSize * gameBoardSize) / 2) {
			rand = (int) (Math.random() * 100);
			if (pairs.contains(rand)) {
				// do nothing
			} else {
				++pair;
				pairs.add(rand);
			}
		}
		int k = 0;
		for (int i = 0; i < gameBoardSize; i++) {
			for (int j = 0; j < gameBoardSize; j++) {
				gameBoard[i][j] = new Tile(pairs.get(k));
				k++;
				if (k == ((gameBoardSize * gameBoardSize) / 2)) {
					k = 0;
					Collections.shuffle(pairs);
				}
			}
		}
	}

	public int getVal(int x, int y) {
		return gameBoard[x][y].getValue();
	}

	public void printList() {
		for (int i = 0; i < gameBoardSize; i++) {
			for (int j = 0; j < gameBoardSize; j++) {
				System.out.println(gameBoard[i][j].getValue());
			}
		}
	}

	public void playGame() {
		while (!notFinished()) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter x coord : ");
			int x = sc.nextInt();
			System.out.println("Enter y coord : ");
			int y = sc.nextInt();
			tilesSelected++;
			selectTile(x, y);
		}

		System.out.println("You won!");
		System.exit(1);
	}

	public boolean notFinished() {
		if (pairsFound == gameBoardSize) {
			return true;
		} else {
			return false;
		}
	}

	public void selectTile(int x, int y) {
		lastTile2 = lastTile;
		lastTile = gameBoard[x][y];
		if (tilesSelected == 2) {
			if (lastTile.getValue() == lastTile2.getValue()) {
				lastTile.setMatch(true);
				lastTile2.setMatch(true);
				pairsFound++;
				System.out.println("Pair found!\n");
			}
			tilesSelected = 0;
		}
	}
}
