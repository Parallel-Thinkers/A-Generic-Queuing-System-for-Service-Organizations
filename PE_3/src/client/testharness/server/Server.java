package client.testharness.server;
import org.apache.commons.math3.distribution.AbstractRealDistribution;
//import org.apache.commons.math3.distribution.NormalDistribution;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import client.testharness.factory.ServerDelayFactory;

public class Server extends Thread {
//	static NormalDistribution gaussian = new NormalDistribution();
//	AbstractRealDistribution gaussian = new NormalDistribution();
	TransmitterAdaptor transmitter = new TransmitterAdaptor();
	ServerDelayFactory factory = new ServerDelayFactory();
	private static final Logger logger = LoggerFactory.getLogger(Server.class);

	int id,sleep;
	AbstractRealDistribution random;
	public Server(int id,String delayType,int constant){
		this.id = id;			//id is current server number
		this.sleep=constant;
		random = factory.getProcessDelay(delayType);
	}
	public void run(){
		processRequest();
	}
	
	public synchronized void processRequest(){
		double delay = Math.abs(random.sample());
		try {
//			System.out.println(sleep);
			Thread.sleep((long) (delay*sleep));
			logger.info("Request Processing Time at server number "+ id+" is "+(long) (delay*15000)+" milliseconds");
//			System.out.println("Request Processing Time at server number "+ id+" is "+(long) (delay*15000)+" milliseconds");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		transmitter.transmit("SERVICE COMPLETE", ""+id);
		

	}
}
