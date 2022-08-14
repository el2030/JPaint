package model;

import java.awt.Graphics2D;

import model.persistence.ApplicationState;
import view.interfaces.IShape;

public class Shape implements IShape {
	
	public int startX;
	public int startY;
	public int endX;
	public int endY;
	public ShapeType activeShapeType;
    public ShapeColor activePrimaryColor;
    public ShapeColor activeSecondaryColor;
    public ShapeShadingType activeShapeShadingType;
    
    public Shape (int startX, int startY, int endX, int endY, ShapeType activeShapeType, ShapeColor activePrimaryColor, ShapeColor activeSecondaryColor, ShapeShadingType activeShapeShadingType) {
    	
    	this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.activeShapeType = activeShapeType;
		this.activePrimaryColor = activePrimaryColor;
		this.activeSecondaryColor = activeSecondaryColor;
		this.activeShapeShadingType = activeShapeShadingType;
    }

	@Override
	public void draw(Graphics2D graphics2d) {
		
		
		switch(activeShapeType.toString()) {
		case "RECTANGLE":
			 new Rectangle().draw(startX, startY, endX, endY, activeShapeShadingType, activePrimaryColor, activeSecondaryColor, graphics2d);
			 break;
		case "TRIANGLE": 
			 new Triangle().draw(startX, startY, endX, endY, activeShapeShadingType, activePrimaryColor, activeSecondaryColor, graphics2d);
			 break;
		case "ELLIPSE" :
			 new Ellipse().draw(startX, startY, endX, endY, activeShapeShadingType, activePrimaryColor, activeSecondaryColor, graphics2d);
			 break;
		default:  break;
		}
		
	}

	@Override
	public int getStartX() {
		// TODO Auto-generated method stub
		return startX;
	}

	@Override
	public int getEndX() {
		// TODO Auto-generated method stub
		return endX;
	}

	@Override
	public int getStartY() {
		// TODO Auto-generated method stub
		return startY;
	}

	@Override
	public int getEndY() {
		// TODO Auto-generated method stub
		return endY;
	}

	@Override
	public ShapeType getActiveShapeType() {
		return activeShapeType;
		
	}

	@Override
	public ShapeColor getActivePrimaryColor() {
		// TODO Auto-generated method stub
		return activePrimaryColor;
	}

	@Override
	public ShapeColor getActiveSecondaryColor() {
		// TODO Auto-generated method stub
		return activeSecondaryColor;
	}

	@Override
	public ShapeShadingType getActiveShapeShadingType() {
		// TODO Auto-generated method stub
		return activeShapeShadingType;
	}

	@Override
	public void setStartX(int startX) {
		// TODO Auto-generated method stub
		this.startX = startX;
	}

	@Override
	public void setStartY(int startY) {
		// TODO Auto-generated method stub
		this.startY = startY;
	}

	@Override
	public void setEndX(int endX) {
		// TODO Auto-generated method stub
		this.endX = endX;
	}

	@Override
	public void setEndY(int endY) {
		// TODO Auto-generated method stub
		this.endY = endY;
	}
	
	
	
	
}
