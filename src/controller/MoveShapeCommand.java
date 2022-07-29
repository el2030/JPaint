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
		
		MoveShape move = new MoveShape(shape);
		move.run();
		paintCanvas.repaint();
		CommandHistory.add(this);
		
	}
	

	@Override
	public void undo() {
		
		UndoMove undo = new UndoMove(shape);
		undo.run();
		paintCanvas.repaint();
		
	}

	@Override
	public void redo() {
		
		RedoMove redo = new RedoMove(shape);
		redo.run();
		paintCanvas.repaint();
		
		
	}}
