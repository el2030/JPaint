package controller;

import java.util.ArrayList;
import model.DrawHelper;

import model.Shape;
import model.ShapeList;
import model.StaticShapeList;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

public class PasteCommand implements IUndoable, ICommand {
	
	ArrayList<Shape> copiedshapes = StaticShapeList.clipBoard.returnShapeList();
	ArrayList<Shape> clonelist = StaticShapeList.cloneList.returnShapeList();
	
	@Override
	public void execute() {
	for (Shape copiedshape: copiedshapes) {
			
			Shape shape = new Shape(copiedshape.startX + 30, copiedshape.startY + 30, copiedshape.endX + 30, copiedshape.endY + 30, copiedshape.activeShapeType, copiedshape.activePrimaryColor, copiedshape.activeSecondaryColor, copiedshape.activeShapeShadingType);
			StaticShapeList.mainShapeList.add(shape);
			clonelist.add(shape);
			DrawHelper.returnPaint().repaint();
			
		
		}
		CommandHistory.add(this);
		
	}
	

	@Override
	public void undo() {
		
		for (Shape clone: clonelist) {
			
			StaticShapeList.mainShapeList.remove(clone);
		}
		DrawHelper.returnPaint().repaint();
	}

	@Override
	public void redo() {
		
		for (Shape clone: clonelist) {
			
			StaticShapeList.mainShapeList.add(clone);
		}
		DrawHelper.returnPaint().repaint();
		
	}


	
	
}
