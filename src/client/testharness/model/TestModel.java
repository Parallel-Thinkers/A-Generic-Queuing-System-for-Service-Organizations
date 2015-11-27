package client.testharness.model;

import java.util.LinkedList;
import java.util.Queue;

import bankserver.request.Request;

public class TestModel {
	static int queueLength;
	static String queueType;
	static TestModel model;
	static volatile Queue<String> eventqueue = new LinkedList<String>();
	static Queue<Request> waitingqueue = new LinkedList<Request>();  

//	static Semaphore semaphore = new Semaphore(0); 
	
	public synchronized void enqueue(String requestType){
//		if(queueType.equalsIgnoreCase("BOUNDED")){
//			while(eventqueue.size()==queueLength){
//				
//					System.out.println("Wait for sometime.......your request will be processed soon");
//			}
//		}
		eventqueue.add(requestType);					//add request to event queue
//		semaphore.release();
	}

	 public  synchronized String dequeue(){
//		try {											//dequeue from event queue
//			semaphore.acquire();
			String temp = eventqueue.poll();
			while(temp==null){
				temp = eventqueue.poll();
			}
	
			return temp;
//		}
//		catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		//System.out.println("nullfound");
//		return null;
		
	}

	 
	 
//	public synchronized void waitingEnqueue(Request requestType){
//		waitingqueue.add(requestType);					//add request to waiting queue
//	}
//
//	public synchronized Request waitingDequeue(){
//		return waitingqueue.poll();						//dequeue from waiting queue
//	}

//	public void setQueueLength(String Length) {
//		queueLength = Integer.parseInt(Length);
//	}
//
//	public void setQueueType(String type) {
//		queueType=type;
//	}

//	public void setModel(TestModel m){
//		model=m;
//	}
//	
//	public TestModel getModel(){
//		return model;
//	}
}
