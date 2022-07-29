package view.gui;

import view.interfaces.PaintCanvasBase;
import model.Shape;
import model.ShapeList;
import model.StaticShapeList;

import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;


public class PaintCanvas extends PaintCanvasBase {

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
    
    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2d = (Graphics2D)g;
        ArrayList<Shape> shapelist = StaticShapeList.mainShapeList.returnShapeList();
        
        for (Shape shape: shapelist) {
        	shape.draw(graphics2d);
        	
        }

        // Draw all shapes here

  
    }
}
