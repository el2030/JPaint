package controller;

import java.util.ArrayList;
import model.Calculator;
import view.interfaces.IShape;



public class ShapeMovement {
	
//	private final List<IObserver> movementObservers = new ArrayList<>();
//	ArrayList<IShape> selectedshapes;
//	IShape shape;
	
//	public ShapeMovement(ArrayList<IShape> selectedshapes, IShape shape) {
//		this.selectedshapes = selectedshapes;
//		this.shape = shape;
//	}
//	
	public static void move(ArrayList<IShape> selectedshapes, IShape shape) {
		
		Calculator calculate = new Calculator(shape.getStartX(), shape.getEndX(), shape.getStartY(), shape.getEndY());
		for (IShape selectedshape: selectedshapes) {
			selectedshape.setStartX(selectedshape.getStartX() + calculate.deltaX());
			selectedshape.setStartY(selectedshape.getStartY() + calculate.deltaY());
			selectedshape.setEndX(selectedshape.getEndX() + calculate.deltaX());
			selectedshape.setEndY(selectedshape.getEndY() + calculate.deltaY());

		}
//		notifySpacebarObservers();
	}
	
	public static void undoMove(ArrayList<IShape> selectedshapes, IShape shape) {
		
		Calculator calculate = new Calculator(shape.getStartX(), shape.getEndX(), shape.getStartY(), shape.getEndY());
		for (IShape selectedshape: selectedshapes) {
			selectedshape.setStartX(selectedshape.getStartX() - calculate.deltaX());
			selectedshape.setStartY(selectedshape.getStartY() - calculate.deltaY());
			selectedshape.setEndX(selectedshape.getEndX() - calculate.deltaX());
			selectedshape.setEndY(selectedshape.getEndY() - calculate.deltaY());
		}
//		notifySpacebarObservers();
	}

//	@Override
//	public void registerObserver(IObserver o) {
//		
//		movementObservers.add(o);
//		
//	}
//	
//	void notifySpacebarObservers(){
//		
//        for (var movementObserver : movementObservers){
//        	movementObserver.update();
//        	
//        }
//    }


}
