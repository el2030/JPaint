package controller;

import view.gui.PaintCanvas;
import view.interfaces.IObserver;

public class Observer implements IObserver {

	@Override
	public void update() {
		PaintCanvas.getInstance().repaint();
		
	}

}
