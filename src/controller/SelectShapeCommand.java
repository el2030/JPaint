package controller;

import java.util.ArrayList;

import model.Collision;
import model.Shape;
import model.ShapeBuilder;
import model.StaticShapeList;


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
		
		
		for (Shape shapeInMain: shapelist) {
        	if (Collision.detected(shapeInMain, shape)) {
        		StaticShapeList.selectedShapeList.add(shapeInMain);
        		System.out.println("Selected");
        	}

        	ArrayList<Shape> selectedshapes = StaticShapeList.selectedShapeList.returnShapeList();
  
    		System.out.println("selectedshapes size " + selectedshapes.size());

        	
        	
        	
        }
	}

	
	
}
