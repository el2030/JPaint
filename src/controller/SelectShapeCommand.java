package controller;


import java.util.ArrayList;
import model.Collision;
import model.Shape;
import model.ShapeBuilder;
import model.ShapeColor;
import model.ShapeShadingType;
import model.StaticShapeList;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;
import view.interfaces.IShape;




public class SelectShapeCommand implements ICommand {

	ArrayList<IShape> shapelist = StaticShapeList.mainShapeList.returnShapeList();
	ArrayList<IShape> selectlist = StaticShapeList.selectedShapeList.returnShapeList();

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

		
		for (IShape shapeInMain: shapelist) {
        	if (Collision.detected(shapeInMain, shape)) {
        		StaticShapeList.selectedShapeList.add(shapeInMain);
        		displaySelectedShape(shapeInMain);
        	}
		}
		
		if (selectlist.isEmpty()) {

			StaticShapeList.selectedShapeList.clear();
			StaticShapeList.displaySelected.clear();
			PaintCanvas.getInstance().repaint();
		}
          	
        
	}
	
	private void displaySelectedShape(IShape shapeInMain) {
		Shape newshape = new Shape(shapeInMain.getStartX() -5, shapeInMain.getStartY() - 5, shapeInMain.getEndX() + 5, shapeInMain.getEndY() + 5, shapeInMain.getActiveShapeType(), ShapeColor.BLACK, ShapeColor.BLACK, ShapeShadingType.DASHED_LINE);
		StaticShapeList.displaySelected.add(newshape);
		PaintCanvas.getInstance().repaint();
		
	}

	
	
}
