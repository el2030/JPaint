package model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;

import view.gui.PaintCanvas;
import view.interfaces.IShape;

public class GroupShapes implements IShape {
	int startX;
	int startY;
	int endX;
	int endY;
	//private IShape ishape;
	private ArrayList<IShape> groupshapelist = new ArrayList<>();
	ArrayList<IShape> selectlist = StaticShapeList.selectedShapeList.returnShapeList();
	ArrayList<IShape> mainShapeList = StaticShapeList.mainShapeList.returnShapeList();
	
	
	public GroupShapes(){
		groupshapelist = new ArrayList<>();
		//this.shape = shape;
 
    }
	
	public void addShape(IShape shape) {
		groupshapelist.add(shape);
	}
	
	public void removeShape(IShape shape) {
		groupshapelist.remove(shape);
	}
	
	public void group() {
		for (IShape shape: selectlist) {
			this.addShape(shape);
			mainShapeList.remove(shape);
			System.out.println("group added");
			System.out.println(this.shapeCount());
		}
		this.getMinMax();
		
		selectlist.clear();
		selectlist.add(this);
		mainShapeList.add(this);
		this.draw(PaintCanvas.getInstance().getGraphics2D());
	}
	
	public void unGroup() {
		for (IShape shape: groupshapelist) {
			selectlist.remove(this);
			selectlist.add(shape);
			this.removeShape(shape);
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
	
	private void getMinMax() {
		for (IShape groupedshape: groupshapelist) {
			if (this.startX == 0) {
				this.startX = groupedshape.getStartX();
				this.startY = groupedshape.getStartY();
				this.endX = groupedshape.getEndX();
				this.endY = groupedshape.getEndY();			
			}
			
			else {
				this.startX = Math.min(this.startX, groupedshape.getStartX());
				this.startY = Math.min(this.startY, groupedshape.getStartY());
				this.endX = Math.max(this.endX, groupedshape.getEndX());
				this.endY = Math.max(this.endY, groupedshape.getEndY());
				
			}
		}
	}

	
	@Override
	public void draw(Graphics2D graphics2d) {
		for (IShape shape: groupshapelist) {
			shape.draw(graphics2d);
			//System.out.println("group removed");
			//System.out.println(this.shapeCount());
		}
		
//		this.getMinMax();
//		Calculator c = new Calculator(this.startX-5, this.endX+5, this.startY-5 ,this.endY+5);
//	    int width = c.width();
//		int height = c.height();
//    	//graphics2d.setColor(BLACK);
//		
//    	float[] dash = {5.0f, 5.0f, 5.0f};
//        Stroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
//                BasicStroke.JOIN_MITER, 2.0f, dash, 10.0f);
//        graphics2d.setStroke(dashed);
//        graphics2d.drawRect(c.startX(), c.startY(), width, height);
		
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
	public ShapeColor getActiveSecondaryColor() {
		// TODO Auto-generated method stub
		return ShapeColor.WHITE;
	}

	@Override
	public ShapeShadingType getActiveShapeShadingType() {
		// TODO Auto-generated method stub
		return ShapeShadingType.DASHED_LINE;
	}

	@Override
	public ShapeColor getActivePrimaryColor() {
		// TODO Auto-generated method stub
		return ShapeColor.WHITE;
	}

	@Override
	public ShapeType getActiveShapeType() {
		// TODO Auto-generated method stub
		return ShapeType.RECTANGLE;
	}

	@Override
	public void setStartX(int startX) {
		//this.setStartX(startX);
		for (IShape shape: groupshapelist) {
			shape.setStartX(shape.getStartX() + startX - this.startX);
		}
		this.startX = startX;
		
	}

	@Override
	public void setStartY(int startY) {
		for (IShape shape: groupshapelist) {
			shape.setStartY(shape.getStartY() + startY - this.startY);
		}
//		this.setStartY(startY);
		this.startY = startY;
	}

	@Override
	public void setEndX(int endX) {
		for (IShape shape: groupshapelist) {
			shape.setEndX(shape.getEndX() + endX - this.endX);
		}
//		this.setEndX(endX);
		this.endX = endX;
		
	}

	@Override
	public void setEndY(int endY) {
		for (IShape shape: groupshapelist) {
			shape.setEndY(shape.getEndY() + endY - this.endY);
		}
//		this.setEndY(endY);
		this.endY = endY;
	}

	@Override
	public IShape pasteShape() {
		GroupShapes newgroup = new GroupShapes();
		newgroup.setStartX(startX + 30);
		newgroup.setStartY(startY + 30);
		newgroup.setEndX(endX + 30);
		newgroup.setEndY(endY + 30);
		for (IShape groupedshape: groupshapelist) {
			IShape shape = groupedshape.pasteShape();
			newgroup.addShape(shape);
		}
//		for (IShape shape: newgroup.groupshapelist) {
//			shape.setStartX(shape.getStartX() + 30);
//			shape.setStartY(shape.getStartY() + 30);
//			shape.setEndX(shape.getEndX() + 30);
//			shape.setEndY(shape.getEndY() + 30);
//		}
		
		return newgroup;
	}

}
