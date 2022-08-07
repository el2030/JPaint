package model;

import view.interfaces.IObserver;
import view.interfaces.ISubject;

public class StaticShapeList{

	public static ShapeList mainShapeList = new ShapeList();
	
	public static ShapeList selectedShapeList = new ShapeList();
	
	public static ShapeList movedShapeList = new ShapeList();
	
	public static ShapeList clipBoard = new ShapeList();
	
	public static ShapeList cloneList = new ShapeList();
	
	public static ShapeList displaySelected = new ShapeList();

	
	
//	public static ShapeList oldList = new ShapeList();
	
//	public void remove(Shape shape) {
//		staticShapeList.remove(shape);
//	}
	
//	public boolean Contain (Shape shape) {
//		if (staticShapeList.Contain(shape)) {
//			return true;
//		}
//		return false;
//	}
}
