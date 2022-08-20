package view.interfaces;

import java.awt.Graphics2D;
import model.ShapeShadingType;
import model.interfaces.IColorStrategy;

public interface IDraw {

	void draw(int startX, int startY, int endX, int endY, ShapeShadingType activeShapeShadingType,
			IColorStrategy activePrimaryColor, IColorStrategy activeSecondaryColor, Graphics2D graphics2d);
	
}
