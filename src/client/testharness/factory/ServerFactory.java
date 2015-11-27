package client.testharness.factory;

import client.testharness.server.Server;


public class ServerFactory {

	static int TotalServer;
	static Server[] server;	//array of object(server)

//	static{
//		for(int i=0;i<TotalServer;i++){
//			server[i]=new Server(i);			//creation of new server
//		}
//		
//	}
	
	public void setServer(String id, String delayType){
		int i = Integer.parseInt(id);
		server[i]=new Server(i,delayType);
	}

	public Server getServer(int serverNumber){		
		return server[serverNumber];
	}

	public void setTotalServer(int number){
		TotalServer=number;
		server = new Server[TotalServer];
	}	
	
	public int getTotalServer(){
		return TotalServer;
	}

}
