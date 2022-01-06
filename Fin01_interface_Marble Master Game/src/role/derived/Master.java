package role.derived;

import game.logic.GameAction;
import game.object.GameObject;
import game.object.Card;
import game.object.Player;
import game.object.Player;
import role.base.PreRoundActable;
import role.base.Role;

public class Master extends Role implements PreRoundActable{

	@Override
	public void preRoundActs(GameAction action) {
		// TODO Auto-generated method stub
		int k = action.getInfo().size();
		for(int i=0; i<k; i++) {
			GameObject tmp = action.getInfo(i);
			((Card) tmp).setSlot(i);
		}
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Master";
	}
	
	

}
