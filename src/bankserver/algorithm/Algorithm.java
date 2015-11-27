package bankserver.algorithm;

import bankserver.factory.ComponentFactory;
import bankserver.factory.ServersFactory;
import bankserver.request.Request;
import bankserver.server.Server;
import bankserver.server.TransmitterAdaptor;

//public class Algorithm extends Observable{
public class Algorithm{

//	Model model_obj = new Model();
	ComponentFactory cf = new ComponentFactory();
	TransmitterAdaptor transmitter = new TransmitterAdaptor();
	ServersFactory factory = new ServersFactory();
	String status;
	String message="";
	static int tokenNumber=0;
	
	public void algo(Request r){
		
		if(cf.getModel().getCurrentQueueLength()==cf.getModel().getQueueLength() && cf.getModel().getqueueType().equalsIgnoreCase("BOUNDED")){
			transmitter.transmitStatus("WAIT FOR SOMETIME............YOUR REQUEST WILL BE PROCESSED SOON!! AS MAX QUEUE LENGTH "+cf.getModel().getQueueLength() +" REACHED", null);
		}else{
			synchronized(this){
				tokenNumber++;
//				System.out.println(tokenNumber);
				}

//					System.out.println("if!!!");
//					synchronized(this){
//						tokenNumber++;
//					}
//					model_obj.map(tokenNumber,r);
					cf.getModel().map(tokenNumber,r);
//					Algorithm algo = new Algorithm(tokenNumber);
//					Algorithm a = new Algorithm();
//					a.algo(tokenNumber);
//					cf.getAlgorithm().algo(tokenNumber);
		
		
	//	System.out.println(factory.getServerlength());
		status="Not Assigned";
			for(int serverNumber=0;serverNumber<factory.getTotalServer();serverNumber++){
				Server s = factory.getServer(serverNumber);
			//	System.out.println("check"+s.ServerStatus());
				if(s.ServerStatus()){
//					Request r = model_obj.getRequest(tokenNumber);
//					Request r = cf.getModel().getRequest(tokenNumber);
					s.assignServer(tokenNumber,r);
					status="Assigned";
					message="token number"+tokenNumber+" Request "+r.type+" Assigned to server"+serverNumber;
//					model_obj.threadMap(Thread.currentThread().getId(), serverNumber);	//Thread.currentThread().getId() <-- returns current thread id
//					model_obj.tokenMap(Thread.currentThread().getId(), tokenNumber);
////					System.out.println(serverNumber+" Request Assigned");
					transmitter.transmitStatus(message,""+serverNumber);
//					notifyObserver(new AssignRequest(),""+serverNumber);
					break;
				}
			}
			
			if(status.equalsIgnoreCase("Not Assigned")){
//				System.out.println("Server Busy");
				message="token number"+tokenNumber+" WAIT!!........All Server are Busy and "+cf.getModel().getCurrentQueueLength()+" requests ahead of you in waiting queue.";
				transmitter.transmitStatus(message,"SERVER BUSY");
//				model_obj.waitingEnqueue(tokenNumber);
				cf.getModel().waitingEnqueue(tokenNumber);
			}
		
	}
	}

}
