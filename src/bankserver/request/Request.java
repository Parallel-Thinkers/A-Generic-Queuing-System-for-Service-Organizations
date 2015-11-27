package bankserver.request;

public abstract class Request {
	public enum Type {
		DEPOSIT,
		WITHDRAWAL,
		ACCOUNTCREATION,
		MONEYTRANSFER,
		DD,
		FD,
		RD,
		LOCKER
	}
	
	public final Type type;
	
	public Request(Type t) {
		this.type = t;
	}
}
