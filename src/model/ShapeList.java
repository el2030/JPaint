package model;

import java.util.ArrayList;
import view.interfaces.IShape;

public class ShapeList {


	private ArrayList<IShape> shapelist = new ArrayList<>();
	
	
	
	public void add(IShape shape) {
		
		shapelist.add(shape);
		
	}
	
	public int shapeCount() {
		int count = 0;
		for (IShape shape: shapelist) {
			count++;
		}
		return count;
	}
	
	public ArrayList<IShape> returnShapeList(){
		
		return shapelist;
	}
	
	public void remove(IShape shape) {
		
		shapelist.remove(shape);
	}
	
	public void clear() {
		shapelist.clear();
	}	
	
	
}
