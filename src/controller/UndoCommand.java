package controller;

import view.interfaces.ICommand;


public class UndoCommand implements ICommand {

	@Override
	public void execute() {
		
		CommandHistory.undo();
		
	}

}
