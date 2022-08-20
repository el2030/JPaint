package controller;

import java.util.ArrayList;
import model.StaticShapeList;
import view.interfaces.IShape;

public class CopyCommand {
	
	
	public static void copy() {
		
		StaticShapeList.clipBoard.clear();
		ArrayList<IShape> selectedshapes = StaticShapeList.selectedShapeList.returnShapeList();
		for (IShape selectedshape: selectedshapes) {
			StaticShapeList.clipBoard.add(selectedshape);
		}
	}
	
}
