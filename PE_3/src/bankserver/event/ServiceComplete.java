package bankserver.event;

import test.FileOutput;
import bankserver.factory.ComponentFactory;
import bankserver.factory.ServersFactory;
import bankserver.server.Server;
import bankserver.server.TransmitterAdaptor;
import bankserver.utilities.Observable;

public class ServiceComplete extends Observable implements INoQEvent{
//	Model model_obj = new Model();
	ComponentFactory cf = new ComponentFactory();
	TransmitterAdaptor transmitter = new TransmitterAdaptor();
	FileOutput o = new FileOutput();
	String message = "";

	@Override
	public void action(String serverNumber) {
		int serverNumber1 = Integer.parseInt(serverNumber);
		ServersFactory factory = new ServersFactory();
		Server s = factory.getServer(serverNumber1);
		message = "Token Number"+s.getClientToken()+" Request Completed on server number"+serverNumber1;
		transmitter.transmitStatus(message,"SERVICE COMPLETE");
		
//		String token_no=model_obj.waitingDequeue();
		String token_no=cf.getModel().waitingDequeue();
		
		if(token_no!=null){
			String message = "token number"+token_no+" Request "+cf.getModel().getRequest(Integer.parseInt(token_no)).type+"... Assigned to server"+serverNumber;
			o.setFileContent(message+","+cf.getModel().getCurrentQueueLength());
//			s.assignServer(Integer.parseInt(token_no), model_obj.getRequest(Integer.parseInt(token_no)));
			s.assignServer(Integer.parseInt(token_no), cf.getModel().getRequest(Integer.parseInt(token_no)));
//			model_obj.threadMap(Thread.currentThread().getId(), serverNumber);	//Thread.currentThread().getId() <-- returns current thread id
//			model_obj.tokenMap(Thread.currentThread().getId(), Integer.parseInt(token_no));
			transmitter.transmitStatus(message,""+serverNumber);
//			notifyObserver(new AssignRequest(), serverNumber);
		}else{
			s.ServerFree();
		}

		
	}

//	Model model_obj = new Model();
//	TransmitterAdaptor transmitter = new TransmitterAdaptor();
//	String message = "";
//	public ServiceComplete(){
//		message = "Token Number"+model_obj.getTokenNumber(Thread.currentThread().getId())+" Request Completed on server number"+model_obj.getServerNumber(Thread.currentThread().getId());
//		transmitter.transmitStatus(message);
//		AlgorithmThread algothread = new AlgorithmThread(model_obj.getServerNumber(Thread.currentThread().getId()));
//	}
}
