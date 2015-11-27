package bankserver.server;

import bankserver.event.INoQEvent;
import bankserver.factory.EventFactory;
import bankserver.factory.RequestFactory;
import bankserver.utilities.Observable;

public class ReceiverAdaptor extends Observable {

	RequestFactory factory = new RequestFactory();
	
	public void receive(String message, String type){
//		System.out.println("check"+message+" "+type);
		EventFactory factory = new EventFactory();
		INoQEvent e = factory.getService(message);
	//	System.out.println("chck"+e);
		notifyObserver (e,type);
		
	}
//	public void service(String serviceType){
//		if(serviceType.equalsIgnoreCase("Service Complete")){
//			ServiceComplete obj = new ServiceComplete();
//			//service complete implementation
//			
//		}else{
//			System.out.println("Request Type on Bank Server::"+serviceType);
//			Request requesttype = factory.getRequest(serviceType);
//			TokenArrival token = new TokenArrival(requesttype);
//			
//		}
//	}
	
}
