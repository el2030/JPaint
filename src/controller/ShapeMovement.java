package controller;

import java.util.ArrayList;

import model.Calculator;
import model.Shape;
import model.ShapeList;
import view.interfaces.IShape;

public class ShapeMovement {
	
	public static void move(ArrayList<IShape> selectedshapes, Shape shape) {
		
		Calculator calculate = new Calculator(shape.startX, shape.endX, shape.startY, shape.endY);
		for (IShape selectedshape: selectedshapes) {
			selectedshape.setStartX(selectedshape.getStartX() + calculate.deltaX());
			selectedshape.setStartY(selectedshape.getStartY() + calculate.deltaY());
			selectedshape.setEndX(selectedshape.getEndX() + calculate.deltaX());
			selectedshape.setEndY(selectedshape.getEndY() + calculate.deltaY());

		}
	}
	
	public static void undoMove(ArrayList<IShape> selectedshapes, IShape shape) {
		
		Calculator calculate = new Calculator(shape.startX, shape.endX, shape.startY, shape.endY);
		for (IShape selectedshape: selectedshapes) {
			selectedshape.setStartX(selectedshape.getStartX() - calculate.deltaX());
			selectedshape.setStartY(selectedshape.getStartY() - calculate.deltaY());
			selectedshape.setEndX(selectedshape.getEndX() - calculate.deltaX());
			selectedshape.setEndY(selectedshape.getEndY() - calculate.deltaY());
		}
	}


}
