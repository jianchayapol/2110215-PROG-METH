package entity;

import entity.base.Entity;
import entity.base.Interactable;
import logic.GameController;
import logic.Sprites;

public class ColorBox extends Box implements Interactable{

	private boolean activeBool;
	
	public ColorBox (boolean activeBox) {
		setActiveBool(activeBool);
	}
	
	public int getSymbol() {
		if(getActiveBool()) return Sprites.BOX_RED;
		return Sprites.BOX_BLUE;
	}
	
	@Override
	public boolean interact(Entity e) {
		// TODO Auto-generated method stub
		if(GameController.getGameSwitchStatus()==this.getActiveBool()) {
			return move(e.getDirection());
		}
		return false;
	}

	public boolean getActiveBool() {
		return activeBool;
	}

	public void setActiveBool(boolean activeBool) {
		this.activeBool = activeBool;
	}

}
