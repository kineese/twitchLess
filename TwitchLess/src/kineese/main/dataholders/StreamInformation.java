package kineese.main.dataholders;

public class StreamInformation {

	private String streamTitle;
	private int amountViewers;
	private int amountFollowers;
	private int amountChatters;

	public StreamInformation(String streamTitle, int amountViewers, int amountFollowers, int amountChatters){
		this.streamTitle = streamTitle;
		this.amountViewers = amountViewers;
		this.amountFollowers = amountFollowers;
		this.amountChatters = amountChatters;
	}
	
	public int getAmountViewers() {
		return amountViewers;
	}

	public int getAmountFollowers() {
		return amountFollowers;
	}

	public int getAmountChatters() {
		return amountChatters;
	}
	
	public String getStreamTitle(){
		return streamTitle;
	}

}
