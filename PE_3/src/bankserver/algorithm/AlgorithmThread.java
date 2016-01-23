package bankserver.algorithm;
//package BankServer.Algorithm;
//
//import BankServer.Factory.ServerComponentFactory;
//import BankServer.Model.Model;
//import BankServer.Server.TransmitterAdaptor;
//
//public class AlgorithmThread {
//
//	Model model_obj = new Model();
//	TransmitterAdaptor transmitter = new TransmitterAdaptor();
//	ServerComponentFactory factory = new ServerComponentFactory();
//	
//	public AlgorithmThread(int serverNumber){
//		String token_no=model_obj.waitingDequeue();
//		if(token_no!=null){
//			String message = "token number"+token_no+" Request Assigned to server"+serverNumber;
//			model_obj.threadMap(Thread.currentThread().getId(), serverNumber);	//Thread.currentThread().getId() <-- returns current thread id
//			model_obj.tokenMap(Thread.currentThread().getId(), Integer.parseInt(token_no));
//			transmitter.transmitStatus(message);
//		}else{
//			factory.getServer(serverNumber).ServerFree();
//		}
//		
//	}
//}
