package controller;


import model.Shape;
import model.ShapeBuilder;
import model.StaticShapeList;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;
public class AddShapeCommand implements IUndoable, ICommand {

	private Shape shape;

	public AddShapeCommand(int startX, int startY, int endX, int endY, ApplicationState appState) {
			

			shape = new ShapeBuilder()
				.setStartX(startX)
				.setStartY(startY)
				.setendX(endX)
				.setendY(endY)
				.setActiveShapeType(appState.getActiveShapeType())
				.setActivePrimaryColor(appState.getActivePrimaryColor())
				.setActiveSecondaryColor(appState.getActiveSecondaryColor())
				.setActiveShapeShadingType(appState.getActiveShapeShadingType())
				.makeShape();
	
	}
	

	@Override
	public void execute() {
		
		StaticShapeList.mainShapeList.add(shape);
		PaintCanvas.getInstance().repaint();
		CommandHistory.add(this);
		
	}

	@Override
	public void undo() {
		
		StaticShapeList.mainShapeList.remove(shape);
		PaintCanvas.getInstance().repaint();
		
		
	}

	
	public void redo() {
		
		StaticShapeList.mainShapeList.add(shape);
		PaintCanvas.getInstance().repaint();
		
		
	}

	
}
