package controller;

import java.awt.Canvas;
import java.util.ArrayList;
import java.util.List;

import model.Collision;
import model.Shape;
import model.ShapeBuilder;
import model.ShapeColor;
import model.ShapeShadingType;
import model.StaticShapeList;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;
import view.interfaces.IObserver;
import view.interfaces.ISubject;



public class SelectShapeCommand implements ISubject, ICommand {

	ArrayList<Shape> shapelist = StaticShapeList.mainShapeList.returnShapeList();
	ArrayList<Shape> selectlist = StaticShapeList.selectedShapeList.returnShapeList();
	private final List<IObserver> observer = new ArrayList<>();
	private Shape shape;
	
	public SelectShapeCommand(int startX, int startY, int endX, int endY) {
			
		shape = new ShapeBuilder()
				.setStartX(startX)
				.setStartY(startY)
				.setendX(endX)
				.setendY(endY)
				.makeShape();
	
	}
	
	public void execute() {
		
		StaticShapeList.selectedShapeList.clear();
		StaticShapeList.displaySelected.clear();
		//PaintCanvas.getInstance().clear();
		//PaintCanvas.getInstance().repaint();
		
		for (Shape shapeInMain: shapelist) {
        	if (Collision.detected(shapeInMain, shape)) {
        		StaticShapeList.selectedShapeList.add(shapeInMain);
        		displaySelectedShape(shapeInMain);
        		//Selection select = new Selection(shapeInMain);
        		//select.draw(PaintCanvas.getInstance().getGraphics2D());
        		System.out.println("Selected");
        	}
		}
		
		if (selectlist.isEmpty()) {
//			PaintCanvas.getInstance().clear();
//			PaintCanvas.getInstance().repaint();
			StaticShapeList.selectedShapeList.clear();
			StaticShapeList.displaySelected.clear();
			PaintCanvas.getInstance().repaint();
		}
        
        	
        	
        	
        	//else {StaticShapeList.displaySelected.clear();}

        	//ArrayList<Shape> selectedshapes = StaticShapeList.selectedShapeList.returnShapeList();
  
    		//System.out.println("selectedshapes size " + selectedshapes.size());

        	
        	
        	
        
	}
	
	private void displaySelectedShape(Shape shape) {
		Shape newshape = new Shape(shape.startX -5, shape.startY - 5, shape.endX + 5, shape.endY + 5, shape.activeShapeType, ShapeColor.BLACK, ShapeColor.BLACK, ShapeShadingType.DASHED_LINE);
		StaticShapeList.displaySelected.add(newshape);
		PaintCanvas.getInstance().repaint();
		
	}

	@Override
	public void registerObserver(IObserver o) {
		observer.add(o);
		
	}

	
	
}
