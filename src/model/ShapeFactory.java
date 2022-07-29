package model;

import model.persistence.ApplicationState;
import model.Collision;
import view.interfaces.IUndoable;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

import controller.CommandHistory;

	public class ShapeFactory {
	
		public Shape shape;
		private PaintCanvasBase paintCanvas;
		
		public ShapeFactory(int startX, int startY, int endX, int endY, ApplicationState appState, PaintCanvasBase paintCanvas) {
				
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
		
	
}
