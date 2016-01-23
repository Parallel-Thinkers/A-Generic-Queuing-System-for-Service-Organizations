package bankserver.factory;

import java.util.ArrayList;

import bankserver.request.Request;

public class RequestFactory {
	static ArrayList<Request> requestList = new ArrayList<Request>();
	
//	public Request getRequest(String requestType){
//		
//		if(requestType=="DEPOSIT"){
//			return new Deposit();
//		}else if(requestType=="WITHDRAWAL"){
//			return new Withdrawal();
//		}else{
//			return null;
//		}
//
//	}
	
	
	public void addRequestType(Request r){		//POSSIBLE REQUEST
		requestList.add(r);
	}
	
	public Request searchRequest(String r){
		for (Request temp : requestList) {
			String s = ""+temp.type;
			if(s.equalsIgnoreCase(r)){
				return temp;
			}	
		}
		return null;		
	}
	

}
