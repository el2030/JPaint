package model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;

import view.gui.PaintCanvas;
import view.interfaces.IShape;

public class GroupShapes implements IShape {

	private ArrayList<IShape> groupshapelist = new ArrayList<>();
	ArrayList<Shape> selectlist = StaticShapeList.selectedShapeList.returnShapeList();
	
	public GroupShapes(){
		groupshapelist = new ArrayList<>();
 
    }
	
	public void addShape(Shape shape) {
		groupshapelist.add(shape);
	}
	
	public void group() {
		for (IShape shape: selectlist) {
			groupshapelist.add(shape);
			System.out.println("group added");
			System.out.println(this.shapeCount());
		}
		
		this.draw(PaintCanvas.getInstance().getGraphics2D());
	}
	
	public void unGroup() {
		for (IShape shape: selectlist) {
			groupshapelist.remove(shape);
			System.out.println("group removed");
			System.out.println(this.shapeCount());
		}
		
		this.draw(PaintCanvas.getInstance().getGraphics2D());
	}
	
	private ArrayList<IShape> returnShapeList() {
		return groupshapelist;
	}
	
	public int shapeCount() {
		int count = 0;
		for (IShape shape: groupshapelist) {
			count++;
		}
		return count;
	}

	
	@Override
	public void draw(Graphics2D graphics2d) {
//		int startX = 10000;
//		int endX = 0;
//		int startY = 10000;
//		int endY = 0;
//		for (IShape shape: groupshapelist) {
//			if (shape.startX < startX) {
//				startX = shape.startX;
//			}
//			if (shape.endX > endX) {
//				endX = shape.endX;
//			}
//			if (shape.startY < startY) {
//				startY = shape.startY;
//			}
//			if (shape.endY > endY) {
//				endY = shape.endY;
//			}
//			
//		}
//		
//		;
//		
//		Calculator c = new Calculator(startX-5, endX+5, startY-5 ,endY+5);
//	    int width = c.width();
//		int height = c.height();
//    	//graphics2d.setColor(BLACK);
//		
//    	float[] dash = {5.0f, 5.0f, 5.0f};
//        Stroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_MITER, 2.0f, dash, 10.0f);
//        graphics2d.setStroke(dashed);
//        graphics2d.drawRect(c.startX(), c.startY(), width, height);
//		
	}

}
