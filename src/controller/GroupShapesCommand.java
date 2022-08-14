package controller;

import java.awt.Graphics2D;
import java.util.ArrayList;

import model.GroupShapes;
import model.Shape;
import model.StaticShapeList;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;

public class GroupShapesCommand implements IUndoable, ICommand {
	
	@Override
	public void execute() {
		new GroupShapes().group();
		CommandHistory.add(this);
		
	}


	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
