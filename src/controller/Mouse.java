package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import model.ShapeList;
import model.StaticShapeList;
import model.Collision;
import model.Point;
import model.Shape;
import model.Calculator;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;
import model.Collision;


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
		
		ShapeCommand newShapeCmd = new ShapeCommand(pPressed, pReleased, appState);
		
		switch(appState.getActiveMouseMode().toString()) {

		case "MOVE":
			newShapeCmd.moveCommand(); 
			break;
		
		case "SELECT": 
			newShapeCmd.SelectShapeCommand(); 
			break;
			
		case "DRAW":
			newShapeCmd.createShapeCommand(); 
			break;
			
		default: break;
		}

	}
	
		
	
	


}
