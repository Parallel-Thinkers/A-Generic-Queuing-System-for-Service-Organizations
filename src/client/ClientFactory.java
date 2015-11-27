package client;

public class ClientFactory {
	static IClient client;

	public void setClient(IClient c){
		client = c;
	}

	public IClient getClient(){
		return client;
	}


}
