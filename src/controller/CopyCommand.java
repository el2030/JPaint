package controller;

import java.util.ArrayList;

import model.Shape;
import model.StaticShapeList;

public class CopyCommand {
	
	
	public static void copy() {
		
		StaticShapeList.clipBoard.clear();
		ArrayList<Shape> selectedshapes = StaticShapeList.selectedShapeList.returnShapeList();
		for (Shape selectedshape: selectedshapes) {
			//Shape shape = selectedshape;
			StaticShapeList.clipBoard.add(selectedshape);
		}
	}
	
}
