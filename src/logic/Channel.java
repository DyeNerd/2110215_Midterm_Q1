package logic;

import java.util.ArrayList;

public class Channel {
	
	String name;
	ArrayList<Message> messageList;
	
	public Channel(String name) {
		setName(name);
		this.messageList = new ArrayList<Message>();
	}
	
	public void addMessage(Message message) {
		this.messageList.add(message);
	}
	
	public void setName(String name) {
		if (name.isBlank()) {
			this.name = "off-topic";
		}
		else {
			this.name = name;
		}
	}
	
	public int getMessageCount() {
		return this.messageList.size();
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Message> getMessageList(){
		return this.messageList;
	}
	
}
