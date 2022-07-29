package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import model.DrawHelper;
import model.ShapeList;
import model.StaticShapeList;
import model.Collision;
import model.DrawHelper;
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
	private int height;
	private int width;
	private ShapeList shapeList = new ShapeList();

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
		
		DrawHelper.helper(paintCanvas);
		ShapeCommand newShapeCmd = new ShapeCommand(pPressed, pReleased, appState, DrawHelper.returnPaint());
		
		switch(appState.getActiveMouseMode().toString()) {

		case "MOVE":
			newShapeCmd.moveCommand(); //this code won't be here, this is a part of the pattern that I am working on
			break;
		
		case "SELECT": 
			newShapeCmd.SelectShapeCommand(); //currently moving, will be the command interface, ex. command = command.selected()
			break;
			
		case "DRAW":
			newShapeCmd.createShapeCommand(); //same
			break;
			
		default: break;
		}
	//command.execute();
	}
	
		
	
	


}
