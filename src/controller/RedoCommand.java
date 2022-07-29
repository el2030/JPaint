package controller;

import view.interfaces.ICommand;

public class RedoCommand implements ICommand {

	@Override
	public void execute() {
		
		CommandHistory.redo();
		System.out.println("redo complete");
		
	}

}
