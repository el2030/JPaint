package model;

import java.awt.Graphics2D;

import model.interfaces.IColorStrategy;
import view.interfaces.IShape;


public class Shape implements IShape {
	
	public int startX;
	public int startY;
	public int endX;
	public int endY;
	public ShapeType activeShapeType;
    public IColorStrategy activePrimaryColor;
    public IColorStrategy activeSecondaryColor;
    public ShapeShadingType activeShapeShadingType;

    
    
    public Shape (int startX, int startY, int endX, int endY, ShapeType activeShapeType, IColorStrategy activePrimaryColor, IColorStrategy activeSecondaryColor, ShapeShadingType activeShapeShadingType) {
    	
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
		
		if (activeShapeType == null || activeShapeShadingType == null) {
			new NullShapeBehaviors().doNothing();
		}
		
		else {
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
		
	}

	@Override
	public int getStartX() {
		
		return startX;
	}

	@Override
	public int getEndX() {
	
		return endX;
	}

	@Override
	public int getStartY() {

		return startY;
	}

	@Override
	public int getEndY() {
		
		return endY;
	}

	@Override
	public ShapeType getActiveShapeType() {
		
		return activeShapeType;
		
	}

	@Override
	public IColorStrategy getActivePrimaryColor() {
		
		return activePrimaryColor;
	}

	@Override
	public IColorStrategy getActiveSecondaryColor() {
		
		return activeSecondaryColor;
	}

	@Override
	public ShapeShadingType getActiveShapeShadingType() {

		
		return activeShapeShadingType;
	}

	@Override
	public void setStartX(int startX) {
		
		this.startX = startX;
	}

	@Override
	public void setStartY(int startY) {
		
		this.startY = startY;
	}

	@Override
	public void setEndX(int endX) {
		
		this.endX = endX;
	}

	@Override
	public void setEndY(int endY) {
		
		this.endY = endY;
	}

	@Override
	public IShape pasteShape() {
		IShape shape = new Shape(this.getStartX() + 30, this.getStartY() + 30, this.getEndX() + 30, this.getEndY() + 30, this.getActiveShapeType(), this.getActivePrimaryColor(), this.getActiveSecondaryColor(), this.getActiveShapeShadingType());
		return shape;
	}

	@Override
	public void unGroup() {

		System.out.println("Nothing to ungroup");
	}

	
	
	
	
}
