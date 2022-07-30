package model;

import model.interfaces.IColorStrategy;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
public class Triangle {

	
	
	public void draw(int startX, int startY, int endX, int endY, ShapeShadingType activeShapeShadingType, ShapeColor activePrimaryColor, ShapeColor activeSecondaryColor, Graphics2D graphics2d) {
	
		Calculator c = new Calculator(startX, endX, startY ,endY);
	    int width = c.width();
		
		Polygon polygon = new Polygon();
		polygon.addPoint(c.endX() - width * 2 , c.endY());//bottom-left
		polygon.addPoint(c.endX(), c.endY());//bottom-right
		polygon.addPoint(c.startX(), c.startY());//Top
		
		IColorStrategy color = null; 
		
        switch(activeShapeShadingType) { //shade rectangle depending on the current shadingType
        
   
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
        	
        default:
        	break;
        }
      

		
	}


}
