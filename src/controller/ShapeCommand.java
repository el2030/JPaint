package controller;

import model.Point;
import model.ShapeFactory;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;


public class ShapeCommand {
	
	private Point pressed;
	private Point released;
	ApplicationState appState;
	PaintCanvasBase paintCanvas;
	int startX;
	int startY;
	int width;
	int height;

	public ShapeCommand(Point pressed, Point released, ApplicationState appState, PaintCanvasBase paintCanvas) {
		this.pressed = pressed;
		this.released = released;
		this.appState = appState;
		this.paintCanvas = paintCanvas;
		
	}
	
	public void createShapeCommand() {
		
		AddShapeCommand shape = new AddShapeCommand(pressed.getX(), pressed.getY(), released.getX(), released.getY(), appState, paintCanvas);
		shape.execute();

		
	}
	
	public void SelectShapeCommand() {
		

		SelectShapeCommand shape = new SelectShapeCommand(pressed.getX(), pressed.getY(), released.getX(), released.getY());
		shape.selectShape();

		
	}
	
	public void moveCommand() {
		
		MoveShapeCommand shape = new MoveShapeCommand(pressed.getX(), pressed.getY(), released.getX(), released.getY(), paintCanvas);
		shape.moveShape();
		
	}
	
	public static void paste() {
		
		
	}

}
