package bankserver.factory;

import bankserver.server.Server;


public class ServersFactory {
	
	//static Server serverList[]=new Server[0];
	
	static int TotalServer;
	static Server[] server;	//array of object(server)

//	static{
//		for(int i=0;i<TotalServer;i++){
//			server[i]=new Server();			//creation of new server
//		}
//		
//	}

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

	public void setServer(String id) {
		int i = Integer.parseInt(id);
		server[i]=new Server();
		
	}
	

//	final static int TotalServer = 3;
//	static Server[] server = new Server[TotalServer];	//array of object(server)
//
//	static{
//		for(int i=0;i<TotalServer;i++){
//			server[i]=new Server();			//creation of new server
//		}
//		
//	}
//	
////	public void addserver(MainServer s){
////		MainServer[] oldserverList = serverList;
////		boolean found = false;
////		serverList = new MainServer[oldserverList.length + 1];
////		for (int i = 0; i < oldserverList.length; i++) {
////			serverList[i] = oldserverList[i];
////			if (serverList[i] == s) {
////				found = true;
////			}
////		}
////		if (found == false) {
////			serverList[serverList.length - 1] = s;
////		}
////	}
//
////	public Server getServer(int serverNumber){
////		if(serverList.length>serverNumber)
////		return serverList[serverNumber];
////		return null;
////	}
//	
//	public int getServerlength(){
//		return serverList.length;
//	}
//	
//	
}
