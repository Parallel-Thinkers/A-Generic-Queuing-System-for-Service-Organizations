package client.testharness.server;

import bankserver.server.ReceiverAdaptor;

public class TransmitterAdaptor {
	ReceiverAdaptor bankreceiver = new ReceiverAdaptor();
	
	public void transmit(String message, String serviceType) {
		bankreceiver.receive(message, serviceType);
	}

}
