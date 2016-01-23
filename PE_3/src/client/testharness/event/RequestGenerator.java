package client.testharness.event;

import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.math3.distribution.AbstractIntegerDistribution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bankserver.factory.RequestFactory;
import client.testharness.factory.ServerDelayFactory;
import client.testharness.model.TestModel;

public class RequestGenerator extends Thread implements INoQEvent {
	static TestModel model_obj = new TestModel();
	RequestFactory factory = new RequestFactory();
	ServerDelayFactory delayfactory = new ServerDelayFactory();
	static AbstractIntegerDistribution random;
    private Random randomGenerator;
    private static int sleep;
    private ArrayList<String> reqlist;
	private static final Logger logger = LoggerFactory.getLogger(RequestGenerator.class);
	
	public RequestGenerator(){
		reqlist = new ArrayList<String>();
        randomGenerator = new Random();
		reqlist.add("DEPOSIT");
		reqlist.add("WITHDRAWAL");
		reqlist.add("ACCOUNTCREATION");
		reqlist.add("MONEYTRANSFER");
		reqlist.add("DD");
		reqlist.add("FD");
		reqlist.add("RD");
		reqlist.add("LOCKER");
		
	}
	public RequestGenerator(String delayType, int constant){
		random = delayfactory.getRequestDelay(delayType);
		sleep = constant;
	}
	
	public void run(){
//		PoissonDistribution poisson = new PoissonDistribution(2);
		//int i=0;
//		model_obj.setModel(model_obj);
		while(true){
			try {
				int delay = random.sample();
//			System.out.println(sleep);
				Thread.sleep(delay * sleep);
//				System.out.println("token arrives after " + delay + " seconds.");
				
//				System.out.println("Request Type on test harness::"+requestType);
//				Request requesttype = factory.getRequest("DEPOSIT");

				model_obj.enqueue(anyItem());
				
//				model_obj.enqueue("DEPOSIT");
//				model_obj.enqueue("WITHDRAWAL");
//				ReceiverAdaptor receiver_obj = new ReceiverAdaptor("DEPOSIT");		//TestHarness
			} catch (InterruptedException e) {
				e.printStackTrace();
			}//i++;
		}

	}
	
    private String anyItem(){
        int index = randomGenerator.nextInt(reqlist.size());
        String item = reqlist.get(index);
		logger.info("client have requested for " + item + "...");
//        System.out.println("client have requested for " + item + "...");
        return item;
    }

}
