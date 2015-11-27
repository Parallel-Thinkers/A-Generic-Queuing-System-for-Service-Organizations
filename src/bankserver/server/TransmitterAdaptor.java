package bankserver.server;

import client.ClientFactory;

public class TransmitterAdaptor {
//	ReceiverAdaptor testReceiver = new ReceiverAdaptor();
	ClientFactory client = new ClientFactory();
	
	public void transmitStatus(String message, String type){
		client.getClient().receive(message,type);
//		System.out.println(message);
	}
	
}
