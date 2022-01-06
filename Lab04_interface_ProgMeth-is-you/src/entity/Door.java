package entity;

import entity.base.Consumable;
import entity.base.Entity;
import entity.base.Interactable;
import logic.Sprites;

public class Door extends Entity implements Interactable, Consumable {

	public int getSymbol() {
		return Sprites.DOOR;
	}

	@Override
	public boolean interact(Entity e) {
		// TODO Auto-generated method stub
		if(e instanceof Key) { 
			return true;
		}
		return false;
	}

	@Override
	public boolean consume(Entity e) {
		// TODO Auto-generated method stub
		if(e instanceof Key) {
			this.remove();
			return true;
		}
		return false;
	}
}
