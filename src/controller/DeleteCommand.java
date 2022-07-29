package controller;

import java.util.ArrayList;

import model.DrawHelper;
import model.Shape;
import model.ShapeList;
import model.StaticShapeList;
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
		DrawHelper.returnPaint().repaint();
		CommandHistory.add(this);
		
	}

	@Override
	public void undo() {
		
		for (Shape shape: shapelist.returnShapeList()) {
			StaticShapeList.mainShapeList.add(shape);
		}
		DrawHelper.returnPaint().repaint();
	}

	@Override
	public void redo() {
		
		for (Shape shape: shapelist.returnShapeList()) {
			StaticShapeList.mainShapeList.remove(shape);
		}
		DrawHelper.returnPaint().repaint();
		
	}

}
