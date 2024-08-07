package controller;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;
import model.Calculator;
import model.ShapeShadingType;
import model.ShapeType;
import model.interfaces.IColorStrategy;
import view.interfaces.IShape;

public class Selection implements IShape {
	
	private final IShape shape;
	
	public Selection(IShape shape) {
		this.shape = shape;
	}
	
	
	@Override
	public void draw(Graphics2D graphics2d) {
		Calculator c = new Calculator(shape.getStartX(), shape.getEndX(), shape.getStartY() , shape.getEndY());
	    int width = c.width();
		int height = c.height();
		
        float[] dash = {5.0f, 5.0f, 5.0f};
        Stroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
        BasicStroke.JOIN_MITER, 2.0f, dash, 10.0f);
        graphics2d.setStroke(dashed);
        graphics2d.drawRect(c.startX() - 5, c.startY() - 5, width + 10, height + 10);
		
	}


	@Override
	public int getStartX() {
		
		return 0;
	}


	@Override
	public int getEndX() {
		
		return 0;
	}


	@Override
	public int getStartY() {
		
		return 0;
	}


	@Override
	public int getEndY() {
		
		return 0;
	}


	@Override
	public ShapeType getActiveShapeType() {
		return null;
		
	}


	@Override
	public IColorStrategy getActivePrimaryColor() {
		
		return null;
	}


	@Override
	public IColorStrategy getActiveSecondaryColor() {
		
		return null;
	}


	@Override
	public ShapeShadingType getActiveShapeShadingType() {
		
		return null;
	}


	@Override
	public void setStartX(int startX) {
		
		
	}


	@Override
	public void setStartY(int startY) {
		
		
	}


	@Override
	public void setEndX(int endX) {
		
		
	}


	@Override
	public void setEndY(int endY) {
		
		
	}


	@Override
	public IShape pasteShape() {
		
		return null;
	}


	@Override
	public void unGroup() {
		
		
	}

}
