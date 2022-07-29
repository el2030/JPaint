package model;

public class Calculator {
	
	int x1;
	int x2;
	int y1;
	int y2;
	
	public Calculator (int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public int width() {
		if (x1 > x2) {
			return x1 - x2;
		}
		else
			return x2 - x1;
	}
	
	public int height() {
		if (y1 > y2) {
			return y1 - y2;
		}
		else
			return y2 - y1;
	}
	
	public int startX() {
		return Math.min(x2, x1);
	}
	
	public int startY() {
		return Math.min(y2, y1);
	}
	
	public int endX() {
		return Math.max(x2, x1);
	}
	
	public int endY() {
		return Math.max(y2, y1);
	}
	
	public int deltaX() {
		return x2 - x1;
	}
	
	public int deltaY() {
		return y2 - y1;
	}
	
}
