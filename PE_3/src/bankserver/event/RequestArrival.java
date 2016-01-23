package bankserver.event;

import bankserver.factory.ComponentFactory;
import bankserver.factory.RequestFactory;
import bankserver.request.Request;
import bankserver.server.TransmitterAdaptor;

public class RequestArrival implements INoQEvent{
//	INSTANCE;
	static Object obj = new Object();
//	Model model_obj = new Model();
	ComponentFactory cf = new ComponentFactory();
//	static int tokenNumber=0;
	TransmitterAdaptor transmitter = new TransmitterAdaptor();
	String message;
	@Override
	public void action(String requestType) {
//		System.out.println(requestType);
		RequestFactory factory = new RequestFactory();
//		Request r = factory.getRequest(requestType);
		Request r = factory.searchRequest(requestType);
//		if(r!=null){
//				while(cf.getModel().getCurrentQueueLength()==cf.getModel().getQueueLength() && cf.getModel().getqueueType().equalsIgnoreCase("BOUNDED")){
//					transmitter.transmitStatus("WAIT FOR SOMETIME............YOUR REQUEST WILL BE PROCESSED SOON!!", null);
//				}
//					synchronized(this){
//						tokenNumber++;
////						System.out.println(tokenNumber);
//						}
//		
////							System.out.println("if!!!");
////							synchronized(this){
////								tokenNumber++;
////							}
////							model_obj.map(tokenNumber,r);
//							cf.getModel().map(tokenNumber,r);
////							Algorithm algo = new Algorithm(tokenNumber);
////							Algorithm a = new Algorithm();
////							a.algo(tokenNumber);
					
				
			
			
		if(r==null){
			transmitter.transmitStatus("REQUEST "+requestType+" FAILED !!......This Service is not available.", null);
		}else{
			cf.getAlgorithm().algo(r);					
		}
			
	}
		
//			synchronized(this){
//				tokenNumber++;
//				}
////			model_obj.map(tokenNumber,r);
//			cf.getModel().map(tokenNumber,r);
////			Algorithm algo = new Algorithm(tokenNumber);
////			Algorithm a = new Algorithm();
////			a.algo(tokenNumber);
//			cf.getAlgorithm().algo(tokenNumber);
//	}
	
	
	
//	static Object obj = new Object();
//	Model model_obj = new Model();
//	static int tokenNumber=0;
//	public TokenArrival(Request requestType) {
//		synchronized(obj){
//			tokenNumber++;
//			}
//		model_obj.map(tokenNumber,requestType);
//		Algorithm algo = new Algorithm(tokenNumber);
//		
//	}

}
