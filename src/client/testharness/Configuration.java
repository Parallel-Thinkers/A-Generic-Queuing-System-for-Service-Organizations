package client.testharness;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import bankserver.algorithm.Algorithm;
import bankserver.factory.ComponentFactory;
import bankserver.factory.RequestFactory;
import bankserver.factory.ServersFactory;
import bankserver.model.Model;
import bankserver.request.Request;
import client.ClientFactory;
import client.IClient;
import client.testharness.event.RequestGenerator;
import client.testharness.factory.ServerFactory;

public class Configuration {

	JSONObject jsonObject;
	JSONParser parser = new JSONParser();
	JSONObject js;
	JSONObject server;

//	TestModel m = new TestModel();
	ServerFactory ft = new ServerFactory();
	ServersFactory fb = new ServersFactory();
	RequestGenerator rg;
	
	ComponentFactory factory = new ComponentFactory();
	Algorithm algorithm = new Algorithm();
	Model model = new Model();
	ClientFactory f = new ClientFactory();


	public void configureJSON() throws FileNotFoundException, IOException, ParseException{
		Object obj = parser.parse(new FileReader("/home/kumar/test.json"));
		jsonObject = (JSONObject) obj;
	}
	
	@SuppressWarnings("unchecked")
	public void serviceAvailable() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		//REQUEST TYPE			
		JSONArray type = (JSONArray) jsonObject.get("RequestType");
		Iterator<String> iterator = type.iterator();
		while(iterator.hasNext()){
			Request req = (Request) Class.forName("bankserver.request."+iterator.next()).newInstance();
			RequestFactory rf = new RequestFactory();
			rf.addRequestType(req);
		}
		
	}
	
	
	public void queueBehaviour(){
		//BOUNDED QUEUE
		js = (JSONObject) jsonObject.get("Queue");
		String queueType = (String) js.get("Type");
		if(queueType.equalsIgnoreCase("BOUNDED")){
			String queueLength = (String) js.get("Length");
//			m.setQueueLength(queueLength);
			model.setQueueLength(queueLength);
		}
//		m.setQueueType(queueType);
		model.setQueueType(queueType);
	}
	
	public void setTotalServers(){
		//TOTAL SERVERS	BEING USED
		String totalservers1 =  (String) jsonObject.get("TotalServers");
		int totalservers = Integer.parseInt(totalservers1);
		ft.setTotalServer(totalservers);
		fb.setTotalServer(totalservers);
		
	}
	
	@SuppressWarnings("unchecked")
	public void serverBehaviour(){
		//servers with their delay behaviours
		server= (JSONObject) jsonObject.get("Server");
		JSONArray id = (JSONArray) server.get("Id");
		JSONArray delay = (JSONArray) server.get("Delay");
		 Iterator<String> iterator1 = id.iterator();
		 Iterator<String> iterator2 = delay.iterator();
		 while (iterator1.hasNext() && iterator2.hasNext()) {
			 String temp = iterator1.next();
			 ft.setServer(temp, iterator2.next());
			 fb.setServer(temp);
		 }
	}
	
	
	public void requestArrival(){
		//REQUEST ARRIIVAL BEHVIOUR
		rg = new RequestGenerator((String) jsonObject.get("RequestArrival"));		
	}
	
	
	public void setAlgorithm(){
		factory.setAlgorithm(algorithm);
	}
	
	public void setModel(){
		factory.setModel(model);
	}

	public void setClient(){
		IClient client;
		try {
			client = (IClient) Class.forName("client."+(String) jsonObject.get("Client")).newInstance();
			f.setClient(client);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
//	public String getClient() {
//		return ;
//	}
	
}
