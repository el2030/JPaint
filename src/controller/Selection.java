package controller;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.Calculator;
import model.Ellipse;
import model.Rectangle;
import model.Shape;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.Triangle;
import view.gui.PaintCanvas;
import view.interfaces.IShape;

public class Selection implements IShape {
	private final Shape shape;
	//Graphics2D graphics2d = PaintCanvas.getInstance().getGraphics2D();
	
	public Selection(Shape shape) {
		this.shape = shape;
	}
	
	
	@Override
	public void draw(Graphics2D graphics2d) {
		Calculator c = new Calculator(shape.startX, shape.endX, shape.startY , shape.endY);
	    int width = c.width();
		int height = c.height();
		
		switch(shape.activeShapeType.toString()) {
		case "RECTANGLE":
        	float[] dash = {5.0f, 5.0f, 5.0f};
            Stroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER, 2.0f, dash, 10.0f);
            graphics2d.setStroke(dashed);
            graphics2d.drawRect(c.startX() - 5, c.startY() - 5, width + 10, height + 10);
			 break;
//		case "TRIANGLE": 
//			 new Triangle().draw(startX, startY, endX, endY, activeShapeShadingType, activePrimaryColor, activeSecondaryColor, graphics2d);
//			 break;
//		case "ELLIPSE" :
//			 new Ellipse().draw(startX, startY, endX, endY, activeShapeShadingType, activePrimaryColor, activeSecondaryColor, graphics2d);
//			 break;
		default:  break;
		}
		
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
	public ShapeType getActiveShapeType() {
		return null;
		// TODO Auto-generated method stub
		
	}


	@Override
	public ShapeColor getActivePrimaryColor() {
		// TODO Auto-generated method stub
		return null;
	}


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

}
