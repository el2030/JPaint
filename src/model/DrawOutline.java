package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import model.interfaces.IColorStrategy;
import model.persistence.ApplicationState;
import view.interfaces.IDraw;
import view.interfaces.PaintCanvasBase;


import model.interfaces.IColorStrategy;
import view.interfaces.IDraw;

public class DrawOutline implements IDraw {
	private final IDraw draw;
	
	public DrawOutline(IDraw draw) {
		this.draw = draw;
	}
	
	
	@Override
	public void draw(int startX, int startY, int endX, int endY, ShapeShadingType activeShapeShadingType,
			IColorStrategy activePrimaryColor, IColorStrategy activeSecondaryColor, Graphics2D graphics2d) {
		Calculator c = new Calculator(startX, endX, startY ,endY);
	    int width = c.width();
		int height = c.height();
		IColorStrategy color = null; 
      
        switch(activeShapeShadingType) {
        
        case DASHED_LINE:
        	color = activeSecondaryColor;
        	graphics2d.setColor(color.getColor());
        	float[] dash = {5.0f, 5.0f, 5.0f};
            Stroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER, 2.0f, dash, 10.0f);
            graphics2d.setStroke(dashed);
            graphics2d.drawRect(c.startX(), c.startY(), width, height);
		
        }
	}

}
