package model;


public class Collision {
	
		
	public static boolean detected(Shape one, Shape two) {
		
		Calculator shapeOne = new Calculator(one.startX, one.endX, one.startY , one.endY);
		
		Calculator shapeTwo = new Calculator(two.startX, two.endX, two.startY , two.endY);
	
	if (shapeOne.startX() < shapeTwo.endX() && shapeOne.endX() > shapeTwo.startX() && shapeOne.startY() < shapeTwo.endY() && shapeOne.endY() > shapeTwo.startY()) {
			return true;
		}
		return false;
	}

	

}
