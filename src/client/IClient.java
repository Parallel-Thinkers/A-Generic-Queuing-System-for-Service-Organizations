package client;

public abstract class IClient {
	
	String message;
	String type;
	
	public abstract void requestArrival();
	public abstract void requestRetrieval();
	public abstract void transmit();
	public abstract void receive(String message, String type);
	
}
