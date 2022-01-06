package logic;

import java.util.ArrayList;

public class Database {
	private ArrayList<Player> playerList;
	private ArrayList<Region> regionList;
	
	
	public Database() {
		this.playerList = new ArrayList<Player>();
		this.regionList = new ArrayList<Region>();
	}
	
	public Database(ArrayList<Player> playerList,ArrayList<Region> regionList) {
		this.playerList = playerList;
		this.regionList = regionList;
	}
	
	public Player addPlayer(String name, Region region) throws Exception{
		
			if(!DatabaseUtil.isPlayerExists(playerList, name)) {
				Player p1 = new Player(name);
				region.addPlayerToRegion(p1);
				this.playerList.add(p1);
				return p1;
			}
			else {
				throw new Exception();
			}
	}
	
	public boolean addRegion(String name) {
		
		if(!DatabaseUtil.isRegionExists(regionList, name)) {
			Region r1 = new Region(name);
			regionList.add(r1);
			return true;
		}
		return false;
	}
	
	public Region getRegionByName(String name) {
		Region result = null;
		for(Region r : this.regionList) {
			if(r.getName().equals(name)) {
				result = r;
				break;
			}
		}
		return result;
	}
	
	public void addQuest(Player author, Region region, String name, String description) {
		Quest q = new Quest(author,region, name, description);
		region.addQuestToRegion(q);
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}

	public ArrayList<Region> getRegionList() {
		return regionList;
	}

	public void setRegionList(ArrayList<Region> regionList) {
		this.regionList = regionList;
	}
	
	
	
	
	
	
}
