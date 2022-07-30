package controller;

import java.util.ArrayList;

import model.Collision;
import model.DrawHelper;
import model.Shape;
import model.ShapeBuilder;
import model.ShapeColor;
import model.ShapeShadingType;
import model.StaticShapeList;
import view.interfaces.PaintCanvasBase;


public class SelectShapeCommand {

	ArrayList<Shape> shapelist = StaticShapeList.mainShapeList.returnShapeList();
	private Shape shape;
	
	public SelectShapeCommand(int startX, int startY, int endX, int endY) {
			
		shape = new ShapeBuilder()
				.setStartX(startX)
				.setStartY(startY)
				.setendX(endX)
				.setendY(endY)
				.makeShape();
	
	}
	
	public void selectShape() {
		
		StaticShapeList.selectedShapeList.clear();
		StaticShapeList.displaySelected.clear();
		
		for (Shape shapeInMain: shapelist) {
        	if (Collision.detected(shapeInMain, shape)) {
        		StaticShapeList.selectedShapeList.add(shapeInMain);
        		displaySelectedShape(shapeInMain);
        		System.out.println("Selected");
        	}
        	
        	//else {StaticShapeList.displaySelected.clear();}

        	//ArrayList<Shape> selectedshapes = StaticShapeList.selectedShapeList.returnShapeList();
  
    		//System.out.println("selectedshapes size " + selectedshapes.size());

        	
        	
        	
        }
	}
	
	private void displaySelectedShape(Shape shape) {
		Shape newshape = new Shape(shape.startX -5, shape.startY - 5, shape.endX + 5, shape.endY + 5, shape.activeShapeType, ShapeColor.BLACK, ShapeColor.BLACK, ShapeShadingType.DASHED_LINE);
		StaticShapeList.displaySelected.add(newshape);
		DrawHelper.returnPaint().repaint();
		
	}

	
	
}
