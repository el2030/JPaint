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

public class JPaint {

    public void run (){
    	 
        PaintCanvasBase paintCanvas = PaintCanvas.getInstance();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();

   
        Mouse m = new Mouse(paintCanvas, appState);
        paintCanvas.addMouseListener(m);
        
      
    }
}
