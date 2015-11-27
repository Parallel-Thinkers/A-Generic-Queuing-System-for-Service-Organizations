package client;

import client.IClient;
import client.testharness.event.RequestGenerator;
import client.testharness.event.RequestReceiver;
import client.testharness.server.ReceiverAdaptor;

public class TestHarness extends IClient{

	public void requestArrival() {
		RequestGenerator g1 = new RequestGenerator();
		g1.start();
	}

	public void requestRetrieval() {
		RequestReceiver r1 = new RequestReceiver();
		r1.start();
	}

	public void transmit() {
		// TODO Auto-generated method stub
		
	}

	public void receive(String message, String type) {
		ReceiverAdaptor testReceiver = new ReceiverAdaptor();
		testReceiver.receive(message,type);
	}

}
