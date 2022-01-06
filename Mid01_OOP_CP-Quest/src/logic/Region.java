package logic;

import java.util.ArrayList;

public class Region {
	private String name;
	private ArrayList<Player> playerList;
	private ArrayList<Quest> questList;
	
	public Region(String name) {
		this.setName(name);
		this.playerList = new ArrayList<Player>();
		this.questList = new ArrayList<Quest>();
	}
	
	public void setName(String name) {
		String val = name;
		if(val.isBlank()) val = "Nowhere";
		this.name = val;
	}
	
	public int getPlayerCount() {
		return playerList.size();
	}
	
	public double getRegionRank() {
		double sum = 0;
		for(Player p : playerList) {
			sum+= p.getRank();
		}
		double val = ((sum/playerList.size())*100);
		val = Math.round(val);
		val = val/100;
		return val;
	}
	
	public ArrayList<Quest> getAvailableQuests(Player viewer){
		ArrayList<Quest> q = new ArrayList<Quest>();
		for(Quest x: questList) {
			if(x.getStatus().equals(Status.AVAILABLE) && !viewer.equals(x.getAuthor()) ) {
				q.add(x);
			}
		}
		return q;
	}
	
	public void addPlayerToRegion(Player p) {
		playerList.add(p);
	}
	
	public void addQuestToRegion(Quest q) {
		questList.add(q);
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public ArrayList<Quest> getQuestList() {
		return questList;
	}

	public void setQuestList(ArrayList<Quest> questList) {
		this.questList = questList;
	}

	public String getName() {
		return name;
	}
	
	
	
}
