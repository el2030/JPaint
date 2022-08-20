package controller;

import model.Point;
import model.persistence.ApplicationState;
import view.interfaces.ICommand;


public class ShapeCommand {
	
	private Point pressed;
	private Point released;
	ApplicationState appState;
	int startX;
	int startY;
	int width;
	int height;

	public ShapeCommand(Point pressed, Point released, ApplicationState appState) {
		this.pressed = pressed;
		this.released = released;
		this.appState = appState;
		
	}
	
	public void createShapeCommand() {
		
		ICommand command = new AddShapeCommand(pressed.getX(), pressed.getY(), released.getX(), released.getY(), appState);
		command.execute();

		
	}
	
	public void SelectShapeCommand() {
		

		ICommand command = new SelectShapeCommand(pressed.getX(), pressed.getY(), released.getX(), released.getY());
		command.execute();

		
	}
	
	public void moveCommand() {
		
		ICommand command = new MoveShapeCommand(pressed.getX(), pressed.getY(), released.getX(), released.getY());
		command.execute();
		
	}
	
	public static void paste() {
		
		
	}

}
