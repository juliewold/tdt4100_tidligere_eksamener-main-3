package del5_og_6;

public class StatusTestListener implements StatusListener {

	public String oldStatus;
	public String newStatus;
	public String user;


	@Override
	public void statusChanged(final String userName, final String oldStatus, final String newStatus) {
		this.oldStatus = oldStatus;
		this.newStatus = newStatus;
		this.user = userName;

	}

}
