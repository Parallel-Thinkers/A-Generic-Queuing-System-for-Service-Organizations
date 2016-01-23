package bankserver.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import bankserver.request.Request;



public class Model {

	static int queueLength;
	static String queueType;

	HashMap<String,Request> hm = new HashMap<String,Request>();
//	HashMap<String,String> tm = new HashMap<String,String>();
//	HashMap<String,String> m = new HashMap<String,String>();
	Queue<String> waitingqueue = new LinkedList<String>();  
	
	public void map(int tokenNumber, Request request_obj) {		//stores key:tokenNumber and value:Request		
		String token_no = ""+tokenNumber;
		hm.put(token_no, request_obj);
		
	}
	
	public Request getRequest(int tokenNumber){
		String token_no = ""+tokenNumber;
		return hm.get(token_no);
	}
	
	public synchronized void waitingEnqueue(int tokenNumber){
		String token_no = ""+tokenNumber;
		waitingqueue.add(token_no);					//add request to waiting queue
	}

	public synchronized String waitingDequeue(){
		return waitingqueue.poll();						//dequeue from waiting queue
	}

	
	
	public void setQueueType(String type) {
		queueType=type;
	}

	public String getqueueType(){
		return queueType;
	}
	
	public void setQueueLength(String Length) {
		queueLength = Integer.parseInt(Length);
	}

	public synchronized int getCurrentQueueLength(){
		return waitingqueue.size();
	}
	
	public int getQueueLength(){
		return queueLength;
	}
	
//	public void threadMap(long thread_id, int serverNumber) {		//stores key:thread_id and value:serverNumber		
//		String server_no = ""+serverNumber;
//		String t_id = ""+thread_id;
//		tm.put(t_id, server_no);
//	}
	
//	public int getServerNumber(long thread_id){
//		String t_id = ""+thread_id;
//		return Integer.parseInt(tm.get(t_id));
//	}
	
//	public void tokenMap(long thread_id, int tokenNumber) {		//stores key:thread_id and value:tokenNumber		
//		String token_no = ""+tokenNumber;
//		String t_id = ""+thread_id;
//	//	System.out.println(t_id+" "+token_no);
//		m.put(t_id, token_no);
//	}

//	public int getTokenNumber(long thread_id){
//		String t_id = ""+thread_id;
//	//	System.out.println(t_id);
//		return Integer.parseInt(m.get(t_id));
//	}

	
}
