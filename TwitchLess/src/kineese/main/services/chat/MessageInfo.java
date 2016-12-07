package kineese.main.services.chat;

public class MessageInfo {

	private String channel;

	public String getChannel() {
		return channel;
	}

	public String getSender() {
		return sender;
	}

	public String getLogin() {
		return login;
	}

	public String getHostname() {
		return hostname;
	}

	public String getMessage() {
		return message;
	}

	private String sender;
	private String login;
	private String hostname;
	private String message;

	public MessageInfo(String channel, String sender, String login, String hostname, String message) {
		this.channel = channel;
		this.sender = sender;
		this.login = login;
		this.hostname = hostname;
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageInfo [channel=" + channel + ", sender=" + sender + ", login=" + login + ", hostname=" + hostname
				+ ", message=" + message + "]";
	}

	public String convertToChatMessage() {
		String formattedMessage = String.format("%s : %s ", login, message);
		return formattedMessage;
	}

}
