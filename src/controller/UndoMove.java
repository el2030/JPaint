package controller;

import java.util.ArrayList;

import model.Calculator;
import model.Shape;
import model.StaticShapeList;
import view.interfaces.IMoveCommand;

public class UndoMove implements IMoveCommand {
	
	ArrayList<Shape> selectedshapes = StaticShapeList.selectedShapeList.returnShapeList();
	ArrayList<Shape> movedshapes = StaticShapeList.movedShapeList.returnShapeList();
	private Shape shape;
	
	public UndoMove(Shape shape) {this.shape = shape;}
	
	@Override
	public void run() {
		Calculator calculate = new Calculator(shape.startX, shape.endX, shape.startY, shape.endY);
		for (Shape selectedshape: selectedshapes) {
			//if (movedshapes.contains(selectedshape)) {
				selectedshape.startX -= calculate.deltaX();
				selectedshape.startY -= calculate.deltaY();
				selectedshape.endX -= calculate.deltaX();
				selectedshape.endY -= calculate.deltaY();
			//}
			
		}


		
	}

}
