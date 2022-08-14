package controller;

import java.util.ArrayList;
import model.Shape;
import model.ShapeList;
import model.StaticShapeList;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;

public class PasteCommand implements IUndoable, ICommand {
	
	ArrayList<IShape> copiedshapes = StaticShapeList.clipBoard.returnShapeList();
	ArrayList<IShape> clonelist = StaticShapeList.cloneList.returnShapeList();
	
	@Override
	public void execute() {
	for (IShape copiedshape: copiedshapes) {
			
			IShape shape = new Shape(copiedshape.getStartX() + 30, copiedshape.getStartY() + 30, copiedshape.getEndX() + 30, copiedshape.getEndY() + 30, copiedshape.getActiveShapeType(), copiedshape.getActivePrimaryColor(), copiedshape.getActiveSecondaryColor(), copiedshape.getActiveShapeShadingType());
			StaticShapeList.mainShapeList.add(shape);
			clonelist.add(shape);
			PaintCanvas.getInstance().repaint();
			
		
		}
		CommandHistory.add(this);
		
	}
	

	@Override
	public void undo() {
		
		for (IShape clone: clonelist) {
			
			StaticShapeList.mainShapeList.remove(clone);
		}
		PaintCanvas.getInstance().repaint();
	}

	@Override
	public void redo() {
		
		for (IShape clone: clonelist) {
			
			StaticShapeList.mainShapeList.add(clone);
		}
		PaintCanvas.getInstance().repaint();
		
	}


	
	
}
