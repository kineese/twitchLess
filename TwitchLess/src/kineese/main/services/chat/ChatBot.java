package kineese.main.services.chat;

import org.jibble.pircbot.PircBot;

public class ChatBot extends PircBot {

	private ChatService service;

	public ChatBot(ChatService service) {
		this.service = service;
		setName(ChatStaticVariables.USER_NAME);
	}

	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		MessageInfo msgInfo = new MessageInfo(channel, sender, login, hostname, message);
		this.service.passThoughMessage(msgInfo);
	}

}
