package model;

import java.util.ArrayList;
import java.util.*;

public class MemoryGame {

	private static final int DEFAULT_SIZE = 4;
	private int tilesSelected;
	private int pairsFound;
	private Tile lastTile;
	private Tile lastTile2;
	private int gameBoardSize;
	private ArrayList<Integer> pairs = new ArrayList<Integer>();
	private int pair;
	private Tile[][] gameBoard;

	public MemoryGame() {
		gameBoardSize = DEFAULT_SIZE;
		gameBoard = new Tile[gameBoardSize][gameBoardSize];
	}

	public MemoryGame(int gameSize) {
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
				gameBoard[i][j].setLocation(i, j);
				k++;
				if (k == ((gameBoardSize * gameBoardSize) / 2)) {
					k = 0;
					Collections.shuffle(pairs);
				}
			}
		}
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
			sc.close();
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
		++tilesSelected;
		if (tilesSelected == 2) {
			if (lastTile.getValue() == lastTile2.getValue()) {
				lastTile.setMatch(true);
				lastTile2.setMatch(true);
				pairsFound++;
			}
		}
	}

	public int getPairsFound() {
		return pairsFound;
	}

	public void setTilesSelected() {
		tilesSelected = 0;
	}

	public int getTilesSelected() {
		return tilesSelected;
	}

	public Tile getLastTile() {
		return lastTile;
	}

	public Tile getLastTile2() {
		return lastTile2;
	}

	public int getGameBoardSize() {
		return gameBoardSize;
	}

	public int getVal(int x, int y) {
		return gameBoard[x][y].getValue();
	}

	public Tile getTile(int x, int y) {
		return gameBoard[x][y];

	}

	public boolean hasWon() {
		if (pairsFound == (gameBoardSize * gameBoardSize) / 2) {
			return true;
		}
		return false;
	}
}
