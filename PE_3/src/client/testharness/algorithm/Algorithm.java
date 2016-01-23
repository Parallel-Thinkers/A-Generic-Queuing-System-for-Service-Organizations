package client.testharness.algorithm;

import client.testharness.factory.ServerFactory;

//
//import org.apache.commons.math3.distribution.NormalDistribution;
//
//import TestHarness.test.Factory.ServerFactory;
//import TestHarness.test.Model.Model;
//import BankServer.Server.ReceiverAdaptor;
//import BankServer.Server.Server;
//import BankServer.request.Request;
//
public class Algorithm {
	
	public Algorithm(String type){
		int serverNumber1 = Integer.parseInt(type);
		ServerFactory factory = new ServerFactory();
		Thread t = new Thread(factory.getServer(serverNumber1));
		t.start();

	}
//
//	Model model_obj = new Model();
//	ReceiverAdaptor receiver = new ReceiverAdaptor();
//	static NormalDistribution gaussian = new NormalDistribution();
//	ServerFactory factory = new ServerFactory();
//	String status="Not Assigned";
//	
//	public void algorithm(Request r){
//		receiver.service(""+r.type);
//		for(int serverNumber=0;serverNumber<factory.getTotalServer();serverNumber++){
//			Server s = factory.getServer(serverNumber);
//			if(s.ServerStatus()){
//				s.assignServer(r);
//				status="Assigned";
////				System.out.println(serverNumber+" Request Assigned");
//				testGaussian(r,serverNumber);
//				break;
//			}
//		}
//		
//		if(status.equalsIgnoreCase("Not Assigned")){
//		//	System.out.println("Server Busy");
//			model_obj.waitingEnqueue(r);
//		}
//	}
//	
//
//	public void testGaussian(Request r,int serverNumber){
//		double delay = Math.abs(gaussian.sample());
//		try {
//			Thread.sleep((long) (delay*10000));
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
////		System.out.println(serverNumber+" Request Completed");
//		receiver.service("Service Complete");		//service complete is a service type
//		Request r1 = model_obj.waitingDequeue();
//		if(r1!=null){
//			testGaussian(r1,serverNumber);
//		}else{
//			factory.getServer(serverNumber).ServerFree();
//		}
//		
//	}
//	
}
