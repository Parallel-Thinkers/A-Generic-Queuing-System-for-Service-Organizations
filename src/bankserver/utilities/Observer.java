package bankserver.utilities;

import bankserver.event.INoQEvent;

public interface Observer {

	public void takeAction (INoQEvent e, String type);
}
