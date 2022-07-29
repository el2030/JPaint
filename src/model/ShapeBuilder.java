package model;

import model.interfaces.IBuilder;
import model.persistence.ApplicationState;
import view.gui.PaintCanvas;
import view.interfaces.PaintCanvasBase;

public class ShapeBuilder implements IBuilder {

	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    //private MouseMode activeMouseMode;
	ApplicationState appState;
	PaintCanvasBase paintCanvas;
	
	public ShapeBuilder setStartX (int startX) {
		this.startX = startX;
		return this;
	}
	
	public ShapeBuilder setStartY (int startY) {
		this.startY = startY;
		return this;
	}
	
	public ShapeBuilder setendX(int endX) {
		this.endX = endX;
		return this;
	}
	
	public ShapeBuilder setendY (int endY) {
		this.endY = endY;
		return this;
	}
	
	public ShapeBuilder setActiveShapeType (ShapeType activeShapeType) {
		this.activeShapeType = activeShapeType;
		return this;
	}
	
	public ShapeBuilder setActivePrimaryColor (ShapeColor activePrimaryColor) {
		this.activePrimaryColor = activePrimaryColor;
		return this;
	}
	
	public ShapeBuilder setActiveSecondaryColor (ShapeColor activeSecondaryColor) {
		this.activeSecondaryColor = activeSecondaryColor;
		return this;
	}
	
	public ShapeBuilder setActiveShapeShadingType (ShapeShadingType activeShapeShadingType) {
		this.activeShapeShadingType = activeShapeShadingType;
		return this;
	}
	
	public Shape makeShape() {
		return new Shape(startX, startY, endX, endY, activeShapeType, activePrimaryColor, activeSecondaryColor, activeShapeShadingType);
	}
	
	
}
