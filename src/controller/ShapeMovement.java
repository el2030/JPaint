package controller;

import java.util.ArrayList;

import model.Calculator;
import model.Shape;
import model.ShapeList;

public class ShapeMovement {
	
	public static void move(ArrayList<Shape> shapelist, Shape shape) {
		
		Calculator calculate = new Calculator(shape.startX, shape.endX, shape.startY, shape.endY);
		for (Shape selectedshape: shapelist) {
			selectedshape.startX += calculate.deltaX();
			selectedshape.startY += calculate.deltaY();
			selectedshape.endX += calculate.deltaX();
			selectedshape.endY += calculate.deltaY();

		}
	}
	
	public static void undoMove(ArrayList<Shape> shapelist, Shape shape) {
		
		Calculator calculate = new Calculator(shape.startX, shape.endX, shape.startY, shape.endY);
		for (Shape selectedshape: shapelist) {
			selectedshape.startX -= calculate.deltaX();
			selectedshape.startY -= calculate.deltaY();
			selectedshape.endX -= calculate.deltaX();
			selectedshape.endY -= calculate.deltaY();

		}
	}


}
