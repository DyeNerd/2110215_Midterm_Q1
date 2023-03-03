package logic;

import java.util.ArrayList;

public class Server {
	
	String name;
	User owner;
	ArrayList<Channel> channelList;
	ArrayList<User> memberList;
	
	public Server(String name, User owner, TemplateType template) {
		this.owner = owner;
		this.memberList = new ArrayList<User>();
		this.channelList = new ArrayList<Channel>();
		addUser(owner);
		setName(name);
		String channelName = null;
		switch (template) {
			case BASIC:
				channelName = "general";
				break;
			case GAMING:
				channelName = "gaming";
				break;
			case STUDY:
				channelName = "homework-help";
				break;
		}
		
		addChannel(owner, channelName);
		
	}
	
	public Channel addChannel(User user, String channelName) {
		if (user.equals(this.owner)) {
			Channel newChannel = new Channel(channelName);
			this.channelList.add(newChannel);
			return newChannel;
		}
		else {
			return null;
		}
	}
	
	public User addUser(User user) {
		if (!this.memberList.contains(user)) {
			this.memberList.add(user);
			user.addJoinedServersList(this);
			return user;
		}
		else {
			return null;
		}
	}
	
	public boolean kickUser(User kicker, User kicked) throws Exception {
		if (!this.owner.equals(kicker)) {
			throw new Exception();
		}
		else {
			if ((!this.memberList.contains(kicked))||(this.owner.equals(kicked))) {
				return false;
			}
			else {
				kicked.getJoinedServersList().remove(this);
				this.memberList.remove(kicked);
				return true;
			}
		}
	}
	
	public void setName(String name) {
		if (name.isBlank()) {
			this.name = this.owner.getName() + " home";
		}
		else {
			this.name = name;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public User getOwner() {
		return this.owner;
	}
	
	public ArrayList<Channel> getChannelList() {
		return this.channelList;
	}
	
	public ArrayList<User> getMemberList() {
		return this.memberList;
	}

	public boolean isMemberInServer(User currentUser) {
		// TODO Auto-generated method stub
		if (this.memberList.contains(currentUser)) {
			return true;
		}
		return false;
	}
	
}
