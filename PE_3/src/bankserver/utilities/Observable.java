package bankserver.utilities;

import bankserver.event.INoQEvent;

public class Observable {
	
	private static Observer[] mObserverList = new Observer[0];
	
	public void addObserver (Observer o) {
		Observer[] oldObserverList = mObserverList;
		boolean found = false;
		mObserverList = new Observer[oldObserverList.length + 1];
		for (int i = 0; i < oldObserverList.length; i++) {
			mObserverList[i] = oldObserverList[i];
			if (mObserverList[i] == o) {
				found = true;
			}
		}
		if (found == false) {
			mObserverList[mObserverList.length - 1] = o;
		}
	}

	public void notifyObserver (INoQEvent e,String type) {	//type may be server number in case of SERVICE COMPLETE or request type in case of Token Arrival
		
		for (int i = 0; i < mObserverList.length; i++) {
			mObserverList[i].takeAction(e,type);
		}
	}
}
