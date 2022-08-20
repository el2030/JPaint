package model;

import java.awt.Graphics2D;

import view.interfaces.IShape;

public class NullShapeBehaviors implements IShape {
	
	
	public void doNothing() {};
	
	@Override
	public ShapeColor getActiveSecondaryColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShapeShadingType getActiveShapeShadingType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShapeColor getActivePrimaryColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShapeType getActiveShapeType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unGroup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D graphics2d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getStartX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEndX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStartY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEndY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setStartX(int startX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStartY(int startY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEndX(int endX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEndY(int endY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IShape pasteShape() {
		// TODO Auto-generated method stub
		return null;
	}

}
