package model;

import view.interfaces.PaintCanvasBase;

public class DrawHelper {

	static PaintCanvasBase PaintCanvas;
	
	public static void helper(PaintCanvasBase PaintCanvas) {
		DrawHelper.PaintCanvas = PaintCanvas;
	}
	
	public static PaintCanvasBase returnPaint() {
		return PaintCanvas;
	}
	
}
