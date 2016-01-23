package test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import bankserver.algorithm.EventListener;
import bankserver.utilities.Observable;
import client.ClientFactory;
import client.testharness.Configuration;



public class Test {
	
//	@SuppressWarnings({ "unchecked", "unused" })
	
	public static void main(String[] args) throws FileNotFoundException{
		Configuration configure = new Configuration();
		EventListener e = new EventListener();
		Observable o = new Observable();
		o.addObserver(e);
		
		ClientFactory f = new ClientFactory();
		
		try {
			configure.configureJSON();
			configure.serviceAvailable();
			configure.queueBehaviour();
			configure.setTotalServers();
			configure.serverBehaviour();
			configure.requestArrival();
			configure.setAlgorithm();
			configure.setModel();
			configure.setClient();
			configure.setFile();
		} catch (IOException | ParseException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
//SET CLIENT
//		IClient client = new TestHarness();
//		= (Request) Class.forName("bankserver.request."+iterator.next()).newInstance();
//		
//		f.setClient(client);
		
		f.getClient().requestArrival();;
		f.getClient().requestRetrieval();

		
//		EventReceiver r2 = new EventReceiver();
//		EventReceiver r3 = new EventReceiver();
//		EventReceiver r4 = new EventReceiver();
		
//		RequestGenerator rg;
//		TestModel m = new TestModel();
//		ComponentFactory factory = new ComponentFactory();
//		Algorithm algorithm = new Algorithm();
//		Model model = new Model();
		
//		factory.setAlgorithm(algorithm);
//		factory.setModel(model);
		
//		JSONParser parser = new JSONParser();
//
//		try {
//
//			Object obj = parser.parse(new FileReader("/home/kumar/test.json"));
//
//			JSONObject jsonObject = (JSONObject) obj;
//			JSONObject js;
//			JSONObject server;

		
		
////REQUEST TYPE		
//			JSONArray type = (JSONArray) jsonObject.get("RequestType");
//			Iterator<String> iterator = type.iterator();
//			while(iterator.hasNext()){
//				Request req = (Request) Class.forName("BankServer.request."+iterator.next()).newInstance();
//				RequestFactory rf = new RequestFactory();
//				rf.addRequestType(req);
//			}
			
			
			
			
			
////BOUNDED QUEUE
//			js = (JSONObject) jsonObject.get("Queue");
//			String queueType = (String) js.get("Type");
//			if(queueType.equalsIgnoreCase("BOUNDED")){
//				String queueLength = (String) js.get("Length");
//				m.setQueueLength(queueLength);
//			}
//			m.setQueueType(queueType);

			
			
			
////TOTAL SERVERS	BEING USED
//			String totalservers1 =  (String) jsonObject.get("TotalServers");
//			int totalservers = Integer.parseInt(totalservers1);
//			ServerFactory ft = new ServerFactory();
//			ft.setTotalServer(totalservers);
//			ServersFactory fb = new ServersFactory();
//			fb.setTotalServer(totalservers);

			
			
			
////servers with their delay behaviours
//			server= (JSONObject) jsonObject.get("Server");
//			JSONArray id = (JSONArray) server.get("Id");
//			JSONArray delay = (JSONArray) server.get("Delay");
//			 Iterator<String> iterator1 = id.iterator();
//			 Iterator<String> iterator2 = delay.iterator();
//			 while (iterator1.hasNext() && iterator2.hasNext()) {
//				 String temp = iterator1.next();
//				 ft.setServer(temp, iterator2.next());
//				 fb.setServer(temp);
//			 }
			
			
//******CODE SECTION NOT USED*****			
//			for(int i=0;i<totalservers;i++){
//				String j = ""+i;
//				ft.setServer(j, (String) jsonObject.get(j));
//				fb.setServer(j);
//			}
//*****END*****
			
			
////REQUEST ARRIIVAL BEHVIOUR
//			rg = new RequestGenerator((String) jsonObject.get("RequestArrival"));
			
			
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//		catch (InstantiationException e1) {
//			e1.printStackTrace();
//		} catch (IllegalAccessException e1) {
//			e1.printStackTrace();
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		}
		
		
		
//		Server1 s1=new Server1();
//		Server2 s2=new Server2();
//		Server3 s3=new Server3();
//		g1.start();
//		r1.start();
//		r2.start();
//		r3.start();
//		r4.start();
	}

}
