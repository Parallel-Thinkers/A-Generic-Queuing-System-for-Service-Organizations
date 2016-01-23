package bankserver.factory;

import bankserver.event.INoQEvent;
import bankserver.event.ServiceComplete;
import bankserver.event.RequestArrival;

public class EventFactory {
	
	public INoQEvent getService(String serviceType){
//		System.out.println("chck"+serviceType);
		if(serviceType=="REQUEST"){
//			return TokenArrival.INSTANCE;
			return new RequestArrival();
		}else if(serviceType=="SERVICE COMPLETE"){
			return new ServiceComplete();
		}else{
			return null;
		}
	
	}
}
