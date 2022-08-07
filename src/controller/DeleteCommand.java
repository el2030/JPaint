package controller;

import java.util.ArrayList;
import model.Shape;
import model.ShapeList;
import model.StaticShapeList;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

public class DeleteCommand implements ICommand, IUndoable {
	
	ArrayList<Shape> selectedshapes = StaticShapeList.selectedShapeList.returnShapeList();
	ShapeList shapelist;
	
	@Override
	public void execute() {
		shapelist = new ShapeList();
		for (Shape shape: selectedshapes) {
			shapelist.add(shape);
			StaticShapeList.mainShapeList.remove(shape);
			
		}
		selectedshapes.clear();
		PaintCanvas.getInstance().repaint();
		CommandHistory.add(this);
		
	}

	@Override
	public void undo() {
		
		for (Shape shape: shapelist.returnShapeList()) {
			StaticShapeList.mainShapeList.add(shape);
			selectedshapes.add(shape);
			//StaticShapeList.selectedShapeList.add(shape);
		}
		PaintCanvas.getInstance().repaint();
	}

	@Override
	public void redo() {
		
		for (Shape shape: shapelist.returnShapeList()) {
			StaticShapeList.mainShapeList.remove(shape);
			//StaticShapeList.selectedShapeList.remove(shape);
		}
		selectedshapes.clear();
		PaintCanvas.getInstance().repaint();
		
	}

}
