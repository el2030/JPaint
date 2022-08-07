package view.gui;

import view.interfaces.PaintCanvasBase;
import model.Shape;
import model.ShapeList;
import model.StaticShapeList;

import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;


public class PaintCanvas extends PaintCanvasBase {
	
	private static PaintCanvas instance = new PaintCanvas();
	private PaintCanvas() {};
	public static PaintCanvas getInstance() { return instance;}; 
	
	
    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D)g;
        ArrayList<Shape> shapelist = StaticShapeList.mainShapeList.returnShapeList();
        ArrayList<Shape> displayselected = StaticShapeList.displaySelected.returnShapeList();
        ArrayList<Shape> selectedshapelist = StaticShapeList.selectedShapeList.returnShapeList();
        
        for (Shape shape: shapelist) {
        	shape.draw(graphics2d);
        	
        }
        
        if (!selectedshapelist.isEmpty()){
	        for (Shape shape: displayselected) {
	        	shape.draw(graphics2d);
	        }
        }

        // Draw all shapes here

  
    }
    
    public void clear() {
    	PaintCanvas.getInstance().getGraphics2D().clearRect(0, 0, PaintCanvas.getInstance().getWidth(), PaintCanvas.getInstance().getWidth());
    }
}
