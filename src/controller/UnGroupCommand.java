package controller;

import java.util.ArrayList;

import model.GroupShapes;
import model.StaticShapeList;
import view.interfaces.ICommand;
import view.interfaces.IShape;
import view.interfaces.IUndoable;

public class UnGroupCommand implements IUndoable, ICommand {

	ArrayList<IShape> selectlist = StaticShapeList.selectedShapeList.returnShapeList();
	ArrayList<IShape> groupshapelist = StaticShapeList.groupShapeList.returnShapeList();
	

	@Override
	public void execute() {
		StaticShapeList.unGroupShapeList.clear();
		for (IShape groupshape: selectlist) {
			StaticShapeList.unGroupShapeList.add(groupshape);
			groupshape.unGroup();	
		}
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		selectlist.clear();
		for (IShape ungrouped: StaticShapeList.unGroupShapeList.returnShapeList()) {
			selectlist.add(ungrouped);

		}
		new GroupShapes().group();
		
	}

	@Override
	public void redo() {
		StaticShapeList.unGroupShapeList.clear();
		for (IShape groupshape: selectlist) {
			StaticShapeList.unGroupShapeList.add(groupshape);
			groupshape.unGroup();	
		}
		
		
	}
	
	
}
