package controller;


import model.Shape;
import model.ShapeBuilder;
import model.StaticShapeList;
import model.persistence.ApplicationState;
import view.interfaces.ICommand;
import view.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;
public class AddShapeCommand implements IUndoable, ICommand {

	private Shape shape;
	private PaintCanvasBase paintCanvas;
	//private ApplicationState appState;
	
	public AddShapeCommand(int startX, int startY, int endX, int endY, ApplicationState appState, PaintCanvasBase paintCanvas) {
			
			this.paintCanvas = paintCanvas;
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
		paintCanvas.repaint();
		CommandHistory.add(this);
		
	}

	@Override
	public void undo() {
		
		StaticShapeList.mainShapeList.remove(shape);
		paintCanvas.repaint();
		
		
	}

	
	public void redo() {
		
		StaticShapeList.mainShapeList.add(shape);
		paintCanvas.repaint();
		
		
	}

	
}
