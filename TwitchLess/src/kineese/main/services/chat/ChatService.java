package kineese.main.services.chat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.jibble.pircbot.PircBot;

public class ChatService {
	private ChatBot bot;
	private DefaultStyledDocument doc;

	public ChatService(DefaultStyledDocument doc) {
		this.doc = doc;
	}

	public boolean connect() {
		PircBot bot = getBot();
		String token;
		try {
			token = readTokenFromFile();
			bot.setVerbose(true);
			String bla = bot.getLogin();
			bot.connect(ChatStaticVariables.ADDRESS, ChatStaticVariables.PORT, token);
			bot.joinChannel(ChatStaticVariables.CHANNEL);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NickAlreadyInUseException e) {
			e.printStackTrace();
		} catch (IrcException e) {
			e.printStackTrace();
		}
		return false;
	}

	private String readTokenFromFile() throws IOException {
		FileReader fileReader = new FileReader(ChatStaticVariables.TOKEN_POSITION);
		BufferedReader reader = new BufferedReader(fileReader);
		String token = reader.readLine();
		return token;
	}

	private ChatBot getBot() {
		if (bot == null) {
			bot = new ChatBot(this);
		}
		return bot;
	}

	public void passThoughMessage(MessageInfo msgInfo) {
		try {
			doc.insertString(doc.getLength(), msgInfo.convertToChatMessage() + "\n", null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String message) {
		getBot().sendMessage(ChatStaticVariables.CHANNEL, message);
	}

	public boolean isConnected() {
		return getBot().isConnected();
	}

	public void disconnect() {
		getBot().disconnect();
	}

}
