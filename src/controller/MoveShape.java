package controller;

import java.util.ArrayList;

import model.Calculator;
import model.Shape;
import model.ShapeList;
import model.StaticShapeList;
import view.interfaces.ICommand;
import view.interfaces.IMoveCommand;

public class MoveShape implements ICommand {
	
	ArrayList<Shape> selectedshapes = StaticShapeList.selectedShapeList.returnShapeList();
	private Shape shape;
	
	public MoveShape(Shape shape) {this.shape = shape;}
	
	@Override
	public void execute() {
		Calculator calculate = new Calculator(shape.startX, shape.endX, shape.startY, shape.endY);
		for (Shape selectedshape: selectedshapes) {
			//StaticShapeList.movedShapeList.add(selectedshape);
			selectedshape.startX += calculate.deltaX();
			selectedshape.startY += calculate.deltaY();
			selectedshape.endX += calculate.deltaX();
			selectedshape.endY += calculate.deltaY();
			
			
		}

		
	}

}
