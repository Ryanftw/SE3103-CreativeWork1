package model;

public class Tile {

	public int value;
	public boolean isMatched;

	public Tile() {
		this.value = 0;
	}

	public Tile(int value) {
		this.value = value;
	}

	public void setMatch(boolean matching) {
		isMatched = matching;
	}

	public boolean getMatch(Tile c) {
		return isMatched;
	}

	public void setValue(int x) {
		value = x;
	}

	public int getValue() {
		return value;
	}

}