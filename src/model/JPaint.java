package model;

import controller.IJPaintController;
import controller.JPaintController;
import controller.Mouse;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;
import java.util.Collection;
import java.util.EnumMap;
import java.awt.*;
import java.awt.Point;
import javax.swing.*;
import java.awt.event.*;
public class JPaint {

    public void run (){
    	 
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();

        // For example purposes only; remove all lines below from your final project.
               
   
        //will probably clean this up later
        Mouse m = new Mouse(paintCanvas, appState);
        paintCanvas.addMouseListener(m);
        
        

        
        // Filled in rectangle
        //Graphics2D graphics2d = paintCanvas.getGraphics2D();
        //graphics2d.setColor(Color.GREEN);
        //graphics2d.fillRect(12, 13, 200, 400);
 

        // Outlined rectangle
  /*      graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(Color.BLUE);
        graphics2d.drawRect(12, 13, 200, 400);

        // Selected Shape
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        graphics2d.drawRect(7, 8, 210, 410);*/
    }
}
