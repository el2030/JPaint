package controller;

import java.util.ArrayList;

import model.Shape;
import model.ShapeBuilder;
import model.StaticShapeList;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;

public class MoveShapeCommand implements IUndoable, ICommand{

	private Shape shape;
	ArrayList<IShape> selectedshapes = StaticShapeList.selectedShapeList.returnShapeList();
	ArrayList<IShape> displaySelected = StaticShapeList.displaySelected.returnShapeList();
	
	
		public MoveShapeCommand(int startX, int startY, int endX, int endY) {
			
		
			shape = new ShapeBuilder()
				.setStartX(startX)
				.setStartY(startY)
				.setendX(endX)
				.setendY(endY)
				.makeShape();
	
	}
	
	public void execute() {
		
		ShapeMovement.move(selectedshapes, shape);
		ShapeMovement.move(displaySelected, shape);
		PaintCanvas.getInstance().repaint();
		CommandHistory.add(this);
		
	}
	

	@Override
	public void undo() {
		
		ShapeMovement.undoMove(selectedshapes, shape);
		ShapeMovement.undoMove(displaySelected, shape);
		PaintCanvas.getInstance().repaint();
		
	}

	@Override
	public void redo() {
		
		ShapeMovement.move(selectedshapes, shape);
		ShapeMovement.move(displaySelected, shape);
		PaintCanvas.getInstance().repaint();
		
		
	}}
