package client.testharness.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import client.testharness.algorithm.Algorithm;

public class ReceiverAdaptor {
	Algorithm algo;
	private static final Logger logger = LoggerFactory.getLogger(ReceiverAdaptor.class);
	
	public void receive(String message, String type){
//		logger.info("start info");
		logger.info(message);
//		System.out.println(message);
//		logger.info("end info");
		
		if(type!="SERVER BUSY" && type!= "SERVICE COMPLETE" && type!=null){
			algo = new Algorithm(type);
		}
	}

}
