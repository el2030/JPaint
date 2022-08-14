package model;

import java.util.ArrayList;

import view.interfaces.IShape;

public class ShapeList {


	private ArrayList<Shape> shapelist = new ArrayList<>();
	
	
	
	public void add(Shape shape) {
		
		shapelist.add(shape);
		System.out.println("shape added");
		System.out.println(shapeCount());
		
	}
	
	public int shapeCount() {
		int count = 0;
		for (IShape shape: shapelist) {
			count++;
		}
		return count;
	}
	
	public ArrayList<Shape> returnShapeList(){
		
		return shapelist;
	}
	
	public void remove(Shape shape) {
		
		shapelist.remove(shape);
		System.out.println("shape removed");
		System.out.println(shapeCount());
	}
	
	public void clear() {
		shapelist.clear();
	}	
	
	
}
