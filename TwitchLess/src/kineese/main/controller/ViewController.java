package kineese.main.controller;

import javax.swing.text.DefaultStyledDocument;

import kineese.main.dataholders.StreamInformation;
import kineese.main.services.chat.ChatService;
import kineese.main.services.twitch.TwitchConnectionService;
import kineese.main.view.MainForm;

public class ViewController {

	private MainForm mainForm;
	private TwitchConnectionService twitchConnectionService;
	private ChatService chatService;

	private DefaultStyledDocument doc;

	public ViewController() {
		mainForm = new MainForm(this);
		doc = new DefaultStyledDocument();
		mainForm.getTpChat().setStyledDocument(doc);
		chatService = new ChatService(doc);
		twitchConnectionService = new TwitchConnectionService();
	}

	public void Start() {
		mainForm.ShowUp();
	}

	public void connect() {
		try {
			if (!chatService.isConnected()) {
				chatService.connect();
			} else {
				chatService.disconnect();
			}

			twitchConnectionService.connect();
			GeatherInformations();
			UpdateLayout();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void GeatherInformations() {
		StreamInformation info = twitchConnectionService.getStreamInformations();
		mainForm.getTxtChatMembers().setText(Integer.toString(info.getAmountChatters()));
		mainForm.getTxtChatMembers().updateUI();
		mainForm.getTxtFollowers().setText(Integer.toString(info.getAmountFollowers()));
		mainForm.getTxtFollowers().updateUI();
		mainForm.getTxtViewers().setText(Integer.toString(info.getAmountViewers()));
		mainForm.getTxtViewers().updateUI();
		mainForm.getStreamTitle().setText(info.getStreamTitle());
		mainForm.getStreamTitle().updateUI();
	}

	private void UpdateLayout() {
		if (twitchConnectionService.isConnected()) {
			mainForm.getMiConnect().setText("Disconnect");
		} else {
			mainForm.getMiConnect().setText("Connect");
		}
		mainForm.getMiConnect().updateUI();
	}

	public void SendMessageToChat() {
		String message = mainForm.getChatInput().getText();
		chatService.sendMessage(message);
	}
}