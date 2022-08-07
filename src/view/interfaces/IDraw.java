package view.interfaces;

import java.awt.Graphics2D;

import model.ShapeColor;
import model.ShapeShadingType;

public interface IDraw {

	void draw(int startX, int startY, int endX, int endY, ShapeShadingType activeShapeShadingType,
			ShapeColor activePrimaryColor, ShapeColor activeSecondaryColor, Graphics2D graphics2d);
	
}
