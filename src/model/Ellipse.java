package model;

import model.interfaces.IColorStrategy;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
public class Ellipse {

	
	
	public void draw(int startX, int startY, int endX, int endY, ShapeShadingType activeShapeShadingType, IColorStrategy activePrimaryColor, IColorStrategy activeSecondaryColor, Graphics2D graphics2d) {
		
		Calculator c = new Calculator(startX, endX, startY ,endY);
	    int width = c.width();
		int height = c.height();
		
        switch(activeShapeShadingType) {
    
       
        case FILLED_IN:   	
     
        	graphics2d.setColor(activePrimaryColor.getColor());
        	graphics2d.fillOval(c.startX(), c.startY(), width, height);
        	break;
        	
        case OUTLINE:
        	
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(activeSecondaryColor.getColor());
            graphics2d.drawOval(c.startX(), c.startY(), width, height);
        	break;
        	
        case OUTLINE_AND_FILLED_IN:
     
        	graphics2d.setColor(activePrimaryColor.getColor());
            graphics2d.fillOval(c.startX(), c.startY(), width, height);
        	graphics2d.setStroke(new BasicStroke(5));       
            graphics2d.setColor(activeSecondaryColor.getColor());
            graphics2d.drawOval(c.startX(), c.startY(), width, height);
        	break;
        	
        case DASHED_LINE:
    
        	graphics2d.setColor(activeSecondaryColor.getColor());
        	float[] dash = {5.0f, 5.0f, 5.0f};
            Stroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_MITER, 2.0f, dash, 10.0f);
            graphics2d.setStroke(dashed);
            graphics2d.drawOval(c.startX(), c.startY(), width, height);
        	
        default:
        	break;
        }
      

		
	}


}
