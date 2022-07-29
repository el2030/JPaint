package model.interfaces;

import model.Shape;
import model.ShapeBuilder;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface IBuilder {
	ShapeBuilder setStartX (int startX);
	
	ShapeBuilder setStartY (int startY);
	
	ShapeBuilder setendX(int endX);
	
	ShapeBuilder setendY (int endY);
	
	ShapeBuilder setActiveShapeType (ShapeType activeShapeType);
	
	ShapeBuilder setActivePrimaryColor (ShapeColor activePrimaryColor);
	
	ShapeBuilder setActiveSecondaryColor (ShapeColor activeSecondaryColor);
	
    ShapeBuilder setActiveShapeShadingType (ShapeShadingType activeShapeShadingType);
	Shape makeShape();
}
