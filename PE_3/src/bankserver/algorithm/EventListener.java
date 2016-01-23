package bankserver.algorithm;

import bankserver.event.INoQEvent;
import bankserver.utilities.Observer;

public class EventListener implements Observer{

	@Override
	public void takeAction(INoQEvent e, String type) {
//		System.out.println(" "+type);
		e.action(type);
	}


}
