package model;

import view.interfaces.IShape;

public class Collision {
	
		
	public static boolean detected(IShape one, IShape two) {
		
		Calculator shapeOne = new Calculator(one.getStartX(), one.getEndX(), one.getStartY() , one.getEndY());
		
		Calculator shapeTwo = new Calculator(two.getStartX(), two.getEndX(), two.getStartY() , two.getEndY());
	
	if (shapeOne.startX() < shapeTwo.endX() && shapeOne.endX() > shapeTwo.startX() && shapeOne.startY() < shapeTwo.endY() && shapeOne.endY() > shapeTwo.startY()) {
			return true;
		}
		return false;
	}

	

}
