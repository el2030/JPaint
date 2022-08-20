package model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;

import controller.DeleteCommand;
import view.gui.PaintCanvas;
import view.interfaces.IShape;

public class GroupShapes implements IShape {
	int startX;
	int startY;
	int endX;
	int endY;

	private ArrayList<IShape> groupshapelist = new ArrayList<>();
	ArrayList<IShape> selectlist = StaticShapeList.selectedShapeList.returnShapeList();
	ArrayList<IShape> mainShapeList = StaticShapeList.mainShapeList.returnShapeList();
	
	
	public GroupShapes(){
		groupshapelist = new ArrayList<>();
 
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
		}
		this.getMinMax();
		
		//selectlist.clear();
		//selectlist.add(this);
		mainShapeList.add(this);
		StaticShapeList.groupShapeList.add(this);
		//this.draw(PaintCanvas.getInstance().getGraphics2D());
		PaintCanvas.getInstance().repaint();
	}
	
	@Override
	public void unGroup() {
		//selectlist.clear();
		
		for (IShape shape: groupshapelist) {
			//shape.unGroup();
			mainShapeList.add(shape);
			//selectlist.add(shape);
		}
		mainShapeList.remove(this);	
		//StaticShapeList.groupShapeList.remove(this);
		PaintCanvas.getInstance().repaint();
		//this.draw(PaintCanvas.getInstance().getGraphics2D());
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
	public ShapeColor getActiveSecondaryColor() {

		return ShapeColor.WHITE;
	
	}

	@Override
	public ShapeShadingType getActiveShapeShadingType() {
		
		return ShapeShadingType.DASHED_LINE;
	}

	@Override
	public ShapeColor getActivePrimaryColor() {
		

		return null;
	}

	@Override
	public ShapeType getActiveShapeType() {

		return ShapeType.RECTANGLE;
	
	}

	@Override
	public void setStartX(int startX) {

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

		this.startY = startY;
	}

	@Override
	public void setEndX(int endX) {
		for (IShape shape: groupshapelist) {
			shape.setEndX(shape.getEndX() + endX - this.endX);
		}

		this.endX = endX;
		
	}

	@Override
	public void setEndY(int endY) {
		for (IShape shape: groupshapelist) {
			shape.setEndY(shape.getEndY() + endY - this.endY);
		}

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

		StaticShapeList.groupShapeList.add(newgroup);
		return newgroup;
	}

}
