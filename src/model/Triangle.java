package model;

import model.interfaces.IColorStrategy;
import model.persistence.ApplicationState;
import view.interfaces.IDraw;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
public class Triangle implements IDraw {

	
	@Override
	public void draw(int startX, int startY, int endX, int endY, ShapeShadingType activeShapeShadingType, IColorStrategy activePrimaryColor, IColorStrategy activeSecondaryColor, Graphics2D graphics2d) {
	
		Calculator c = new Calculator(startX, endX, startY ,endY);
	    int width = c.width();
		
		Polygon polygon = new Polygon();
		polygon.addPoint(c.endX() - width * 2 , c.endY());
		polygon.addPoint(c.endX(), c.endY());
		polygon.addPoint(c.startX(), c.startY());
		
		IColorStrategy color = null; 
		
        switch(activeShapeShadingType) { 
        
   
        case FILLED_IN:   	
        	color = activePrimaryColor;
        	graphics2d.setColor(color.getColor());
        	graphics2d.fillPolygon(polygon);
        	System.out.println(polygon.getBounds());
        	polygon.reset();
        	
        	break;
        	
        case OUTLINE:
        	color = activeSecondaryColor;
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(color.getColor());
            graphics2d.drawPolygon(polygon);
        	break;
        	
        case OUTLINE_AND_FILLED_IN:
        	color = activePrimaryColor;
        	graphics2d.setColor(color.getColor());
        	graphics2d.fillPolygon(polygon);
        	graphics2d.setStroke(new BasicStroke(5));
        	color = activeSecondaryColor;
            graphics2d.setColor(color.getColor());
            graphics2d.drawPolygon(polygon);
        	break;
        
        case DASHED_LINE:
        	color = activeSecondaryColor;
        	graphics2d.setColor(color.getColor());
        	float[] dash = {5.0f, 5.0f, 5.0f};
            Stroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER, 2.0f, dash, 10.0f);
            graphics2d.setStroke(dashed);
            graphics2d.drawPolygon(polygon);
            break;
        	
        default:
        	break;
        }
      

		
	}


}
