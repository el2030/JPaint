package model;

import java.awt.*;

import model.interfaces.IColorStrategy;

//Strategy Pattern
public enum ShapeColor implements IColorStrategy {
	
    BLACK {
    	@Override
        public Color getColor(){
            return Color.BLACK;
        }
    },
    BLUE{
    	@Override
        public Color getColor(){
            return Color.BLUE;
        }
    },
    CYAN{
    	@Override
        public Color getColor(){
            return Color.CYAN;
        }
    },
    DARK_GRAY{
    	@Override
        public Color getColor(){
            return Color.DARK_GRAY;
        }
    },
    GRAY{
    	@Override
        public Color getColor(){
            return Color.GRAY;
        }
    },
    GREEN{
    	@Override
        public Color getColor(){
            return Color.GREEN;
        }
    },
    LIGHT_GRAY{
    	@Override
        public Color getColor(){
            return Color.LIGHT_GRAY;
        }
    },
    MAGENTA{
    	@Override
        public Color getColor(){
            return Color.MAGENTA;
        }
    },
    ORANGE{
    	@Override
        public Color getColor(){
            return Color.ORANGE;
        }
    },
    PINK{
    	@Override
        public Color getColor(){
            return Color.PINK;
        }
    },
    RED{
    	@Override
        public Color getColor(){
            return Color.RED;
        }
    },
    WHITE{
    	@Override
        public Color getColor(){
            return Color.WHITE;
        }
    },
    YELLOW{
    	@Override
        public Color getColor(){
            return Color.YELLOW;
        }
    };
	
//enumeration literal mapping using the strategy pattern
	
//Source: https://www.baeldung.com/a-guide-to-java-enums, https://www.geeksforgeeks.org/how-to-implement-a-strategy-pattern-using-enum-in-java/
	//example: https://dev.to/masreis/strategy-design-pattern-with-java-enum-1am0

	public abstract Color getColor();

}

