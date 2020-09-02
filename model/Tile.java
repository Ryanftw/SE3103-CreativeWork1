package model;

public class Tile {

	public int value;
	public String text;
	public String myText;
	public boolean isMatched;
	public int x;
	public int y;

	public Tile() {
		this.value = 0;
	}

	public Tile(int value) {
		this.value = value;
	}

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setMatch(boolean matching) {
		isMatched = matching;
	}

	public boolean getMatch() {
		return isMatched;
	}

	public int getValue() {
		return value;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}