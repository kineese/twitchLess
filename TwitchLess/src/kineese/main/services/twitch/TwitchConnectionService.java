package kineese.main.services.twitch;

import kineese.main.dataholders.StreamInformation;

public class TwitchConnectionService {

	private boolean connected;

	public boolean isConnected() {
		return connected;
	}

	public void connect() {
		connected = !connected;
	}

	public StreamInformation getStreamInformations() {
		StreamInformation infos = new StreamInformation("A Stream title", 6, 134, 4);
		return infos;
	}

}
