package controller;

import java.util.ArrayList;

import model.Shape;
import model.ShapeBuilder;
import model.StaticShapeList;
import view.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;

public class MoveShapeCommand implements IUndoable{

	private Shape shape;
	private PaintCanvasBase paintCanvas;
	ArrayList<Shape> selectedshapes = StaticShapeList.selectedShapeList.returnShapeList();
	ArrayList<Shape> displaySelected = StaticShapeList.displaySelected.returnShapeList();
	
	
		public MoveShapeCommand(int startX, int startY, int endX, int endY, PaintCanvasBase paintCanvas) {
			
			this.paintCanvas = paintCanvas;
			shape = new ShapeBuilder()
				.setStartX(startX)
				.setStartY(startY)
				.setendX(endX)
				.setendY(endY)
				.makeShape();
	
	}
	
	public void moveShape() {
		
		ShapeMovement.move(selectedshapes, shape);
		ShapeMovement.move(displaySelected, shape);
		paintCanvas.repaint();
		CommandHistory.add(this);
		
	}
	

	@Override
	public void undo() {
		
		ShapeMovement.undoMove(selectedshapes, shape);
		ShapeMovement.undoMove(displaySelected, shape);
		paintCanvas.repaint();
		
	}

	@Override
	public void redo() {
		
		ShapeMovement.move(selectedshapes, shape);
		ShapeMovement.move(displaySelected, shape);
		paintCanvas.repaint();
		
		
	}}
