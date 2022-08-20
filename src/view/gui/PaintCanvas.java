package view.gui;

import view.interfaces.IShape;
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
        ArrayList<IShape> shapelist = StaticShapeList.mainShapeList.returnShapeList();
        ArrayList<IShape> displayselected = StaticShapeList.displaySelected.returnShapeList();
        ArrayList<IShape> selectedshapelist = StaticShapeList.selectedShapeList.returnShapeList();
        
        for (IShape shape: shapelist) {
        	shape.draw(graphics2d);
        	
        }
        
        if (!selectedshapelist.isEmpty()){
	        for (IShape shape: displayselected) {
	        	shape.draw(graphics2d);
	        }
        }
  
    }
    
    public void clear() {
    	PaintCanvas.getInstance().getGraphics2D().clearRect(0, 0, PaintCanvas.getInstance().getWidth(), PaintCanvas.getInstance().getWidth());
    }
}
