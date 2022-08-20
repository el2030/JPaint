package controller;

import java.util.ArrayList;
import java.util.List;

import view.interfaces.IObserver;
import view.interfaces.ISubject;

public class Subject implements ISubject {

	private final List<IObserver> movementObservers = new ArrayList<>();
	
	@Override
	public void registerObserver(IObserver o) {
		
		movementObservers.add(o);
		
	}
	
	void notifySpacebarObservers(){
		
        for (var movementObserver : movementObservers){
        	movementObserver.update();
        	
        }
    }

}
