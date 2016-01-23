package client.testharness.event;

//import TestHarness.test.Algorithm.Algorithm;
import client.testharness.model.TestModel;
import client.testharness.server.TransmitterAdaptor;

public class RequestReceiver extends Thread implements INoQEvent{
	static TestModel model_obj = new TestModel();
//	Algorithm algo = new Algorithm();
	TransmitterAdaptor transmitter = new TransmitterAdaptor();
	
	
	public void run(){
		while(true){
			//System.out.println("ra"+model_obj.dequeue());
//			algo.algorithm(model_obj.dequeue());
			String request = model_obj.dequeue();
//	        System.out.println("client have requested for " + request + "...");
		transmitter.transmit("REQUEST",request);
		
//		System.out.println("RAHUHHH"+"                     "+model_obj.dequeue());
			//Thread t1 = new Thread(new EventReceiver());
			//t1.start();
		}
	}
	

}