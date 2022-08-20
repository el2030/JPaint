package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Point;
import model.persistence.ApplicationState;
import view.interfaces.ICommand;
import view.interfaces.PaintCanvasBase;



public class Mouse extends MouseAdapter {
	 
	private Point pPressed;
	private Point pReleased;
	private ApplicationState appState;
	PaintCanvasBase paintCanvas;

	public Mouse(PaintCanvasBase paintCanvas, ApplicationState appState) { //constructor
		this.appState = appState;
		this.paintCanvas = paintCanvas;

	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		pPressed = new Point(0, 0);
		pPressed.setX(e.getX());	
		pPressed.setY(e.getY());
	
	}
	
	@Override
    public void mouseReleased(MouseEvent e) {
		
		pReleased =  new Point(0, 0);
		pReleased.setX(e.getX());
		pReleased.setY(e.getY());
		ICommand command;
		
		switch(appState.getActiveMouseMode().toString()) {

		case "MOVE":

			command = new MoveShapeCommand(pPressed.getX(), pPressed.getY(), pReleased.getX(), pReleased.getY());
			command.execute();
			break;
		
		case "SELECT": 

			command = new SelectShapeCommand(pPressed.getX(), pPressed.getY(), pReleased.getX(), pReleased.getY());
			command.execute();
			break;
			
		case "DRAW":

			command = new AddShapeCommand(pPressed.getX(), pPressed.getY(), pReleased.getX(), pReleased.getY(), appState);
			command.execute();
			break;
			
		default: break;
		}

	}
	
		
	
	


}
