package view.interfaces;

import java.awt.Graphics2D;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;

public interface IShape {

	int startX = 0;
	int startY = 0;
	int endX = 0;
	int endY = 0;
	ShapeColor getActiveSecondaryColor();
	ShapeShadingType getActiveShapeShadingType();
	ShapeColor getActivePrimaryColor();
	ShapeType getActiveShapeType();
	void draw(Graphics2D graphics2d);
	
	int getStartX();
	int getEndX();
	int getStartY();
	int getEndY();
	
	void setStartX(int startX);
	void setStartY(int startY);
	void setEndX(int endX);
	void setEndY(int endY);
	
	IShape pasteShape();
	
	
}
