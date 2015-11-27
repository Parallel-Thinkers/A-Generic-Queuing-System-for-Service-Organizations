package bankserver.server;

import bankserver.request.Request;
import bankserver.request.Request.Type;

public class Server {

	boolean flag;
	Request r;						//current request which is being served by particular server
	int tokenNumber;
	
	public synchronized void assignServer(int tokenNumber,Request r) {
		this.r=r;
		this.tokenNumber=tokenNumber;
		flag=true;	
	}
	
	public int getClientToken(){
		return tokenNumber;
	}

	public synchronized boolean ServerStatus() {
		if(flag==false){			//false---> server is empty
			//System.out.println("RAHUL");
			return true;
		}else{						//true---> server is busy
		//	System.out.println("R");
			return false;
		}
	}
	
	public synchronized void ServerFree(){
		r=null;
		flag=false;
	}
	
	public Type getRequest(){		
		return r.type;
	}
}
