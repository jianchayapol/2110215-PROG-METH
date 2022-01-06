package entity;

import entity.base.Entity;
import logic.GameController;
import logic.Sprites;

public class Flag extends Entity {
	
	public int getSymbol() {
		return Sprites.FLAG;
	}
	
	public boolean interact(Entity e) {
		if(e instanceof Player) {
			this.remove();
			GameController.setGameWin(true);
			return true;
		}
		return false;
	}
	
	
}
